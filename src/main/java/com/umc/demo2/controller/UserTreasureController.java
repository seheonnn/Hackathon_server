package com.umc.demo2.controller;

import com.umc.demo2.domain.BaseEntity;
import com.umc.demo2.domain.UserTreasure;
import com.umc.demo2.dto.TreasureReq;
import com.umc.demo2.global.BaseResponse;
import com.umc.demo2.service.UserTreasureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
//@RequestMapping("/")
public class UserTreasureController {

    private final UserTreasureService userTreasureService;

    @PostMapping("/comment")
    public BaseResponse<String> createUserTreasure(@RequestBody TreasureReq.CreateUserTreasure request){
        UserTreasure userTreasure = userTreasureService.create(request);
        return new BaseResponse<>("새로운 방명록 등록 완료");


    }

    @PatchMapping("/comment/{userId}/{treasureId}")
    public BaseResponse<String> updateUserTreasure(@PathVariable(name = "userId")Long userId, @PathVariable(name ="treasureId")Long treasureId, @RequestBody TreasureReq.UpdateUserTreasure request){
        UserTreasure userTreasure = userTreasureService.update(userId, treasureId, request);
        return new BaseResponse<>("방명록 수정 완료");

    }
}
