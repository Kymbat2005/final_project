package kz.narxoz.demo.service;


import kz.narxoz.demo.ProgramRepository;
import kz.narxoz.demo.dto.ProgramDto;
import kz.narxoz.demo.mapper.ProgramMapper;
import kz.narxoz.demo.model.ProgramEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProgramServiceImpl implements ProgramService {
    private final ProgramRepository programRepository;
    private final ProgramMapper programMapper;
    @Override
    public List<ProgramDto> getall() {
        return programMapper.toDtoList(programRepository.findAll());
    }

    @Override
    public ProgramDto getById(Long id) {
        return programMapper.toDto(programRepository.findById(id).orElse(null));
    }

    @Override
    public ProgramDto addProgram(ProgramDto programDto) {
        ProgramEntity program = programMapper.toEntity(programDto);
        ProgramEntity saved = programRepository.save(program);

        return programMapper.toDto(saved);
    }

    @Override
    public ProgramDto update(Long id, ProgramDto programDto) {
        ProgramEntity program = programRepository.findById(id).orElse(null);
        ProgramEntity update = programMapper.toEntity(programDto);

        program.setName(update.getName());
        program.setDescription(update.getDescription());

        return programMapper.toDto(programRepository.save(program));
    }

    @Override
    public Boolean deleteProgram(Long id) {
        programRepository.deleteById(id);
        ProgramEntity program = programRepository.findById(id).orElse(null);
        if(Objects.isNull(program)){
            return true;
        }
        return false;
    }
}