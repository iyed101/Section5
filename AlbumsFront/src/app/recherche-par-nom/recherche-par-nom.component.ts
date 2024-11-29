import { Component, OnInit } from '@angular/core';
import { Album } from '../model/album.model';
import { AlbumService } from '../services/album.service';

@Component({
  selector: 'app-recherche-par-nom',
  templateUrl: './recherche-par-nom.component.html',
  styles: ``
})
export class RechercheParNomComponent implements OnInit {

  name!: string;
  albums!: Album[];
  allAlbums!: Album[];
  searchTerm!: string;
  constructor(private albumService : AlbumService) { }
  ngOnInit(): void {
    this.albumService.listAlbums().subscribe( albums => {
      this.albums = albums;
    })
  }

  rechercheParNom() {
    this.albumService.rechercherParNom(this.name).subscribe( albums => {
      this.albums = albums;
    })
  }
  onkeyUp(filterText: string) {
    this.albums = this.allAlbums.filter(item =>
      item.name.toLowerCase().includes(filterText.toLowerCase())
    );
  }


}
