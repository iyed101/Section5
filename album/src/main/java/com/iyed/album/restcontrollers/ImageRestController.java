package com.iyed.album.restcontrollers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.iyed.album.entities.Image;
import com.iyed.album.service.ImageService;

@RestController
@RequestMapping("/api/image")
@CrossOrigin("*")
public class ImageRestController {
    @Autowired
    ImageService imageService;


    

    @PostMapping(value = "/uplaodImageAlb/{idAlbum}")
    public Image uploadMultiImages(@RequestParam("image") MultipartFile file,
            @PathVariable("idAlbum") Long idAlb)
            throws IOException {
        return imageService.uplaodImageAlb(file, idAlb);
    }

    @RequestMapping(value = "/getImagesAlb/{idAlbum}", method = RequestMethod.GET)
    public List<Image> getImagesAlb(@PathVariable("idAlbum") Long idAlb)
            throws IOException {
        return imageService.getImagesParAlb(idAlb);
    }

    @PostMapping("/upload")
    public Image uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        return imageService.uplaodImage(file);
    }

    @GetMapping("/get/info/{id}")
    public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
        return imageService.getImageDetails(id);
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {
        return imageService.getImage(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteImage(@PathVariable("id") Long id) {
        imageService.deleteImage(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Image UpdateImage(@RequestParam("image") MultipartFile file) throws IOException {
        return imageService.uplaodImage(file);
    }
}
