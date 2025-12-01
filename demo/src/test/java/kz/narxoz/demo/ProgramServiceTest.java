package kz.narxoz.demo;


import kz.narxoz.demo.dto.ProgramDto;
import kz.narxoz.demo.service.ProgramService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Random;
@SpringBootTest
@ActiveProfiles("test")
public class    ProgramServiceTest {

    @Autowired
    private ProgramService programService;

    private ProgramDto createOne(){
        ProgramDto programDto = new ProgramDto();
        programDto.setNameDto("test1");
        programDto.setDescriptionDto("desc1");
        return programService.addProgram(programDto);
    }
    @Test
    void getAllTest(){
        createOne();
        List<ProgramDto> programDtos = programService.getall();

        Assertions.assertNotNull(programDtos);
        Assertions.assertNotEquals(0,programDtos.size());

        for(int i = 0; i<programDtos.size();i++){
            ProgramDto programDto = programDtos.get(i);
            Assertions.assertNotNull(programDto);
            Assertions.assertNotNull(programDto.getId());
            Assertions.assertNotNull(programDto.getNameDto());
            Assertions.assertNotNull(programDto.getDescriptionDto());
        }
    }

    @Test
    void getByIdTest(){
        createOne();
        Random random = new Random();
        int randomIndex = random.nextInt(programService.getall().size());

        Long someId = programService.getall().get(randomIndex).getId();
        ProgramDto programDto = programService.getById(someId);

        Assertions.assertNotNull(programDto);
        Assertions.assertNotNull(programDto.getId());
        Assertions.assertNotNull(programDto.getNameDto());
        Assertions.assertNotNull(programDto.getDescriptionDto());

        ProgramDto check = programService.getById(-1L);
        Assertions.assertNull(check);
    }

    @Test
    void addProgramTest(){
        createOne();
        ProgramDto programDto = new ProgramDto();
        programDto.setNameDto("aaa");
        programDto.setDescriptionDto("asdsd");

        ProgramDto created = programService.addProgram(programDto);

        Assertions.assertNotNull(created);
        Assertions.assertNotNull(created.getId());
        Assertions.assertNotNull(created.getNameDto());
        Assertions.assertNotNull(created.getDescriptionDto());

        Assertions.assertEquals(programDto.getNameDto(), created.getNameDto());
        Assertions.assertEquals(programDto.getDescriptionDto(), created.getDescriptionDto());

        ProgramDto getProgram = programService.getById(created.getId());

        Assertions.assertNotNull(getProgram);
        Assertions.assertNotNull(getProgram.getId());
        Assertions.assertNotNull(getProgram.getNameDto());
        Assertions.assertNotNull(getProgram.getDescriptionDto());

        Assertions.assertEquals(created.getId(), getProgram.getId());
        Assertions.assertEquals(created.getNameDto(), getProgram.getNameDto());
        Assertions.assertEquals(created.getDescriptionDto(), getProgram.getDescriptionDto());

    }
    @Test
    void updateProgramTest(){
        createOne();
        Random random = new Random();
        int randomIndex = random.nextInt(programService.getall().size());
        Long someId = programService.getall().get(randomIndex).getId();
        ProgramDto programDto = new ProgramDto();
        programDto.setNameDto("bbbbb");
        programDto.setDescriptionDto("asfkjdsfgjb");

        ProgramDto before = programService.update(someId,programDto);

        Assertions.assertNotNull(before);
        Assertions.assertNotNull(before.getId());
        Assertions.assertNotNull(before.getNameDto());
        Assertions.assertNotNull(before.getDescriptionDto());

        Assertions.assertEquals(programDto.getNameDto(), before.getNameDto());
        Assertions.assertEquals(programDto.getDescriptionDto(), before.getDescriptionDto());

        ProgramDto after = programService.getById(someId);
        Assertions.assertNotNull(after);
        Assertions.assertNotNull(after.getId());
        Assertions.assertNotNull(after.getNameDto());
        Assertions.assertNotNull(after.getDescriptionDto());

        Assertions.assertEquals(before.getId(), after.getId());
        Assertions.assertEquals(before.getNameDto(), after.getNameDto());
        Assertions.assertEquals(before.getDescriptionDto(), after.getDescriptionDto());

    }
    @Test
    void deleteProgramTest(){
        Random random = new Random();
        int randomIndex = random.nextInt(programService.getall().size());
        Long someId = programService.getall().get(randomIndex).getId();

        Assertions.assertTrue(programService.deleteProgram(someId));

        ProgramDto programDto = programService.getById(someId);

        Assertions.assertNull(programDto);
    }
}