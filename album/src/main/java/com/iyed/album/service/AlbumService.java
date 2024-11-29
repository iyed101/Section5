package com.iyed.album.service;

import java.util.List;

import com.iyed.album.entities.Album;
import com.iyed.album.entities.Artist;

public interface AlbumService {
    Album saveAlbum(Album a);
	Album updateAlbum(Album a);
	void deleteAlbum(Album a);
    void deleteAlbumById(Long id);
	Album getAlbum(Long id);
	List<Album> getAllAlbums();

	List<Album> findByName(String nom);
	List<Album> findByNameContains(String nom);
	List<Album> findByNameGenre (String nom, String genre);
	List<Album> findByArtist (Artist artist);
	List<Album> findByArtistIdArtist(Long id);
	List<Album> findByOrderByNameAsc();
	List<Album> trierAlbumNameGenre();

}
