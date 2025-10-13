package kz.narxoz.demo.Controller;

import kz.narxoz.demo.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class UserApi {
    private final UserServiceImpl userService;
    @GetMapping
    public ResponseEntity<?> List<UserDto> getAll(){
        return new ResponseEntity<>.toDtoList(userService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> UserDto getById(@PathVariable(name="id")Long id){
        return new ResponseEntity<>.toDto(userService.getById(id).orElseThrow());
    }
    @PostMapping
    public ResponseEntity<?>  add(@RequestBody UserDto userDto){
        userService.addUser(UserDto userDto);
        return new ResponseEntity<>(HttpStatus.OK);


    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody UserDto userDto,@PathVariable(name="id")Long id){
        userService.updateUser(Long id,UserDto userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable (name="id")){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
