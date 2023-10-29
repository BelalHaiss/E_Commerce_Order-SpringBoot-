package com.haiss.shoppingcart.services;

import com.haiss.shoppingcart.domain.DTO.address.CreateAddressDTO;
import com.haiss.shoppingcart.domain.DTO.address.UpdateAddressDTO;
import com.haiss.shoppingcart.domain.entity.Address;

import java.util.List;

public interface AddressService {

    void CreateAddress(Long userId, CreateAddressDTO addressDTO);

    void editById(Long addressId, UpdateAddressDTO addressDTO);

    List<Address> getUserAddress(Long id);
}
