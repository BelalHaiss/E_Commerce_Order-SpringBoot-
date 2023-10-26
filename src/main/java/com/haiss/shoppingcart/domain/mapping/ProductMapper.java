package com.haiss.shoppingcart.domain.mapping;


import com.haiss.shoppingcart.domain.DTO.Product.CreateProductDTO;
import com.haiss.shoppingcart.domain.Interfaces.IProduct;
import com.haiss.shoppingcart.domain.entity.Product;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {

    CreateProductDTO mapToProductDTO(Product productEntity);
    Product mapToProductEntity (IProduct productDTO);
    void mapPatchProductEntity (IProduct productDto,  @MappingTarget Product product);
}
