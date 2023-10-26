package com.haiss.shoppingcart.services.Impl;

import com.haiss.shoppingcart.domain.DTO.PaginationResponse;
import com.haiss.shoppingcart.domain.DTO.Product.CreateProductDTO;
import com.haiss.shoppingcart.domain.DTO.Product.UpdateProductDTO;
import com.haiss.shoppingcart.domain.entity.Product;
import com.haiss.shoppingcart.domain.mapping.ProductMapper;
import com.haiss.shoppingcart.exceptions.NotFoundException;
import com.haiss.shoppingcart.repository.ProductRepository;
import com.haiss.shoppingcart.services.ProductService;
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
    public Product createProduct(CreateProductDTO product) {
        Product newProduct = productMapper.mapToProductEntity(product);
        return productRepo.save(newProduct);
    }

    @Override
    public Product findProductById(Long id) throws NotFoundException {
        return productRepo.findById(id).orElseThrow(() -> new NotFoundException("no product found"));
    }

    @Override
    public PaginationResponse<Product> findProductsWithPagination(int pageNo, int pageSize) {
       Pageable pagination = PageRequest.of(pageNo,pageSize);

        Page<Product> productPage = productRepo.findAll(pagination);
        PaginationResponse<Product> response = new PaginationResponse<>();
        response.setContent(productPage.toList());
        response.setTotalPages(productPage.getTotalPages());
        response.setLast(productPage.isLast());
        response.setTotalElments(productPage.getTotalElements());
        response.setTotalPages(productPage.getTotalPages());
        response.setPageNo(pageNo);
        response.setPageSize(pageSize);
        return  response;
    }

    @Override
    public void updateById(Long id, UpdateProductDTO productDTO) throws NotFoundException {
        Product productEntity = productRepo.findById(id).orElseThrow(() -> new NotFoundException("no product found"));
        productMapper.mapPatchProductEntity(productDTO, productEntity);
        productRepo.save(productEntity);
    }

    @Override
    public void removeById(Long id) {
        productRepo.deleteById(id);
    }
}
