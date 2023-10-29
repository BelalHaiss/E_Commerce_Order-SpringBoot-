package com.haiss.shoppingcart.controllers;


import com.haiss.shoppingcart.domain.DTO.address.CreateAddressDTO;
import com.haiss.shoppingcart.domain.DTO.address.UpdateAddressDTO;
import com.haiss.shoppingcart.domain.entity.Address;
import com.haiss.shoppingcart.services.AddressService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private AddressService addressService;

    AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/{userId}")
    ResponseEntity<Void> createdAddress(@PathVariable("userId") Long userId, @Valid @RequestBody CreateAddressDTO addressDTO) {
        addressService.CreateAddress(userId, addressDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/{addId}")
    void updateAddress(@PathVariable("addId") Long addId, @Valid @RequestBody UpdateAddressDTO addressDTO) {
        addressService.editById(addId, addressDTO);
    }

    @GetMapping("/{userId}")
    List<Address> getUserAddress(@PathVariable("userId") Long userId) {
        return addressService.getUserAddress(userId);
    }


}
