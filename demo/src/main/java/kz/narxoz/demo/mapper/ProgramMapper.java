package kz.narxoz.demo.mapper;

import kz.narxoz.demo.dto.ProgramDto;
import kz.narxoz.demo.model.Program;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProgramMapper {
    @Mapping(target = "nameDto",source = "name")
    @Mapping(target = "descriptionDto", source = "description")
    ProgramDto toDto(Program program);

    @Mapping(target = "name",source = "nameDto")
    @Mapping(target = "description", source = "descriptionDto")
    Program toEntity(ProgramDto programDto);

    List<ProgramDto> toDtoList(List<Program> programs);
}
