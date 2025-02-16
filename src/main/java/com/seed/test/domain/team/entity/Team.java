package com.seed.test.domain.team.entity;

import com.seed.test.domain.cmms.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Team extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_no")
    private Long team_no;

    private String name;
}
