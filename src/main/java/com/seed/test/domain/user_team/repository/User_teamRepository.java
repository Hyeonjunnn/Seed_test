package com.seed.test.domain.user_team.repository;

import com.seed.test.domain.user_team.entity.User_team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_teamRepository extends JpaRepository<User_team, Long> {
}
