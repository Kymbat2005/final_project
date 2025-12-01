package kz.narxoz.demo;

import kz.narxoz.demo.dto.ProgramDto;
import kz.narxoz.demo.dto.UserDto;
import kz.narxoz.demo.mapper.UserMapper;
import kz.narxoz.demo.model.Category;
import kz.narxoz.demo.model.Program;
import kz.narxoz.demo.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void convertEntityToDtoTest(){
        User userEntity=new User(1L,"kymbat","kymbat@gmail.com");
        UserDto userDto=userMapper.toDto(userEntity);

        Assertions.assertNotNull(userDto);
        Assertions.assertNotNull(userDto.getId());
        Assertions.assertNotNull(userDto.getNameDto());
        Assertions.assertNotNull(userDto.getEmailDto());

        Assertions.assertEquals(userEntity.getId(),userDto.getId());
        Assertions.assertEquals(userEntity.getName(),userDto.getNameDto());
        Assertions.assertEquals(userEntity.getEmail(),userDto.getEmailDto());
    }
    @Test
    void convertDtoToEntityTest() {
        UserDto userDto = new UserDto(1L, "kymbat", "kymbat@gmail.com");

        User userEntity = userMapper.toEntity(userDto);

        Assertions.assertNotNull(userEntity);
        Assertions.assertNotNull(userEntity.getId());
        Assertions.assertNotNull(userEntity.getName());
        Assertions.assertNotNull(userEntity.getEmail());

        Assertions.assertEquals(userDto.getId(), userEntity.getId());
        Assertions.assertEquals(userDto.getNameDto(), userEntity.getName());
        Assertions.assertEquals(userDto.getEmailDto(), userEntity.getEmail());
    }

    @Test
    void convertEntityListToDtoListTest(){
        List<User> userEntityList=new ArrayList<>();
        userEntityList.add(new User(1L,"kymbat","kymbat@gmail.com"));
        userEntityList.add(new User(2L,"symbat","symbat@gmail.com"));
        userEntityList.add(new User(3L,"arina","arina@gmail.com"));

        List<UserDto> userDtoList=userMapper.toDtoList(userEntityList);
        Assertions.assertNotNull(userDtoList);
        Assertions.assertNotEquals(0,userDtoList.size());
        Assertions.assertEquals(userEntityList.size(),userDtoList.size());

        for(int i=0;i<userDtoList.size();i++){
            User userEntity=userEntityList.get(i);
            UserDto userDto=userDtoList.get(i);

            Assertions.assertNotNull(userDto);
            Assertions.assertNotNull(userDto.getId());
            Assertions.assertNotNull(userDto.getNameDto());
            Assertions.assertNotNull(userDto.getEmailDto());

            Assertions.assertEquals(userEntity.getId(),userDto.getId());
            Assertions.assertEquals(userEntity.getName(),userDto.getNameDto());
            Assertions.assertEquals(userEntity.getEmail(),userDto.getEmailDto());
        }
    }
}
