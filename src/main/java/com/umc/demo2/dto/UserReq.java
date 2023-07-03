package com.umc.demo2.dto;

import lombok.*;

public class UserReq {
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static class UpdateNickname{
        private String nickname;
    }

}
