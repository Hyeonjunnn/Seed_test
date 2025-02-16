package com.seed.test.domain.user.service;

import com.seed.test.domain.user.dto.UserRequestDto;
import com.seed.test.domain.user.dto.UserResponseDto;

import java.util.List;

public interface UserService {

    public List<UserResponseDto> getAllUser();

    public UserResponseDto getOneUserByNo(Long user_no);

    public UserResponseDto saveOneUser(UserRequestDto userRequestDto);

    public UserResponseDto updateOneUser(Long user_no, UserRequestDto userRequestDto);

    public void deleteOneUser(Long user_no);

}
