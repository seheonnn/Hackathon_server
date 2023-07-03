package com.umc.demo2.controller;

import com.umc.demo2.domain.User;
import com.umc.demo2.dto.LocationDto;
import com.umc.demo2.service.LocationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class LocaitonController {

    @GetMapping("...")
    public CustomResponseEntity<List<LocationDto.mapListContent>> myMapList(
            @RequestParam final Double x,
            @RequestParam final Double y,
			...
    ) {
        return CustomResponseEntity.success(LocationService.listMyMap(x, y));
    }

}
