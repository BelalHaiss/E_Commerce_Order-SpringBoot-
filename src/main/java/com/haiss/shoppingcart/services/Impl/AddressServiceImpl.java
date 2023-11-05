package com.haiss.shoppingcart.services.Impl;

import com.haiss.shoppingcart.domain.DTO.address.CreateAddressDTO;
import com.haiss.shoppingcart.domain.DTO.address.UpdateAddressDTO;
import com.haiss.shoppingcart.domain.DTO.address.UserAddressesResponse;
import com.haiss.shoppingcart.domain.entity.Address;
import com.haiss.shoppingcart.domain.entity.User;
import com.haiss.shoppingcart.domain.mapping.AddressMapper;
import com.haiss.shoppingcart.exceptions.NotFoundException;
import com.haiss.shoppingcart.repository.AddressRepository;
import com.haiss.shoppingcart.security.validation.UserValidator;
import com.haiss.shoppingcart.services.AddressService;
import com.haiss.shoppingcart.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepo;

    private UserService userService;
    private AddressMapper mapper;

    AddressServiceImpl(AddressRepository addressRepo, AddressMapper mapper, UserService userService) {
        this.addressRepo = addressRepo;
        this.mapper = mapper;
        this.userService = userService;
    }

    @Override
    public void CreateAddress(Long userId, CreateAddressDTO addressDTO) {
        Address newAddress = mapper.mapToAddress(addressDTO);
        User user = userService.getUserById(userId);
        newAddress.setUser(user);
        addressRepo.save(newAddress);
    }

    @Override
    public void editById(Long addressId, UpdateAddressDTO addressDTO) {
        Address addressEntity = addressRepo.findById(addressId).orElseThrow(() ->
                new NotFoundException("Address is wrong"));
        UserValidator.isSame(addressEntity.getUser().getId());
        mapper.mapPatchAddress(addressDTO, addressEntity);
        addressRepo.save(addressEntity);
    }

    @Override
    public Address getAddressById(Long id) {
        return addressRepo.findById(id).orElseThrow(() -> new NotFoundException("Address not found"));
    }

    @Override
    public List<UserAddressesResponse> getUserAddress(Long id) {
        List<Address> addresses = addressRepo.findByUserId(id);
        return mapper.mapToUserAddresses(addresses);
    }
}
