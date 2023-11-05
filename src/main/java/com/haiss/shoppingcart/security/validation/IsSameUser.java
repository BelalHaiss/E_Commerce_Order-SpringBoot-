package com.haiss.shoppingcart.security.validation;


import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.*;


@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@PreAuthorize("#userId == principal.id")
public @interface IsSameUser {
}
