package com.iyed.album.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArtist; 
    private String name;
    private int age;
    private String genre;
    private String country;

    @OneToMany(mappedBy = "artist")
    @JsonIgnore
    private List<Album> albums;
    public Artist(String name, int age, String genre, String country) {
        this.name = name;
        this.age = age;
        this.genre = genre;
        this.country = country;
    }
    public Long getIdArtist() {
        return idArtist;
    }
    public void setIdArtist(Long idArtist) {
        this.idArtist = idArtist;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    
    @Override
    public String toString() {
        return "Artist [idArtist=" + idArtist + ", name=" + name + ", age=" + age + ", genre=" + genre + ", country="
                + country + "]";
    }
    public List<Album> getAlbums() {
        return albums;
    }
    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
    
}
