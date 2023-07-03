package com.umc.demo2.repository;

import com.umc.demo2.domain.Treasure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Query;
import java.util.List;

@Repository
public interface TreasureRepository extends JpaRepository<Treasure, Long> {

    Treasure findByTreasureId(Long treasureId);

    @Query(value = "select * from treasure\n" +
            "where latitude between ?1 and ?2 and longitude between ?3 and ?4 ;",
            nativeQuery = true)
    List<Treasure> findWithinMap(Double startX, Double endX, Double startY, Double endY);
}
