package com.iyed.album.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "name", types = {Album.class})
public interface AlbumProjection {
    public String getName();
    public String getGenre();
}

