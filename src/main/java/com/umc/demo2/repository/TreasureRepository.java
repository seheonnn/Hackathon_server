package com.umc.demo2.repository;

import com.umc.demo2.domain.Treasure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreasureRepository extends JpaRepository<Treasure, Long> {

    Treasure findByTreasureId(Long treasureId);
}
