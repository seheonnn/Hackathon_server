package com.umc.demo2.dto;

import lombok.*;

public class TreasureRes {
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static class UserTreasureRes{
        //private String nickname;
        private String treasureTitle;
        private String comment;
    }
}
