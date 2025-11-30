package kz.narxoz.demo.mapper;


import kz.narxoz.demo.dto.UserDto;
import kz.narxoz.demo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "nameDto",source = "name")
    @Mapping(target = "emailDto",source = "email")
    UserDto toDto(User user);

    @Mapping(target = "name",source = "nameDto")
    @Mapping(target = "email",source = "emailDto")
    User toEntity(UserDto userDto);


    List<UserDto> toDtoList(List<User> user);
}