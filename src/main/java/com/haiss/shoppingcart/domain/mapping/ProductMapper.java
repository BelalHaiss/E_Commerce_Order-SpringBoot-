package com.haiss.shoppingcart.domain.mapping;


import com.haiss.shoppingcart.domain.DTO.Product.CreateProductDTO;
import com.haiss.shoppingcart.domain.DTO.Product.ProductResponse;
import com.haiss.shoppingcart.domain.Interfaces.IProduct;
import com.haiss.shoppingcart.domain.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {

    CreateProductDTO mapToProductDTO(Product productEntity);

    Product mapToProductEntity(IProduct productDTO);

    ProductResponse mapToProductResponse(Product product);

    List<ProductResponse> mapToProductResponse(List<Product> productList);

    void mapPatchProductEntity(IProduct productDto, @MappingTarget Product product);
}
