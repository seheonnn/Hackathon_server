package com.umc.demo2.controller;

import com.umc.demo2.dto.UserTreasureRequestDto;
import com.umc.demo2.dto.UserTreasureResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class UserTreasureController {

    @PostMapping("/comment")
    public ResponseEntity<UserTreasureResponseDto.CreateUserTreasureDto> createuserTreasure(@RequestBody UserTreasureRequestDto.CreateUserTreasureDto request){

    }

    @PatchMapping("/comment/{userId}/{treasureId}")
    public ResponseEntity<UserTreasureResponseDto.UpdateUserTreasureDto> updateUserTreasure(@PathVariable(name = "userId")Long userId, @PathVariable(name ="treasureId")Long treasureId, @RequestBody UserTreasureRequestDto.UpdateUserTreasureDto request){



    }
}
