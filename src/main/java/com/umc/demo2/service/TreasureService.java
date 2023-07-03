package com.umc.demo2.service;

import com.umc.demo2.domain.Treasure;
import com.umc.demo2.domain.UserTreasure;
import com.umc.demo2.dto.TreasureReq;
import com.umc.demo2.global.BaseException;
import com.umc.demo2.global.BaseResponseStatus;
import com.umc.demo2.repository.TreasureRepository;
import io.swagger.v3.oas.models.media.Content;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.management.Query;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TreasureService {
    @Autowired
    private TreasureRepository treasureRepository;
    public List<Treasure> getTreasure(Double latitude, Double longitude) {

        double radius = 0.007;
        double endX = latitude + (radius * Math.sin(90));   // 12시 좌표값
        double startX = latitude - (endX - latitude);           // 12시 좌표값으로 6시 좌표값 얻기
        double endY = longitude + (radius * Math.cos(0));    // 3시 좌표값
        double startY = longitude - (endY - longitude);           // 3시 좌표값으로 9시 좌표값 얻기

//        log.info(String.valueOf(startX));
//        log.info(String.valueOf(endX));
//        log.info(String.valueOf(startY));
//        log.info(String.valueOf(endY));

        return treasureRepository.findWithinMap(startX, endX, startY, endY);
    }


    public Treasure findByTreasureId(Long treasureId){ 
        return treasureRepository.findByTreasureId(treasureId);
    }

    public void postTreasure(List<MultipartFile> files, TreasureReq.PostTreasure postTreasure) throws IOException {
        Treasure newTreasure = Treasure.builder()
                .title(postTreasure.getTitle())
                .content(postTreasure.getContent())
                .latitude(postTreasure.getLatitude())
                .longitude(postTreasure.getLongitude())
                .files(FileService.fileUpload(files))
                .build();
        treasureRepository.save(newTreasure);
    }


}
