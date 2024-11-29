package com.iyed.album.restcontrollers;

import java.util.List;
import com.iyed.album.entities.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iyed.album.service.AlbumService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class AlbumRESTController {
    @Autowired
    AlbumService albumService;
    @RequestMapping(path="/all",method = RequestMethod.GET)
    public List<Album> getAllAlbums() {
        return albumService.getAllAlbums();
    }
    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    // @GetMapping("/getbyid/{id}")
    public Album getAlbumById(@PathVariable("id") Long id) {
        return albumService.getAlbum(id);
    }

    @RequestMapping(value = "/addalbum", method = RequestMethod.POST)
    public Album creatAlbum(@RequestBody Album a) {
        return albumService.saveAlbum(a);
    }
    @RequestMapping(value = "/updatealbum", method = RequestMethod.PUT)
    public Album updateAlbum(@RequestBody Album a) {
        return albumService.updateAlbum(a);
    }
    @RequestMapping(value = "/delalbum/{id}", method = RequestMethod.DELETE)
    public void deleteAlbum(@PathVariable("id") Long id) {
        albumService.deleteAlbumById(id);
    }
    @RequestMapping(value = "/albumArtist/{idArtist}", method = RequestMethod.GET)
    public List<Album> findByArtistIdArtist(@PathVariable("idArtist") Long id) {
        return albumService.findByArtistIdArtist(id);
    }
    @RequestMapping(value = "/albumByName/{nom}", method = RequestMethod.GET)
    public List<Album> findByNameContains(@PathVariable("nom") String nom) {
        return albumService.findByNameContains(nom);
    }
}
