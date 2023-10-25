package com.haiss.shoppingcart.mappings.ProductMappings;

import com.haiss.shoppingcart.domain.Interfaces.IProduct;
import com.haiss.shoppingcart.domain.entity.Product;

import java.util.function.Function;

public class ProductToEntity <T  extends IProduct> implements Function<T, Product> {
    @Override
    public Product apply(T productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setQty(productDTO.getQty());
        product.setImage(productDTO.getImage());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        return  product;
    }
}
