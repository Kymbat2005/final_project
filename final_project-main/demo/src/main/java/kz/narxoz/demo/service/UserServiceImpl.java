package kz.narxoz.demo.service;

import kz.narxoz.demo.UserRepository;
import kz.narxoz.demo.dto.UserDto;
import kz.narxoz.demo.mapper.UserMapper;
import kz.narxoz.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public List<UserDto> getAll() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    @Override
    public UserDto getById(Long id) {
        return userMapper.toDto(userRepository.findById(id).orElse(null));
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        User user= userRepository.save(userMapper.toEntity(userDto));
        return userMapper.toDto(user);
    }
    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id).orElse(null);
        User userEnt = userMapper.toEntity(userDto);

        user.setId(userEnt.getId());
        user.setName(userEnt.getName());
        user.setEmail(userEnt.getEmail());
        return userMapper.toDto(userRepository.save(user));

    }

    @Override
    public boolean deleteUser(Long id) {
        userRepository.deleteById(id);
        User gym = userRepository.findById(id).orElse(null);
        if(Objects.isNull(gym)){
            return true;
        }
        return false;
    }
}
