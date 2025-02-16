package com.seed.test.domain.user_team.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User_teamResponseDto {

    private Long user_team_no;

    private Long user_no;

    private Long team_no;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    private String user_name;

    private String team_name;
}
