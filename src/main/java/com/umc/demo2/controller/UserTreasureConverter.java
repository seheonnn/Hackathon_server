package com.umc.demo2.controller;

import com.umc.demo2.domain.Treasure;
import com.umc.demo2.domain.User;
import com.umc.demo2.domain.UserTreasure;
import com.umc.demo2.dto.TreasureRes;
import com.umc.demo2.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class UserTreasureConverter {

    private static UserRepository userRepository;

    public static TreasureRes.UserTreasure toUserTreasureDto(UserTreasure usertreasure){

        User user = userRepository.findUserByUserId(usertreasure.getUserId());

        return TreasureRes.UserTreasure.builder()
                .nickname(user.getNickname())
                .comment(usertreasure.getComment())
                .createdAt(usertreasure.getCreatedAt())
                .build();
    }

    public static List<TreasureRes.UserTreasure> toUserTreasureDtoList(List<UserTreasure> userTreasureList){

        return userTreasureList.stream()
                .map(userTreasure -> toUserTreasureDto(userTreasure))
                .collect(Collectors.toList());
    }

    public static TreasureRes.UserTreasureListDto toUserTreasureListDto(List<UserTreasure> userTreasureList){
        return TreasureRes.UserTreasureListDto.builder()
                .UserTreasureDtoList(toUserTreasureDtoList(userTreasureList))
                .build();
    }


}
