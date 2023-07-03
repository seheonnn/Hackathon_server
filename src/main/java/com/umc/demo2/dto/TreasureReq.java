package com.umc.demo2.dto;


import lombok.Getter;

public class TreasureReq {
    @Getter
    public static class CreateUserTreasure{

        private Long userId;
        private Long treasureId;

        private String comment;



    }

    @Getter
    public static class UpdateUserTreasure{

        private Long userId;
        private Long treasureId;

        private String comment;


    }


}
