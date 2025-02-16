package com.seed.test.domain.user_team.controller;

import com.seed.test.domain.user_team.dto.User_teamResponseDto;
import com.seed.test.domain.user_team.entity.User_team;
import com.seed.test.domain.user_team.service.User_teamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "유저_팀 API", description = "유저_팀 CRUD API")
@RestController
@RequestMapping("/user_team")
public class User_teamController {

    private final User_teamService user_teamService;

    @Autowired
    public User_teamController(User_teamService user_teamService) {
        this.user_teamService = user_teamService;
    }

    @Operation(summary = "유저_팀 모두 조회", description = "유저_팀을 모두 조회합니다.")
    @GetMapping("")
    public ResponseEntity<List<User_teamResponseDto>> getAllUser_team() {

        List<User_teamResponseDto> user_teamResponseDtoList = user_teamService.getAllUser_team();

        return ResponseEntity.status(HttpStatus.OK).body(user_teamResponseDtoList);
    }


}
