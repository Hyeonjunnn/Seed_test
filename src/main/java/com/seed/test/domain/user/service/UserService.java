package com.seed.test.domain.user.service;

import com.seed.test.domain.user.dto.UserRequestDto;
import com.seed.test.domain.user.dto.UserResponseDto;

public interface UserService {

    public UserResponseDto getOneUserByNo(Long no);

    public UserResponseDto saveOneUser(UserRequestDto userRequestDto);

    public UserResponseDto updateOneUser(Long no, UserRequestDto userRequestDto);

    public void deleteOneUser(Long no);

}
