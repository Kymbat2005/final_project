package kz.narxoz.demo.mapper;


import kz.narxoz.demo.dto.ProgramDto;
import kz.narxoz.demo.model.ProgramEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProgramMapper {
    @Mapping(target = "nameDto",source = "name")
    @Mapping(target = "descriptionDto", source = "description")
    ProgramDto toDto(ProgramEntity program);

    @Mapping(target = "name",source = "nameDto")
    @Mapping(target = "description", source = "descriptionDto")
    ProgramEntity toEntity(ProgramDto programDto);

    List<ProgramDto> toDtoList(List<ProgramEntity> programs);
}