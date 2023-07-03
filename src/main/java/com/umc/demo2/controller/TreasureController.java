package com.umc.demo2.controller;

import com.umc.demo2.domain.Treasure;
import com.umc.demo2.dto.Location;
import com.umc.demo2.global.BaseResponse;
import com.umc.demo2.service.TreasureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/treasures")
public class TreasureController {

    private final TreasureService treasureService;
    @GetMapping("")
    public BaseResponse<List<Treasure>> getTreasure(@RequestBody Location location) {
        return new BaseResponse<>(treasureService.getTreasure(location.getLatitude(), location.getLongitude()));
    }
}
