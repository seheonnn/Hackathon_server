package com.umc.demo2.repository;

import com.umc.demo2.domain.Treasure;
import com.umc.demo2.domain.User;
import com.umc.demo2.domain.UserTreasure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTreasureRepository extends JpaRepository<UserTreasure, Long> {

    UserTreasure findByUserIdAndTreasureId(Long userId, Long treasureId);
}
