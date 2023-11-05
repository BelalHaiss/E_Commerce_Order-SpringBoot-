package com.haiss.shoppingcart.controllers;


import com.haiss.shoppingcart.domain.DTO.address.CreateAddressDTO;
import com.haiss.shoppingcart.domain.DTO.address.UpdateAddressDTO;
import com.haiss.shoppingcart.domain.DTO.address.UserAddressesResponse;
import com.haiss.shoppingcart.security.validation.IsSameUser;
import com.haiss.shoppingcart.services.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;


    @PostMapping("/{userId}")
    @IsSameUser
    ResponseEntity<Void> createdAddress(@PathVariable("userId") Long userId, @Valid @RequestBody CreateAddressDTO addressDTO) {
        addressService.CreateAddress(userId, addressDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/{addId}")
    void updateAddress(@PathVariable("addId") Long addId, @Valid @RequestBody UpdateAddressDTO addressDTO) {
        addressService.editById(addId, addressDTO);
    }

    @GetMapping("/{userId}")
    @IsSameUser
    List<UserAddressesResponse> getUserAddress(@PathVariable("userId") Long userId) {
        return addressService.getUserAddress(userId);
    }


}
