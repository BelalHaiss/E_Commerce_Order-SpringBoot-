package com.haiss.shoppingcart.domain.mapping;

import com.haiss.shoppingcart.domain.DTO.UserResponse;
import com.haiss.shoppingcart.domain.DTO.UserWithRoleResponse;
import com.haiss.shoppingcart.domain.DTO.auth.ExtendedUserDetails;
import com.haiss.shoppingcart.domain.DTO.auth.RegisterDTO;
import com.haiss.shoppingcart.domain.entity.Role;
import com.haiss.shoppingcart.domain.entity.User;
import com.haiss.shoppingcart.domain.enums.RoleEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    User mapToUserEntity(RegisterDTO registerDTO);

    UserResponse mapToUserResponseWithOutRole(User userEntity);

    @Mapping(target = "authorities", ignore = true)
    ExtendedUserDetails mapToFullUserDetails(User userEnity);

    @Mapping(target = "roles", source = "roles", qualifiedByName = "mapRoles")
    UserWithRoleResponse mapToDTO(ExtendedUserDetails userDetails);

    @Named("mapRoles")
    default List<RoleEnum> mapRoles(List<Role> roles) {
        return roles.stream().map(Role::getName).map(RoleEnum::getValue).map(RoleEnum::fromValue).collect(Collectors.toList());
    }
}
