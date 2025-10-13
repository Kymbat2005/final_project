package kz.narxoz.demo.service;

import kz.narxoz.demo.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

public interface UserService {
    List<UserDto> getAll();
    UserDto getById(Long id);
    void addUser(UserDto userDto);
    void updateUser(Long id,UserDto userDto);
    void deleteUser(Long id);

}
