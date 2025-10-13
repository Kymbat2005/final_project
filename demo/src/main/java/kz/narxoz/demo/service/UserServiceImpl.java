package kz.narxoz.demo.service;

import kz.narxoz.demo.UserRepository;
import kz.narxoz.demo.dto.UserDto;
import kz.narxoz.demo.mapper.UserMapper;
import kz.narxoz.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService  {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDto> getAll(){
        return userMapper.toDtoList(userRepository.findAll());
    }
    @Override
    public UserDto getById(Long id){
        return userMapper.toDto(userRepository.findById(id).orElseThrow());
    }
    @Override
    public void addUser(UserDto userDto){
        userRepository.save(userMapper.toEntity(userDto));

    }
    @Override
    public void updateUser(Long id,UserDto userDto){
        User user=userRepository.findById(id).orElseThrow());
        User userEnt=userMapper.toEntity(userDto);
        userRepository.save(user);

    }
    @Override
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}

