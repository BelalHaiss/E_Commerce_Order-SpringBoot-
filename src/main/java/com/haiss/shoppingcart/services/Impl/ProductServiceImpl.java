package com.haiss.shoppingcart.services.Impl;

import com.haiss.shoppingcart.domain.DTO.PaginationResponse;
import com.haiss.shoppingcart.domain.DTO.Product.CreateProductDTO;
import com.haiss.shoppingcart.domain.DTO.Product.ProductResponse;
import com.haiss.shoppingcart.domain.DTO.Product.UpdateProductDTO;
import com.haiss.shoppingcart.domain.DTO.orderProduct.CreateOrderProductDTO;
import com.haiss.shoppingcart.domain.entity.Product;
import com.haiss.shoppingcart.domain.enums.ProductStatus;
import com.haiss.shoppingcart.domain.mapping.ProductMapper;
import com.haiss.shoppingcart.exceptions.NotFoundException;
import com.haiss.shoppingcart.repository.ProductRepository;
import com.haiss.shoppingcart.services.ProductService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepo;
    private final ProductMapper productMapper;

    ProductServiceImpl(ProductRepository repo, ProductMapper mapper) {
        productRepo = repo;
        productMapper = mapper;
    }

    @Override
    public void createProduct(CreateProductDTO product) {
        Product newProduct = productMapper.mapToProductEntity(product);
        productRepo.save(newProduct);
    }

    @Override
    public ProductResponse getProductById(Long id) {
        Product product = findProductById(id);
        return productMapper.mapToProductResponse(product);
    }

    @Override
    public Product findProductById(Long id) {
        return productRepo.findById(id).orElseThrow(() -> new NotFoundException("no product found"));
    }

    @Override
    public PaginationResponse<ProductResponse> findProductsWithPagination(int pageNo, int pageSize) {
        Pageable pagination = PageRequest.of(pageNo, pageSize);

        Page<Product> productPage = productRepo.findAllByStatus(ProductStatus.AVAILABLE, pagination);
        PaginationResponse<ProductResponse> response = new PaginationResponse<>();
        response.setContent(productMapper.mapToProductResponse(productPage.toList()));
        response.setTotalPages(productPage.getTotalPages());
        response.setLast(productPage.isLast());
        response.setTotalElments(productPage.getTotalElements());
        response.setTotalPages(productPage.getTotalPages());
        response.setPageNo(pageNo);
        response.setPageSize(pageSize);
        return response;
    }

    @Override
    public void updateById(Long id, UpdateProductDTO productDTO) {
        Product productEntity = findProductById(id);
        productMapper.mapPatchProductEntity(productDTO, productEntity);
        productRepo.save(productEntity);
    }

    @Override
    public void removeById(Long id) {
        Product productEntity = findProductById(id);
        productEntity.setStatus(ProductStatus.DELETED);
        productRepo.save(productEntity);
    }

    @Override
    public Product validateOrderProduct(CreateOrderProductDTO orderProductDTO) {
        Product product = findProductById(orderProductDTO.getProductId());
//        validate status & qty
        if (product.getQty() < orderProductDTO.getQty() || product.getStatus() != ProductStatus.AVAILABLE)
            throw new DataIntegrityViolationException("validation failed");
        return product;
    }

    @Override
    public void changeProductQty(long productId, int qty) {
        Product product = findProductById(productId);
        product.setQty(product.getQty() - qty);
        productRepo.save(product);

    }


}
