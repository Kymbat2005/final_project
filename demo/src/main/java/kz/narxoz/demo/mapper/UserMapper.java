package kz.narxoz.demo.mapper;

import kz.narxoz.demo.dto.UserDto;
import kz.narxoz.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;
@Mapper
@RequiredArgsConstructor
public class UserMapper {

    UserDto toDto (User user);
    User toEntity (UserDto UserDto);
    List<UserDto> toDtoList(List<User> users);



}
