package kz.narxoz.demo.Controller;


import kz.narxoz.demo.dto.UserDto;
import kz.narxoz.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserApi {
    private final UserService userService;
    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<?> add(@RequestBody UserDto userDto){
        userService.addUser(userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody UserDto userDto){
        userService.updateUser(id, userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}