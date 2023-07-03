package com.umc.demo2.controller;

import com.umc.demo2.domain.Treasure;
import com.umc.demo2.dto.Location;
import com.umc.demo2.dto.TreasureReq;
import com.umc.demo2.global.BaseResponse;
import com.umc.demo2.service.TreasureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/treasure")
public class TreasureController {

    private final TreasureService treasureService;
    @GetMapping("")
    public BaseResponse<List<Treasure>> getTreasure(@RequestBody Location location) {
        return new BaseResponse<>(treasureService.getTreasure(location.getLatitude(), location.getLongitude()));
    }

    @PostMapping("")
    public BaseResponse<String> postTreasure(@RequestBody TreasureReq.PostTreasure postTreasure) {
        treasureService.postTreasure(postTreasure);
        return new BaseResponse<>("보물이 저장되었습니다");
    }
}
