package com.haiss.shoppingcart.services.Impl;

import com.haiss.shoppingcart.domain.DTO.PaginationResponse;
import com.haiss.shoppingcart.domain.DTO.Product.CreateProductDTO;
import com.haiss.shoppingcart.domain.DTO.Product.UpdateProductDTO;
import com.haiss.shoppingcart.domain.entity.Product;
import com.haiss.shoppingcart.exceptions.NotFoundException;
import com.haiss.shoppingcart.mappings.ProductMappings.ProductToEntity;
import com.haiss.shoppingcart.repository.ProductRepository;
import com.haiss.shoppingcart.services.ProductService;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService {

    final private ProductRepository productRepo;

    ProductServiceImpl(ProductRepository repo) {
        productRepo = repo;
    }

    @Override
    public Product createProduct(CreateProductDTO product) {
        ProductToEntity<CreateProductDTO> mapper = new ProductToEntity<>();
        Product newProduct = mapper.apply(product);
        return productRepo.save(newProduct);
    }

    @Override
    public Product findProductById(Long id) throws NotFoundException {
        return productRepo.findById(id).orElseThrow(() -> new NotFoundException("no product found"));
    }

    @Override
    public PaginationResponse<Product> findProductsWithPagination(int pageNo, int pageSize) {
        return null;
    }

    @Override
    public void updateById(Long id, UpdateProductDTO product) throws NotFoundException {

    }

    @Override
    public void removeById(Long id) {

    }
}
