package com.iyed.album.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.iyed.album.entities.Artist;

@RepositoryRestResource(path = "art")
@CrossOrigin("*")
public interface ArtistRepository extends JpaRepository<Artist, Long> {

}
