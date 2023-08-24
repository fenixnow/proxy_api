package ru.fenix.proxy_api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;
import ru.fenix.proxy_api.dtos.SignUpDto;
import ru.fenix.proxy_api.dtos.UserDto;
import ru.fenix.proxy_api.entities.UserEntity;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserDto toUserDto(UserEntity userEntity);

    @Mapping(target = "password", ignore = true)
    UserEntity signUpToUser(SignUpDto signUpDto);

}
