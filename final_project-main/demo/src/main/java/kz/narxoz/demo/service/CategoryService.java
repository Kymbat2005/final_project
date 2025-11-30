package kz.narxoz.demo.service;


import kz.narxoz.demo.dto.CategoryDto;
import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAll();
    CategoryDto getById(Long id);
    CategoryDto addCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(Long id, CategoryDto categoryDto);
    Boolean deleteCategory(Long id);
}