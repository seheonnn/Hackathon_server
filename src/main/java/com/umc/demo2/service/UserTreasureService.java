package com.umc.demo2.service;

import com.umc.demo2.domain.Treasure;
import com.umc.demo2.domain.User;
import com.umc.demo2.domain.UserTreasure;
import com.umc.demo2.dto.TreasureReq;
import com.umc.demo2.repository.TreasureRepository;
import com.umc.demo2.repository.UserRepository;
import com.umc.demo2.repository.UserTreasureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserTreasureService {

    private final UserRepository userRepository;
    private final TreasureRepository treasureRepository;

    private final UserTreasureRepository userTreasureRepository;

    @Transactional
    public UserTreasure create(TreasureReq.CreateUserTreasure request){

        UserTreasure userTreasure = UserTreasure.builder()
                .userId(request.getUserId())
                .treasureId(request.getTreasureId())
                .comment(request.getComment())
                .build();

        return userTreasureRepository.save(userTreasure);
    }

    @Transactional
    public UserTreasure update(Long userId, Long treasureId, TreasureReq.UpdateUserTreasure request){

        UserTreasure userTreasure = userTreasureRepository.findByUserIdAndTreasureId(userId, treasureId);
        userTreasure.update(request.getComment());
        return userTreasure;


    }
}
