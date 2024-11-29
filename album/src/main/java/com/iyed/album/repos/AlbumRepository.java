package com.iyed.album.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.iyed.album.entities.Album;
import com.iyed.album.entities.Artist;

@RepositoryRestResource(path = "rest")
@CrossOrigin("*")
public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findByName(String name);
    List<Album> findByNameContains(String name);
    // @Query("select a from Album a where a.name like %?1 and a.genre like ?2")
	// List<Album> findByNameGenre (String name, String genre);
	@Query("select a from Album a where a.name like %:name and a.genre like :genre")
	List<Album> findByNameGenre (@Param("name") String name, @Param("genre") String genre);
    
	@Query("select a from Album a where a.artist = ?1")
	List<Album> findByArtist (Artist artist);
	
	List<Album> findByArtistIdArtist(Long id);
	
	List<Album> findByOrderByNameAsc();
	
	@Query("select a from Album a order by a.name ASC, a.genre DESC")
	List<Album> trierAlbumNameGenre ();
}
