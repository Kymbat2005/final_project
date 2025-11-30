package kz.narxoz.demo.Controller;


import kz.narxoz.demo.dto.ProgramDto;
import kz.narxoz.demo.service.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/program")
public class ProgramApi {
    private final ProgramService programService;
    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(programService.getall(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(programService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addProgram(@RequestBody ProgramDto programDto){
        programService.addProgram(programDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProgram(@PathVariable(name = "id") Long id, @RequestBody ProgramDto programDto){
        programService.update(id, programDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProgram(@PathVariable(name = "id") Long id){
        programService.deleteProgram(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}