import { Component, OnInit } from '@angular/core';
import { Album } from '../model/album.model';
import { AlbumService } from '../services/album.service';
import { Artist } from '../model/artist.model';
import { Router } from '@angular/router';
import { Image } from '../model/image.model';

@Component({
  selector: 'app-add-album',
  templateUrl: './add-album.component.html',
})
export class AddAlbumComponent implements OnInit {
  newAlbum = new Album();
  artists!: Artist[];
  newIdArtist!: number;
  newArtist!: Artist;
  uploadedImage!: File;
  imagePath: any;

  constructor(private albumService: AlbumService, private router: Router) {}
  ngOnInit(): void {
    this.albumService.listeArtist().subscribe((artists) => {
      this.artists = artists._embedded!.artists;
    });
  }
  /*addAlbum(){
    this.newAlbum.artist = this.artists.find(a => a.idArtist == this.newIdArtist)!;
    this.albumService.ajouterAlbum(this.newAlbum).subscribe(album => {
      this.router.navigate(['albums']);
    })*/
  /*addAlbum() {
    this.albumService
      .uploadImage(this.uploadedImage, this.uploadedImage.name)
      .subscribe((img: Image) => {
        this.newAlbum.image = img;
        this.newAlbum.artist = this.artists.find(
          (a) => a.idArtist == this.newIdArtist
        )!;
        this.albumService.ajouterAlbum(this.newAlbum).subscribe(() => {
          this.router.navigate(['albums']);
        });
      });
  }*/
  addAlbum() {
    this.newAlbum.artist = this.artists.find(art => art.idArtist == this.newIdArtist)!;
    this.albumService
      .ajouterAlbum(this.newAlbum)
      .subscribe((alb) => {
        this.albumService
          .uploadImageAlbum(this.uploadedImage,
            this.uploadedImage.name, alb.idAlbum)
          .subscribe((response: any) => { }
          );
        this.router.navigate(['albums']);
      });
  }


  onImageUpload(event: any) {
    this.uploadedImage = event.target.files[0];
    var reader = new FileReader();
    reader.readAsDataURL(this.uploadedImage);
    reader.onload = (_event) => {
      this.imagePath = reader.result;
    };
  }
}
