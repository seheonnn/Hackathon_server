package com.umc.demo2.repository;

import com.umc.demo2.domain.UserTreasure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTreasureRepository extends JpaRepository<UserTreasure, Long> {

    List<UserTreasure> findAllByUserId(Long userId);

    Long countAllByUserId(Long userId);


    @Query(value = "SELECT COUNT(UT.user_id) AS count, U.nickname AS nickname FROM user_treasure UT\n" +
            "                                  join user U on UT.user_id = U.user_id\n" +
            "                                  GROUP BY UT.user_id\n" +
            "                                    ORDER BY count DESC\n", nativeQuery = true)
    List<TheMostMissions> getTheMostMissionList();

    //select SC.title'category' from SubCategory SC join Category C on SC.category_id = C.id
    // where category_id=:categoryId order by SC.title asc",native
    //@Param("categoryId") Long categoryId
    interface TheMostMissions{
        String getNickname();
        Long getCount();
    }

}
