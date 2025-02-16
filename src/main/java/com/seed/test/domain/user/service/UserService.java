package com.seed.test.domain.user.service;

import com.seed.test.domain.user.dto.UserRequestDto;
import com.seed.test.domain.user.dto.UserResponseDto;

public interface UserService {

    public UserResponseDto getOneUserByNo(Long no);

    public UserResponseDto saveUser(UserRequestDto userRequestDto);

    public UserResponseDto updateUser(Long no, UserRequestDto userRequestDto);

    public void deleteUser(Long no);

}
