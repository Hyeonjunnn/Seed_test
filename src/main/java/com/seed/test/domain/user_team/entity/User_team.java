package com.seed.test.domain.user_team.entity;

import com.seed.test.domain.cmms.entity.BaseEntity;
import com.seed.test.domain.team.entity.Team;
import com.seed.test.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User_team extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_team_no")
    private Long user_team_no;

    @ManyToOne
    @JoinColumn(name = "user_no")
    private User user;

    @ManyToOne
    @JoinColumn(name = "team_no")
    private Team team;
}
