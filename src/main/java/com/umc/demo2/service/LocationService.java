package com.umc.demo2.service;

import com.umc.demo2.dto.LocationDto;
import com.umc.demo2.handler.GeometryUtil;
import io.swagger.v3.oas.models.media.Content;
import org.springframework.transaction.annotation.Transactional;

import javax.management.Query;
import javax.swing.text.AbstractDocument;
import javax.xml.stream.Location;
import java.util.List;

public class LocationService {

//    @Transactional
//    public List<ContentDto.mapListContent> listMyMap(UserDetails userDetails, Double x, Double y) {
//        // Location 자료형으로 변수를 선언하여 해당 요청받은 x,y 값으로 북동쪽과 남서쪽의 위치를 계산
//        Location northEast = GeometryUtil.calculate(x, y, 2.0, Direction.NORTHEAST.getBearing());
//        Location southWest = GeometryUtil.calculate(x, y, 2.0, Direction.SOUTHWEST.getBearing());
//
//// 이를 바탕으로 NativeQuery로 북동쪽, 남서쪽 거리를 String으로 작성
//        String pointFormat = String.format(
//                "'LINESTRING(%f %f, %f %f)'",
//                northEast.getLatitude(), northEast.getLongitude(), southWest.getLatitude(), southWest.getLongitude()
//        );
//
//// NativeQuery로 작성한 pointFormat을 적용
//        Query query = em.createNativeQuery(
//                "" +
//                        "SELECT * \n" +
//                        "FROM content AS c \n" +
//                        "WHERE c.group_id IN (" + join + ") " +
//                        "AND " +
//                        "MBRContains(ST_LINESTRINGFROMTEXT(" + pointFormat + "), c.point)"
//                , Content.class
//        ).setMaxResults(10);
//
//        List<Content> contents = query.getResultList();
//
//        return contents.stream().map((Content content) ->
//                LocationDto.mapListContent.response(
//                        ...
//                )
//        ).toList();
//    }
}
