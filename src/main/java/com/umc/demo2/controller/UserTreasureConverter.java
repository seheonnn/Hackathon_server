package com.umc.demo2.controller;

import com.umc.demo2.domain.UserTreasure;
import com.umc.demo2.dto.TreasureRes;

import java.util.List;
import java.util.stream.Collectors;

public class UserTreasureConverter {

    public static TreasureRes.UserTreasure toUserTreasureDto(UserTreasure usertreasure){
        return TreasureRes.UserTreasure.builder()
                .userId(usertreasure.getUserId())
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
