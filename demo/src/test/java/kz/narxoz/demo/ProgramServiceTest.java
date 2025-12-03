package kz.narxoz.demo;

import kz.narxoz.demo.dto.ProgramDto;
import kz.narxoz.demo.dto.UserDto;
import kz.narxoz.demo.model.User;
import kz.narxoz.demo.service.ProgramService;
import kz.narxoz.demo.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest

public class ProgramServiceTest {
    @Autowired
    private ProgramService programService;

    @Test
    void getAllTest(){
        List<ProgramDto> programDto=programService.getAll();

        Assertions.assertNotNull(programDto);
        Assertions.assertNotEquals(0,programDto.size());
        for(int i=0;i<programDto.size();i++){
            ProgramDto dto=programDto.get(i);
            Assertions.assertNotNull(dto);
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getNameDto());
            Assertions.assertNotNull(dto.getDescriptionDto());

        }

    }


    @Test
    void getByIdTest(){
        Random random =new Random();
        int randomIndex=random.nextInt(programService.getAll().size());
        Long someIndex=programService.getAll().get(randomIndex).getId();
        ProgramDto userDto=programService.getById(someIndex);

        Assertions.assertNotNull(userDto);
        Assertions.assertNotNull(userDto.getId());
        Assertions.assertNotNull(userDto.getNameDto());
        Assertions.assertNotNull(userDto.getDescriptionDto());

        ProgramDto check=programService.getById(-1L);
        Assertions.assertNull(check);

    }
    @Test
    void addTest(){
        ProgramDto programDto=new ProgramDto();


        ProgramDto add=programService.addProgram(programDto);
        Assertions.assertNotNull(add);
        Assertions.assertNotNull(add.getId());
        Assertions.assertNotNull(add.getNameDto());
        Assertions.assertNotNull(add.getDescriptionDto());

        ProgramDto added=programService.getById(add.getId());



        Assertions.assertNotNull(added);
        Assertions.assertNotNull(added.getId());
        Assertions.assertNotNull(added.getNameDto());
        Assertions.assertNotNull(added.getDescriptionDto());

        Assertions.assertEquals(add.getId(),added.getId());
        Assertions.assertEquals(add.getNameDto(),added.getNameDto());
        Assertions.assertEquals(add.getDescriptionDto(),added.getDescriptionDto());





    }
    @Test
    void updateTest(){
        Random random =new Random();
        int randomIndex=random.nextInt(programService.getAll().size());
        Long someIndex=programService.getAll().get(randomIndex).getId();
        ProgramDto newProgram=UserDto.builder().id(someIndex).nameDto("ghjk").emailDto("ghjk").build();
        ProgramDto update=programService.updateProgram(newProgram.getId(),newProgram);

        Assertions.assertNotNull(update);
        Assertions.assertNotNull(update.getId());
        Assertions.assertNotNull(update.getNameDto());
        Assertions.assertNotNull(update.getDescriptionDto());

        Assertions.assertEquals(newProgram.getId(),update.getId());
        Assertions.assertEquals(newProgram.getNameDto(),update.getNameDto());
        Assertions.assertEquals(newProgram.getDescriptionDto(),update.getDescriptionDto());
        ProgramDto updated=programService.getById(someIndex);

        Assertions.assertNotNull(updated);
        Assertions.assertNotNull(updated.getId());
        Assertions.assertNotNull(updated.getNameDto());
        Assertions.assertNotNull(updated.getDescriptionDto());

        Assertions.assertEquals(update.getId(),updated.getId());
        Assertions.assertEquals(update.getNameDto(),updated.getNameDto());
        Assertions.assertEquals(update.getDescriptionDto(),updated.getDescriptionDto());



    }
    @Test
    void deleteTest(){

        Random random =new Random();
        int randomIndex=random.nextInt(programService.getAll().size());
        Long someIndex=programService.getAll().get(randomIndex).getId();
        Assertions.assertTrue(programService.deleteProgram(someIndex));
        UserDto deleted=programService.getById(someIndex);

    }

}
