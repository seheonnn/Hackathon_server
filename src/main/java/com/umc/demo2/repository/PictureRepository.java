package com.umc.demo2.repository;

import com.umc.demo2.domain.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {
}
