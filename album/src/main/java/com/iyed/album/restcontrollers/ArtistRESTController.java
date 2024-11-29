package com.iyed.album.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iyed.album.entities.Artist;
import com.iyed.album.repos.ArtistRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ArtistRESTController {
    @Autowired
    ArtistRepository artistRepository;

    @RequestMapping(path = "/art", method = RequestMethod.GET)
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    @RequestMapping(value = "/art/{id}", method = RequestMethod.GET)
    public Artist getArtistById(@PathVariable("id") Long id) {
        return artistRepository.findById(id).get();
    }

}
