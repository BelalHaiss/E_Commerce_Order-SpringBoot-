package com.haiss.shoppingcart.domain.mapping;


import com.haiss.shoppingcart.domain.DTO.address.UserAddressesResponse;
import com.haiss.shoppingcart.domain.Interfaces.IAddress;
import com.haiss.shoppingcart.domain.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AddressMapper {

    Address mapToAddress(IAddress addressDTO);

    void mapPatchAddress(IAddress addressDTO, @MappingTarget Address address);

    List<UserAddressesResponse> mapToUserAddresses(List<Address> addresses);
}
