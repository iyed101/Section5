package com.iyed.album.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iyed.album.entities.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
