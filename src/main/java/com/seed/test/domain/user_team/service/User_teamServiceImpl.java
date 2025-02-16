package com.seed.test.domain.user_team.service;

import com.seed.test.domain.user_team.dto.User_teamResponseDto;
import com.seed.test.domain.user_team.entity.User_team;
import com.seed.test.domain.user_team.repository.User_teamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class User_teamServiceImpl implements User_teamService{

    private final User_teamRepository user_teamRepository;

    @Autowired
    public User_teamServiceImpl(User_teamRepository user_teamRepository) {
        this.user_teamRepository = user_teamRepository;
    }

    public List<User_teamResponseDto> getAllUser_team(){

        List<User_teamResponseDto> user_teamResponseDtoList = new ArrayList<>();

        user_teamRepository.findAll().forEach(user_team -> {
            User_teamResponseDto user_teamResponseDto = new User_teamResponseDto();

            user_teamResponseDto.setUser_team_no(user_team.getUser_team_no());
            user_teamResponseDto.setUser_no(user_team.getUser().getUser_no());
            user_teamResponseDto.setTeam_no(user_team.getTeam().getTeam_no());
            user_teamResponseDto.setCreated_at(user_team.getCreated_at());
            user_teamResponseDto.setUpdated_at(user_team.getUpdated_at());
            user_teamResponseDto.setUser_name(user_team.getUser().getName());
            user_teamResponseDto.setTeam_name(user_team.getTeam().getName());

            user_teamResponseDtoList.add(user_teamResponseDto);
        });


        return user_teamResponseDtoList;
    }
}
