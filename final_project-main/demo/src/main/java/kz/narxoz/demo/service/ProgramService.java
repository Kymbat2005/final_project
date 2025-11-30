package kz.narxoz.demo.service;


import kz.narxoz.demo.dto.ProgramDto;

import java.util.List;

public interface ProgramService {
    List<ProgramDto> getall();
    ProgramDto getById(Long id);
    ProgramDto addProgram(ProgramDto programDto);
    ProgramDto update(Long id, ProgramDto programDto);
    Boolean deleteProgram(Long id);
}