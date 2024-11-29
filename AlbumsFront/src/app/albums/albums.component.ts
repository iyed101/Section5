import { AuthService } from './../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { Album } from '../model/album.model';
import { AlbumService } from '../services/album.service';
import { Router } from '@angular/router';
import { Image } from '../model/image.model';

@Component({
  selector: 'app-albums',
  templateUrl: './albums.component.html',
})
export class AlbumsComponent implements OnInit {
  albums?: Album[];

  constructor(
    private albumService: AlbumService,
    private router: Router,
    public authService: AuthService
  ) {}

  ngOnInit(): void {
    this.chargerAlbums();
  }
  /*chargerAlbums() {
    this.albumService.listAlbums().subscribe((albums) => {
      this.albums = albums;
      this.albums.forEach((alb) => {
        this.albumService
          .loadImage(alb.image.idImage)
          .subscribe((img: Image) => {
            alb.imageStr = 'data:' + img.type + ';base64,' + img.image;
          });
      });
    });
  }*/
  chargerAlbums() {
    this.albumService.listAlbums().subscribe({
      next: (albs) => {
        console.log(albs);
        this.albums = albs;

        this.albums.forEach((alb) => {
          if (alb.images && alb.images.length > 0) {
            // Use the first image as the display image
            alb.imageStr =
              'data:' + alb.images[0].type + ';base64,' + alb.images[0].image;
          }
        });
      },
      error: (error) => {
        console.error('Error loading eleves:', error);
        // You might want to show an error message to the user here
      },
    });
  }
  supprimerAlbum(album: Album) {
    let conf = confirm('Etes-vous sûr ?');
    if (conf) {
      this.albumService.supprimerAlbum(album.idAlbum).subscribe(() => {
        this.chargerAlbums();
      });
    }
  }
}
