package com.seed.test.domain.user.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private Long no;

    private String id;

    private String password;

    private String name;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;
}
