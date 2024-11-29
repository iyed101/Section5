import { Component, OnInit } from '@angular/core';
import { Artist } from '../model/artist.model';
import { Album } from '../model/album.model';
import { AlbumService } from '../services/album.service';

@Component({
  selector: 'app-recherche-par-artist',
  templateUrl: './recherche-par-artist.component.html',
  styles: ``
})
export class RechercheParArtistComponent implements OnInit {
  idArtist!: number ;
  artists!: Artist[];
  albums!: Album[];

  constructor(private albumService : AlbumService) { }
  ngOnInit(): void {
    this.albumService.listeArtist().subscribe( arts => {
      this.artists = arts._embedded!.artists;
    })
  }
  onChange() {
    this.albumService.rechercherParArtist(this.idArtist).subscribe( albums => {
      this.albums = albums;
    })
  }
}
