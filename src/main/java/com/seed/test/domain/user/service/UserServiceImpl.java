package com.seed.test.domain.user.service;

import com.seed.test.domain.user.dto.UserRequestDto;
import com.seed.test.domain.user.dto.UserResponseDto;
import com.seed.test.domain.user.entity.User;
import com.seed.test.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto getOneUserByNo(@PathVariable Long no){
        User user = userRepository.findById(no).get();

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setNo(user.getNo());
        userResponseDto.setId(user.getId());
        userResponseDto.setPassword(user.getPassword());
        userResponseDto.setName(user.getName());
        userResponseDto.setCreated_at(user.getCreated_at());
        userResponseDto.setUpdated_at(user.getUpdated_at());

        return userResponseDto;
    }

    public UserResponseDto saveUser(UserRequestDto userRequestDto){
        User user = new User();

        user.setId(userRequestDto.getId());
        user.setPassword(userRequestDto.getPassword());
        user.setName(userRequestDto.getName());

        User savedUser = userRepository.save(user);

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(savedUser.getId());
        userResponseDto.setPassword(savedUser.getPassword());
        userResponseDto.setName(savedUser.getName());
        userResponseDto.setCreated_at(savedUser.getCreated_at());
        userResponseDto.setUpdated_at(savedUser.getUpdated_at());

        return userResponseDto;
    }

    public UserResponseDto updateUser(Long no, UserRequestDto userRequestDto){
        User user = new User();

        user.setNo(no);
        user.setId(userRequestDto.getId());
        user.setPassword(userRequestDto.getPassword());
        user.setName(userRequestDto.getName());

        User updatedUser = userRepository.save(user);

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setNo(updatedUser.getNo());
        userResponseDto.setId(updatedUser.getId());
        userResponseDto.setPassword(updatedUser.getPassword());
        userResponseDto.setName(updatedUser.getName());
        userResponseDto.setCreated_at(updatedUser.getCreated_at());
        userResponseDto.setUpdated_at(updatedUser.getUpdated_at());

        return userResponseDto;
    }

    public void deleteUser(Long no){
        userRepository.deleteById(no);
    }
}
