package kz.narxoz.demo;

import kz.narxoz.demo.dto.CategoryDto;
import kz.narxoz.demo.dto.UserDto;
import kz.narxoz.demo.mapper.CategoryMapper;
import kz.narxoz.demo.model.Category;
import kz.narxoz.demo.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CategoryMapperTest {
    @Autowired
    private CategoryMapper categoryMapper;
    @Test
    void convertEntityToDtoTest(){
        Category categoryEntity=new Category(1L,"kymbat");
        CategoryDto categoryDto =categoryMapper.toDto(categoryEntity);

        Assertions.assertNotNull(categoryDto);
        Assertions.assertNotNull(categoryDto.getId());
        Assertions.assertNotNull(categoryDto.getNameDto());


        Assertions.assertEquals(categoryEntity.getId(),categoryDto.getId());
        Assertions.assertEquals(categoryEntity.getName(),categoryDto.getNameDto());

    }
    @Test
    void convertDtoToEntityTest(){
        CategoryDto categoryDto =new CategoryDto(1L,"kymbat");
        Category categoryEntity=categoryMapper.toEntity(categoryDto);

        Assertions.assertNotNull(categoryEntity);
        Assertions.assertNotNull(categoryEntity.getId());
        Assertions.assertNotNull(categoryEntity.getName());


        Assertions.assertEquals(categoryDto.getId(),categoryEntity.getId());
        Assertions.assertEquals(categoryDto.getNameDto(),categoryEntity.getName());


    }
    @Test
    void convertEntityLitToDtoList(){
        List<Category> categoryEntityList=new ArrayList<>();
        categoryEntityList.add(new Category(1L,"kymbat"));
        categoryEntityList.add(new Category(2L,"symbat"));
        categoryEntityList.add(new Category(3L,"zhanna"));

        List<CategoryDto> categoryDtoList=categoryMapper.toDtoList(categoryEntityList);
        Assertions.assertNotNull(categoryDtoList);
        Assertions.assertNotEquals(0,categoryDtoList.size());

        for(int i=0;i<categoryDtoList.size();i++){
            CategoryDto categoryDto=categoryDtoList.get(i);
            Category categoryEntity=categoryEntityList.get(i);
            Assertions.assertNotNull(categoryDto);
            Assertions.assertNotNull(categoryDto.getId());
            Assertions.assertNotNull(categoryDto.getNameDto());


            Assertions.assertEquals(categoryEntity.getId(),categoryDto.getId());
            Assertions.assertEquals(categoryEntity.getName(),categoryDto.getNameDto());



        }


    }
}
