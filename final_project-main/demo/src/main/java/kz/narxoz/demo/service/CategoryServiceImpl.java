package kz.narxoz.demo.service;


import kz.narxoz.demo.CategoryRepository;
import kz.narxoz.demo.dto.CategoryDto;
import kz.narxoz.demo.mapper.CategoryMapper;
import kz.narxoz.demo.model.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> getAll() {
        return categoryMapper.toDtoList(categoryRepository.findAll());
    }

    @Override
    public CategoryDto getById(Long id) {
        return categoryMapper.toDto(categoryRepository.findById(id).orElse(null));
    }

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        CategoryEntity cat = categoryRepository.save(categoryMapper.toEntity(categoryDto));
        return categoryMapper.toDto(cat);

    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
        CategoryEntity category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

        
        category.setName(categoryDto.getNameDto());

        return categoryMapper.toDto(categoryRepository.save(category));
    }


    @Override
    public Boolean deleteCategory(Long id) {
        categoryRepository.deleteById(id);
        CategoryEntity cat = categoryRepository.findById(id).orElse(null);
        if(Objects.isNull(cat)){
            return true;
        }
        return false;
    }
}