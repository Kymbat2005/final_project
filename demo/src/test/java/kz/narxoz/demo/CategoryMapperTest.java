package kz.narxoz.demo;


import kz.narxoz.demo.dto.CategoryDto;
import kz.narxoz.demo.mapper.CategoryMapper;
import kz.narxoz.demo.model.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;
@SpringBootTest
@ActiveProfiles("test")
public class CategoryMapperTest {

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    void convertEntityToDtoTest(){
        Category categoryEntity = new Category(1L,"first");
        CategoryDto categoryDto = categoryMapper.toDto(categoryEntity);

        Assertions.assertNotNull(categoryDto);

        Assertions.assertNotNull(categoryDto.getId());
        Assertions.assertNotNull(categoryDto.getNameDto());

        Assertions.assertEquals(categoryEntity.getId(), categoryDto.getId());
        Assertions.assertEquals(categoryEntity.getName(), categoryDto.getNameDto());
    }

    @Test
    void convertDtoToEntityTest(){
        CategoryDto categoryDto = new CategoryDto(1L,"first");
        Category categoryEntity = categoryMapper.toEntity(categoryDto);

        Assertions.assertNotNull(categoryEntity);

        Assertions.assertNotNull(categoryEntity.getId());
        Assertions.assertNotNull(categoryEntity.getName());

        Assertions.assertEquals(categoryDto.getId(),categoryEntity.getId());
        Assertions.assertEquals(categoryDto.getNameDto(),categoryEntity.getName());
    }

    @Test
    void convertListCategoryEntityToListCategoryDtoTest(){
        List<Category> entityList = new ArrayList<>();
        entityList.add(new Category(1L,"first"));
        entityList.add(new Category(2L,"second"));
        entityList.add(new Category(3L,"third"));

        List<CategoryDto> dtoList = categoryMapper.toDtoList(entityList);

        Assertions.assertNotNull(dtoList);
        Assertions.assertNotEquals(0,dtoList.size());
        Assertions.assertEquals(entityList.size(), dtoList.size());

        for(int i = 0; i < entityList.size();i++){
            Category category = entityList.get(i);
            CategoryDto categoryDto = categoryMapper.toDto(category);

            Assertions.assertNotNull(categoryDto);

            Assertions.assertNotNull(categoryDto.getId());
            Assertions.assertNotNull(categoryDto.getNameDto());

            Assertions.assertEquals(category.getId(), categoryDto.getId());
            Assertions.assertEquals(category.getName(), categoryDto.getNameDto());
        }


    }
}