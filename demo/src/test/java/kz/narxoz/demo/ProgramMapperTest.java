package kz.narxoz.demo;

import kz.narxoz.demo.dto.ProgramDto;
import kz.narxoz.demo.dto.UserDto;
import kz.narxoz.demo.mapper.ProgramMapper;
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
public class ProgramMapperTest {
    @Autowired
    private ProgramMapper  programMapper;

    @Test
    void convertEntityToDtoTest(){
        Program programEntity=new Program(1L,"kymbat","kymbat@gmail.com",new Category(),new ArrayList<>());
        ProgramDto programDto =programMapper.toDto(programEntity);

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
        ProgramDto programDto=new ProgramDto(1L,"gym","gym is cool");
        Program programEntity=programMapper.toEntity(programDto);

        Assertions.assertNotNull(programEntity);
        Assertions.assertNotNull(programEntity.getId());
        Assertions.assertNotNull(programEntity.getName());
        Assertions.assertNotNull(programEntity.getDescription());

        Assertions.assertEquals(programDto.getId(),programEntity.getId());
        Assertions.assertEquals(programDto.getNameDto(),programEntity.getName());
        Assertions.assertEquals(programDto.getDescriptionDto(),programEntity.getDescription());

    }
    @Test
    void convertEntityLitToDtoList(){
        List<Program> programEntityList=new ArrayList<>();
        programEntityList.add(new Program(1L,"kymbat","kymbat",new Category(),new ArrayList<>()));
        programEntityList.add(new Program(2L,"symbat","symbat",new Category(),new ArrayList<>()));
        programEntityList.add(new Program(3L,"zhanna","zhanna",new Category(),new ArrayList()));

        List<ProgramDto> programDtoList=programMapper.toDtoList(programEntityList);
        Assertions.assertNotNull(programDtoList);
        Assertions.assertNotEquals(0,programDtoList.size());

        for(int i=0;i<programDtoList.size();i++){
            ProgramDto programDto=programDtoList.get(i);
            Program programEntity=programEntityList.get(i);
            Assertions.assertNotNull(programDto);
            Assertions.assertNotNull(programDto.getId());
            Assertions.assertNotNull(programDto.getNameDto());
            Assertions.assertNotNull(programDto.getDescriptionDto());

            Assertions.assertEquals(programEntity.getId(),programDto.getId());
            Assertions.assertEquals(programEntity.getName(),programDto.getNameDto());
            Assertions.assertEquals(programEntity.getDescription(),programDto.getDescriptionDto());


        }

}}
