package com.haiss.shoppingcart.domain.mapping;


import com.haiss.shoppingcart.domain.DTO.Product.CreateProductDTO;
import com.haiss.shoppingcart.domain.Interfaces.IAddress;
import com.haiss.shoppingcart.domain.Interfaces.IProduct;
import com.haiss.shoppingcart.domain.entity.Address;
import com.haiss.shoppingcart.domain.entity.Product;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AddressMapper {

      Address mapToAddress (IAddress addressDTO);
    void mapPatchAddress (IAddress addressDTO,  @MappingTarget Address address);
}
