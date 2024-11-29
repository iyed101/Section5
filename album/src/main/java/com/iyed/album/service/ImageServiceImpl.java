package com.iyed.album.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iyed.album.entities.Album;
import com.iyed.album.entities.Image;
import com.iyed.album.repos.AlbumRepository;
import com.iyed.album.repos.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;
    @Autowired
    AlbumRepository albumRepository;

    @Override
    public Image uplaodImage(MultipartFile file) throws IOException {
        /*
         * Ce code commenté est équivalent au code utilisant le design pattern Builder
         * Image image = new Image(null, file.getOriginalFilename(),
         * file.getContentType(), file.getBytes(), null);
         * return imageRepository.save(image);
         */
        return imageRepository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(file.getBytes()).build());
    }

    @Override
    public Image getImageDetails(Long id) throws IOException {
        final Optional<Image> dbImage = imageRepository.findById(id);
        return Image.builder()
                .idImage(dbImage.get().getIdImage())
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .image(dbImage.get().getImage()).build();
    }

    @Override
    public ResponseEntity<byte[]> getImage(Long id) throws IOException {
        final Optional<Image> dbImage = imageRepository.findById(id);
        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(dbImage.get().getType()))
                .body(dbImage.get().getImage());
    }

    @Override
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }

    @Override
    public Image uplaodImageAlb(MultipartFile file, Long idAlb)
            throws IOException {
        Album a = new Album();
        a.setIdAlbum(idAlb);
        return imageRepository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(file.getBytes())
                .album(a).build());
    }

    @Override
    public List<Image> getImagesParAlb(Long idAlb) {
        Album a = albumRepository.findById(idAlb).get();
        return a.getImages();
    }

}
