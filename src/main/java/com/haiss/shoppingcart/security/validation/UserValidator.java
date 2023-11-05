package com.haiss.shoppingcart.security.validation;

import com.haiss.shoppingcart.domain.DTO.auth.ExtendedUserDetails;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    public static boolean isSame(Long userId) throws AccessDeniedException {
        UserValidator instance = new UserValidator();
        ExtendedUserDetails currentUser = instance.getUserDetails();
        if (currentUser == null || !currentUser.getId().equals(userId))
            throw new AccessDeniedException("not Authorized");
        return true;
    }


    private ExtendedUserDetails getUserDetails() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            return (ExtendedUserDetails) authentication.getPrincipal();
        } catch (Exception ex) {
            return null;
        }
    }

}