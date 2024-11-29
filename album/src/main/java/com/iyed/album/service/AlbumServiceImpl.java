package com.iyed.album.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.iyed.album.entities.Album;
import com.iyed.album.entities.Artist;
import com.iyed.album.repos.AlbumRepository;
import com.iyed.album.repos.ImageRepository;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    ImageRepository imageRepository;

    @PreAuthorize("hasAuthority('ADMIN')")
    @Override
    public Album saveAlbum(Album a) {
        return albumRepository.save(a);
    }

    /*@Override
    public Album updateAlbum(Album a) {
        return albumRepository.save(a);
    }*/

    @Override
    public Album updateAlbum(Album a) {
        //Long oldAlbImageId = this.getAlbum(a.getIdAlbum()).getImage().getIdImage();
        //Long newAlbImageId = a.getImage().getIdImage();
        Album albUpdated = albumRepository.save(a);
       // if (oldAlbImageId != newAlbImageId) // si l'image a été modifiée
         //   imageRepository.deleteById(oldAlbImageId);
        return albUpdated;
    }

    @Override
    public void deleteAlbum(Album a) {
        albumRepository.delete(a);
    }

    @Override
    public void deleteAlbumById(Long id) {
        albumRepository.deleteById(id);
    }

    @Override
    public Album getAlbum(Long id) {
        return albumRepository.findById(id).get();
    }

    @Override
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    @Override
    public List<Album> findByName(String nom) {
        return albumRepository.findByName(nom);
    }

    @Override
    public List<Album> findByNameContains(String nom) {
        return albumRepository.findByNameContains(nom);
    }

    @Override
    public List<Album> findByNameGenre(String nom, String genre) {
        return albumRepository.findByNameGenre(nom, genre);
    }

    @Override
    public List<Album> findByArtist(Artist artist) {
        return albumRepository.findByArtist(artist);
    }

    @Override
    public List<Album> findByArtistIdArtist(Long id) {
        return albumRepository.findByArtistIdArtist(id);
    }

    @Override
    public List<Album> findByOrderByNameAsc() {
        return albumRepository.findByOrderByNameAsc();
    }

    @Override
    public List<Album> trierAlbumNameGenre() {
        return albumRepository.trierAlbumNameGenre();
    }

}
