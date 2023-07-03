package com.umc.demo2.controller;

import com.umc.demo2.domain.UserTreasure;
import com.umc.demo2.dto.TreasureRes;
import com.umc.demo2.global.BaseResponse;
import com.umc.demo2.repository.UserTreasureRepository;
import com.umc.demo2.service.UserTreasureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class UserTreasureController {

    private final UserTreasureService userTreasureService;

//    @PostMapping("/comment")
//    public ResponseEntity<UserTreasureResponseDto.CreateUserTreasureDto> createuserTreasure(@RequestBody UserTreasureRequestDto.CreateUserTreasureDto request){
//
//    }
//
//    @PatchMapping("/comment/{userId}/{treasureId}")
//    public ResponseEntity<UserTreasureResponseDto.UpdateUserTreasureDto> updateUserTreasure(@PathVariable(name = "userId")Long userId, @PathVariable(name ="treasureId")Long treasureId, @RequestBody UserTreasureRequestDto.UpdateUserTreasureDto request){

    @GetMapping("/user/{userId}/treasures")
    public BaseResponse<List<TreasureRes.UserTreasureRes>> getUserTreasureList(@PathVariable Long userId){
        return new BaseResponse<>(userTreasureService.getUserTreasureList(userId));
    }

    @GetMapping("/user/{userId}/treasures/count")
    public BaseResponse<TreasureRes.UserSuccessTreasureCount> countUserTreasureList(@PathVariable Long userId){
        return new BaseResponse<>(userTreasureService.countUserTreasureList(userId));
    }

    @GetMapping("/rank")
    public BaseResponse<List<UserTreasureRepository.TheMostMissions>> getTheMostMissions(){
        return new BaseResponse<>(userTreasureService.getTheMostMissions());
    }

}
