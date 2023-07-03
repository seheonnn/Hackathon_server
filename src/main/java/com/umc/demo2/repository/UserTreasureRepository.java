package com.umc.demo2.repository;

import com.umc.demo2.domain.UserTreasure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTreasureRepository extends JpaRepository<UserTreasure, Long> {

    List<UserTreasure> findAllByUserId(Long userId);

    Long countAllByUserId(Long userId);
}
