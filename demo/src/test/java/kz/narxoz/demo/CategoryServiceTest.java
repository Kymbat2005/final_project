package kz.narxoz.demo;


import kz.narxoz.demo.dto.CategoryDto;
import kz.narxoz.demo.service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Random;

@SpringBootTest
@ActiveProfiles("test")
public class CategoryServiceTest {
    @Autowired
    private CategoryService categoryService;

    private CategoryDto createOne(){
        CategoryDto cat = new CategoryDto();
        cat.setNameDto("test");
        return categoryService.addCategory(cat);
    }

    @Test
    void getAllTest(){
        createOne();
        List<CategoryDto> catDtos = categoryService.getAll();

        Assertions.assertNotNull(catDtos);

        Assertions.assertNotEquals(0, catDtos.size());

        for(int i = 0; i< catDtos.size();i++){
            CategoryDto categoryDto = catDtos.get(i);

            Assertions.assertNotNull(categoryDto);
            Assertions.assertNotNull(categoryDto.getId());
            Assertions.assertNotNull(categoryDto.getNameDto());
        }
    }

    @Test
    void getById(){
        createOne();
        Random random = new Random();
        int randomIndex = random.nextInt(categoryService.getAll().size());
        Long someId = categoryService.getAll().get(randomIndex).getId();

        CategoryDto categoryDto = categoryService.getById(someId);
        Assertions.assertNotNull(categoryDto);
        Assertions.assertNotNull(categoryDto.getId());
        Assertions.assertNotNull(categoryDto.getNameDto());

        CategoryDto check = categoryService.getById(-1L);
        Assertions.assertNull(check);
    }
    @Test
    void addCategoryTest(){
        createOne();
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setNameDto("testttt");

        CategoryDto created = categoryService.addCategory(categoryDto);
        Assertions.assertNotNull(created);
        Assertions.assertNotNull(created.getId());
        Assertions.assertNotNull(created.getNameDto());

        Assertions.assertEquals(categoryDto.getNameDto(), created.getNameDto());

        CategoryDto getDto = categoryService.getById(created.getId());
        Assertions.assertNotNull(getDto);
        Assertions.assertNotNull(getDto.getId());
        Assertions.assertNotNull(getDto.getNameDto());

        Assertions.assertEquals(created.getId(), getDto.getId());
        Assertions.assertEquals(created.getNameDto(), getDto.getNameDto());
    }
    @Test
    void updateCategoryTest(){
        createOne();
        Random random = new Random();
        int randomIndex = random.nextInt(categoryService.getAll().size());
        Long someId = categoryService.getAll().get(randomIndex).getId();

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(someId);
        categoryDto.setNameDto("teest");

        CategoryDto before = categoryService.updateCategory(someId,categoryDto);
        Assertions.assertNotNull(before);
        Assertions.assertNotNull(before.getId());
        Assertions.assertNotNull(before.getNameDto());

        Assertions.assertEquals(categoryDto.getNameDto(), before.getNameDto());

        CategoryDto after = categoryService.getById(someId);
        Assertions.assertNotNull(after);
        Assertions.assertNotNull(after.getId());
        Assertions.assertNotNull(after.getNameDto());

        Assertions.assertEquals(before.getNameDto(), after.getNameDto());
    }
    @Test
    void deleteCategoryTest(){
        createOne();
        Random random = new Random();
        int randomIndex = random.nextInt(categoryService.getAll().size());
        Long someId = categoryService.getAll().get(randomIndex).getId();
        Assertions.assertTrue(categoryService.deleteCategory(someId));

        CategoryDto categoryDto = categoryService.getById(someId);
        Assertions.assertNull(categoryDto);

    }

}