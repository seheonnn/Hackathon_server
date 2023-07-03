package com.umc.demo2.service;

import com.umc.demo2.domain.Treasure;
import com.umc.demo2.domain.User;
import com.umc.demo2.domain.UserTreasure;
import com.umc.demo2.dto.TreasureRes;
import com.umc.demo2.repository.TreasureRepository;
import com.umc.demo2.repository.UserRepository;
import com.umc.demo2.repository.UserTreasureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserTreasureService {

    private final UserTreasureRepository userTreasureRepository;

    private final UserRepository userRepository;

    private final TreasureRepository treasureRepository;


    public List<TreasureRes.UserTreasureRes> getUserTreasureList(Long userId){
        List<TreasureRes.UserTreasureRes> result = new ArrayList<>();
        List<UserTreasure> userTreasures = userTreasureRepository.findAllByUserId(userId);

        User user = userRepository.findUserByUserId(userId);

        for(UserTreasure u : userTreasures){
            Treasure treasure = treasureRepository.findByTreasureId(u.getTreasureId());

            TreasureRes.UserTreasureRes element =
                    new TreasureRes.UserTreasureRes( treasure.getTitle(), treasure.getContent());

            result.add(element);
        }

        return result;
    }

    public TreasureRes.UserSuccessTreasureCount countUserTreasureList(Long userId){
        //List<UserTreasure> userTreasures = userTreasureRepository.findAllByUserId(userId);

        Long all = userTreasureRepository.countAllByUserId(userId);
        User user = userRepository.findUserByUserId(userId);

        TreasureRes.UserSuccessTreasureCount result = new TreasureRes.UserSuccessTreasureCount(
                user.getNickname(),
                all,
                all/4,
                all%4
        );


        return result;
    }
}
