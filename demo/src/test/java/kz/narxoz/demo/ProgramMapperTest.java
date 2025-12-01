package kz.narxoz.demo;

import kz.narxoz.demo.dto.ProgramDto;
import kz.narxoz.demo.dto.UserDto;
import kz.narxoz.demo.mapper.ProgramMapper;
import kz.narxoz.demo.mapper.UserMapper;
import kz.narxoz.demo.model.Category;
import kz.narxoz.demo.model.Program;
import kz.narxoz.demo.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class ProgramMapperTest {
    @Autowired
    private ProgramMapper programMapper;
    @Test
    void convertEntityToDtoTest() {
        Program programEntity = new Program(1L, "yoga", "yoga is cool",new Category(),new ArrayList<>());
        ProgramDto programDto=programMapper.toDto(programEntity);

        Assertions.assertNotNull(programDto);
        Assertions.assertNotNull(programDto.getId());
        Assertions.assertNotNull(programDto.getNameDto());
        Assertions.assertNotNull(programDto.getDescriptionDto());

        Assertions.assertEquals(programEntity.getId(),programDto.getId());
        Assertions.assertEquals(programEntity.getName(),programDto.getNameDto());
        Assertions.assertEquals(programEntity.getDescription(),programDto.getDescriptionDto());

    }
    @Test
    void convertDtoToEntityTest(){
        ProgramDto dtoProgram = new ProgramDto(1L, "first", "first Programm");
        Program entityProgram = programMapper.toEntity(dtoProgram);

        Assertions.assertNotNull(entityProgram);

        Assertions.assertNotNull(entityProgram.getId());
        Assertions.assertNotNull(entityProgram.getName());
        Assertions.assertNotNull(entityProgram.getDescription());

        Assertions.assertEquals(dtoProgram.getId(), entityProgram.getId());
        Assertions.assertEquals(dtoProgram.getNameDto(), entityProgram.getName());
        Assertions.assertEquals(dtoProgram.getDescriptionDto(), entityProgram.getDescription());

    }
    @Test
    void convertEntityListToDtoListTest(){
        List<Program> programEntityList=new ArrayList<>();
        programEntityList.add(new Program(1L,"first program","first program is popular",new Category(),new ArrayList<>()));
        programEntityList.add(new Program(2L,"second program","second program is cool",new Category(),new ArrayList<>()));
        programEntityList.add(new Program(3L,"third program","third program is cool",new Category(),new ArrayList<>()));

        List<ProgramDto> programDtoList=programMapper.toDtoList(programEntityList);
        Assertions.assertNotNull(programDtoList);
        Assertions.assertNotEquals(0,programDtoList.size());
        Assertions.assertEquals(programEntityList.size(),programDtoList.size());

        for(int i=0;i<programDtoList.size();i++){
            Program programEntity=programEntityList.get(i);
            ProgramDto programDto=programDtoList.get(i);

            Assertions.assertNotNull(programDto);
            Assertions.assertNotNull(programDto.getId());
            Assertions.assertNotNull(programDto.getNameDto());
            Assertions.assertNotNull(programDto.getDescriptionDto());

            Assertions.assertEquals(programEntity.getId(),programDto.getId());
            Assertions.assertEquals(programEntity.getName(),programDto.getNameDto());
            Assertions.assertEquals(programEntity.getDescription(),programDto.getDescriptionDto());
        }
    }

}
