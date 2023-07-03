package com.umc.demo2.dto;


import lombok.*;

public class TreasureReq {
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static class CreateUserTreasure{
        private Long userId;
        private Long treasureId;
        private String comment;
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static class UpdateUserTreasure{
        private Long userId;
        private Long treasureId;
        private String comment;
    }


}
