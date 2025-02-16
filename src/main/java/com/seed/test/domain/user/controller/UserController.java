package com.seed.test.domain.user.controller;

import com.seed.test.domain.user.dto.UserRequestDto;
import com.seed.test.domain.user.dto.UserResponseDto;
import com.seed.test.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "유저 API", description = "유저 CRUD API")
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "유저 모두 조회", description = "유저를 모두 조회합니다.")
    @GetMapping("")
    public ResponseEntity<List<UserResponseDto>> getAllUser(){

        List<UserResponseDto> userResponseDtoList = userService.getAllUser();

        return ResponseEntity.status(HttpStatus.OK).body(userResponseDtoList);
    }

    @Operation(summary = "유저 한 건 조회", description = "유저 한 건을 조회합니다.")
    @GetMapping("/{user_no}")
    public ResponseEntity<UserResponseDto> getOneUserByNo(@PathVariable Long user_no){

        UserResponseDto userResponseDto = userService.getOneUserByNo(user_no);

        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    @Operation(summary = "유저 등록", description = "유저를 등록합니다.")
    @PostMapping()
    public ResponseEntity<UserResponseDto> createOneUser(@RequestBody UserRequestDto userRequestDto){

        UserResponseDto userResponseDto = userService.saveOneUser(userRequestDto);

        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    @Operation(summary = "유저 수정", description = "유저를 수정합니다.")
    @PutMapping("/{user_no}")
    public ResponseEntity<UserResponseDto> updateOneUser(@PathVariable Long user_no,
                                                      @RequestBody UserRequestDto userRequestDto){

        UserResponseDto userResponseDto = userService.updateOneUser(user_no, userRequestDto);

        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    @Operation(summary = "유저 삭제", description = "유저를 삭제합니다.")
    @DeleteMapping("/{user_no}")
    public ResponseEntity<String> deleteOneUser(@PathVariable Long user_no){

        userService.deleteOneUser(user_no);

        return ResponseEntity.status(HttpStatus.OK).body("유저가 삭제되었습니다.");
    }
}
