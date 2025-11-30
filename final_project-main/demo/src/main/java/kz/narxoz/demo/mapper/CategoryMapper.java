package kz.narxoz.demo.mapper;




import kz.narxoz.demo.dto.CategoryDto;
import kz.narxoz.demo.model.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target = "nameDto",source = "name")
    @Mapping(target = "id", source = "id")
    CategoryDto toDto(CategoryEntity category);


    @Mapping(target = "name",source = "nameDto")
    @Mapping(target = "id", source = "id")
    CategoryEntity toEntity(CategoryDto categoryDto);

    List<CategoryDto> toDtoList(List<CategoryEntity> categories);
}