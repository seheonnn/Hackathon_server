package com.umc.demo2.domain;


import lombok.*;

import javax.persistence.*;
import java.awt.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Treasure extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "treasure_id")
    private Long treasureId;

    private String title;

    private String content;

    private Double latitude;
    private Double longitude;

    @Column(name = "files")
    private String files;

    public void Location(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }



}
