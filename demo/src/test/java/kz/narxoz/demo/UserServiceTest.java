package kz.narxoz.demo;

import kz.narxoz.demo.dto.UserDto;
import kz.narxoz.demo.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;


    @Test
    void getAllTest(){
        List<UserDto> userDto= userService.getAll();

        Assertions.assertNotNull(userDto);

        Assertions.assertNotEquals(0,userDto.size());

        for(int i=0;i<userDto.size();i++){
            UserDto dto=userDto.get(i);
            Assertions.assertNotNull(dto);
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getNameDto());
            Assertions.assertNotNull(dto.getEmailDto());
        }
    }


    @Test
    void getByIdTest(){
        Random  random=new Random();
        int randomIndex=random.nextInt(userService.getAll().size());
        Long someIndex=userService.getAll().get(randomIndex).getId();
        UserDto userDto=userService.getById(someIndex);

        Assertions.assertNotNull(userDto);

        Assertions.assertNotNull(userDto.getId());
        Assertions.assertNotNull(userDto.getNameDto());
        Assertions.assertNotNull(userDto.getEmailDto());

        UserDto check=userService.getById(-1L);
        Assertions.assertNull(check);
    }




    @Test
    void addTest(){
        UserDto userDto=new UserDto();
        userDto.setNameDto("Zhanna");
        userDto.setEmailDto("zhanna@gmail.com");

        UserDto add=userService.addUser(userDto);

        Assertions.assertNotNull(add);
        Assertions.assertNotNull(add.getId());
        Assertions.assertNotNull(add.getNameDto());
        Assertions.assertNotNull(add.getEmailDto());

        UserDto added=userService.getById(add.getId());

        Assertions.assertNotNull(added);
        Assertions.assertNotNull(added.getId());
        Assertions.assertNotNull(added.getNameDto());
        Assertions.assertNotNull(added.getEmailDto());

        Assertions.assertEquals(add.getId(),added.getId());
        Assertions.assertEquals(add.getNameDto(),added.getNameDto());
        Assertions.assertEquals(add.getEmailDto(),added.getEmailDto());

    }




    @Test
    void updateTest(){
        Random random =new Random();
        int randomIndex=random.nextInt(userService.getAll().size());
        Long someIndex=userService.getAll().get(randomIndex).getId();
        UserDto newUser=UserDto
                .builder()
                .id(someIndex)
                .nameDto("Sara")
                .emailDto("sara@gmail.com")
                .build();
        UserDto update=userService.updateUser(newUser.getId(),newUser);
        Assertions.assertNotNull(update);

        Assertions.assertNotNull(update.getId());
        Assertions.assertNotNull(update.getNameDto());
        Assertions.assertNotNull(update.getEmailDto());

        Assertions.assertEquals(newUser.getId(),update.getId());
        Assertions.assertEquals(newUser.getNameDto(),update.getNameDto());
        Assertions.assertEquals(newUser.getEmailDto(),update.getEmailDto());

        UserDto updatedUser=userService.getById(someIndex);

        Assertions.assertNotNull(updatedUser);

        Assertions.assertNotNull(update.getId());
        Assertions.assertNotNull(update.getNameDto());
        Assertions.assertNotNull(update.getEmailDto());

        Assertions.assertEquals(update.getId(),updatedUser.getId());
        Assertions.assertEquals(update.getNameDto(),updatedUser.getNameDto());
        Assertions.assertEquals(update.getEmailDto(),updatedUser.getEmailDto());



    }
    @Test
    void deleteTest(){
        Random random=new Random();
        int randomIndex=random.nextInt(userService.getAll().size());
        Long someIndex=userService.getAll().get(randomIndex).getId();
        Assertions.assertTrue(userService.deleteUser(someIndex));
        UserDto deleted=userService.getById(someIndex);
        Assertions.assertNull(deleted);

    }


}