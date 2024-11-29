import { Component, OnInit } from '@angular/core';
import { AlbumService } from '../services/album.service';
import { Artist } from '../model/artist.model';

@Component({
  selector: 'app-liste-artists',
  templateUrl: './liste-artists.component.html',
  styles: ``
})
export class ListeArtistsComponent implements OnInit {


  artists!: Artist[];
  ajout:boolean=true;
  updatedArt: Artist = {idArtist : 0, name : '', age : 0, genre : '', country : ''};

  constructor(private albumService : AlbumService) { }
  ngOnInit(): void {
    this.chargerArtists();
  }
  chargerArtists() {
    this.albumService.listeArtist().subscribe( artists => {
      this.artists = artists._embedded!.artists;
    })
  }
  artistUpdated(art: Artist) {
    this.albumService.ajouterArtist(art).subscribe(() => {
      this.chargerArtists();
    })
  }
  updatedArtist(art: Artist) {
    this.updatedArt = art
    this.ajout = false;
  }
}
