package com.umc.demo2.controller;

import com.umc.demo2.domain.User;
import com.umc.demo2.dto.UserReq;
import com.umc.demo2.global.BaseResponse;
import com.umc.demo2.service.UserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PatchMapping("/{userId}/nickname")
    public BaseResponse<String> UpdateNickname(@PathVariable(name = "userId") Long userId, @RequestBody UserReq.UpdateNickname request){
        User user = userService.update(userId, request);
        return new BaseResponse<>("닉네임 수정 완료");
    }

}
