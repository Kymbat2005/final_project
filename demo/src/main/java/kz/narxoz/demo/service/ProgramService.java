package kz.narxoz.demo.service;


import kz.narxoz.demo.dto.ProgramDto;

import java.util.List;

public interface ProgramService {
    List<ProgramDto> getAll();
    ProgramDto getById(Long id);
    ProgramDto addProgram(ProgramDto programDto);
    ProgramDto updateProgram(Long id, ProgramDto programDto);
    Boolean deleteProgram(Long id);
}