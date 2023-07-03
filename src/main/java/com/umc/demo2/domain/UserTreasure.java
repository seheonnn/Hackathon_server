package com.umc.demo2.domain;


import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Entity(name = "user_treasure")
@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserTreasure extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "treasure_id")
    private Long treasureId;

    private String comment;

    @Column(name = "files")
    private String files;


    private int status;

    public UserTreasure update(String comment){
        this.comment=comment;
        return this;
    }


}
