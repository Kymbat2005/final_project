package kz.narxoz.demo.service;

import kz.narxoz.demo.dto.CategoryDto;
import kz.narxoz.demo.mapper.CategoryMapper;
import kz.narxoz.demo.model.Category;
import kz.narxoz.demo.CategoryRepository;
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
        Category cat = categoryRepository.save(categoryMapper.toEntity(categoryDto));
        return categoryMapper.toDto(cat);

    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
        Category category = categoryRepository.findById(id).orElseThrow();
        Category categoryEntity = categoryMapper.toEntity(categoryDto);
        category.setId(categoryEntity.getId());
        category.setName(categoryEntity.getName());
        return categoryMapper.toDto(categoryRepository.save(category));
    }

    @Override
    public Boolean deleteCategory(Long id) {
        categoryRepository.deleteById(id);
        Category cat = categoryRepository.findById(id).orElse(null);
        if(Objects.isNull(cat)){
            return true;
        }
        return false;
    }
}