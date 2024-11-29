import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AlbumService } from '../services/album.service';
import { Album } from '../model/album.model';
import { Artist } from '../model/artist.model';
import { Image } from '../model/image.model';

@Component({
  selector: 'app-update-album',
  templateUrl: './update-album.component.html',
  styles: ``,
})
export class UpdateAlbumComponent implements OnInit {
  currentAlbum = new Album();
  artists!: Artist[];
  updateIdArtist!: number;
  myImage!: string;
  uploadedImage!: File;
  isImageUpdated: Boolean = false;
  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private albumService: AlbumService
  ) {}

  /*ngOnInit(): void {
    this.albumService.listeArtist().subscribe((artists) => {
      this.artists = artists._embedded.artists;
    });
    this.albumService
      .consulterAlbum(this.activatedRoute.snapshot.params['id'])
      .subscribe((album) => {
        this.currentAlbum = album;
        this.updateIdArtist = this.currentAlbum.artist.idArtist;
        this.albumService
          .loadImage(this.currentAlbum.image.idImage)
          .subscribe((img: Image) => {
            this.myImage = 'data:' + img.type + ';base64,' + img.image;
          });
      });
  }*/
  ngOnInit(): void {
    this.albumService.listeArtist().subscribe((artists) => {
      this.artists = artists._embedded.artists;
    });
    this.albumService
      .consulterAlbum(this.activatedRoute.snapshot.params['id'])
      .subscribe((album) => {
        this.currentAlbum = album;
        this.updateIdArtist = album.artist.idArtist;
      });
  }
  /*updateProduit() {
    this.currentAlbum.artist = this.artists.find(
      (a) => a.idArtist == this.updateIdArtist
    )!;
    this.albumService.updateAlbum(this.currentAlbum).subscribe((album) => {
      this.router.navigate(['albums']);
    });
  }*/
  /*updateAlbum() {
    this.currentAlbum.artist = this.artists.find(
      (a) => a.idArtist == this.updateIdArtist
    )!;
    //tester si l'image du produit a été modifiée
    if (this.isImageUpdated) {
      this.albumService
        .uploadImage(this.uploadedImage, this.uploadedImage.name)
        .subscribe((img: Image) => {
          this.currentAlbum.image = img;
          this.albumService.updateAlbum(this.currentAlbum).subscribe((alb) => {
            this.router.navigate(['albums']);
          });
        });
    } else {
      this.albumService.updateAlbum(this.currentAlbum).subscribe((alb) => {
        this.router.navigate(['albums']);
      });
    }
  }*/
  updateAlbum() {
    this.currentAlbum.artist = this.artists.find(
      (art) => art.idArtist == this.updateIdArtist
    )!;
    this.albumService.updateAlbum(this.currentAlbum).subscribe((alb) => {
      this.router.navigate(['albums']);
    });
  }

  onImageUpload(event: any) {
    if (event.target.files && event.target.files.length) {
      this.uploadedImage = event.target.files[0];
      this.isImageUpdated = true;
      const reader = new FileReader();
      reader.readAsDataURL(this.uploadedImage);
      reader.onload = () => {
        this.myImage = reader.result as string;
      };
    }
  }
  onAddImageAlbum() {
    this.albumService
      .uploadImageAlbum(
        this.uploadedImage,
        this.uploadedImage.name,
        this.currentAlbum.idAlbum
      )
      .subscribe((img: Image) => {
        this.currentAlbum.images.push(img);
      });
  }
  supprimerImage(img: Image) {
    let conf = confirm('Etes-vous sûr ?');
    if (conf)
      this.albumService.supprimerImage(img.idImage).subscribe(() => {
        //supprimer image du tableau currentProduit.images
        const index = this.currentAlbum.images.indexOf(img, 0);
        if (index > -1) {
          this.currentAlbum.images.splice(index, 1);
        }
      });
  }
}
