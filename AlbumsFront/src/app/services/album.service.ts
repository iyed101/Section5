import { Injectable } from '@angular/core';
import { Album } from '../model/album.model';
import { Artist } from '../model/artist.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { apiURL } from '../config';

import { ArtistWrapped } from '../model/artistWrapped.model';
import { AuthService } from './auth.service';
import { Image } from '../model/image.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
};

@Injectable({
  providedIn: 'root',
})
export class AlbumService {
  albums: Album[] = [];
  album!: Album;
  artistURL: string = 'http://localhost:4010/albums/art ';
  //artist! : Artist[] ;
  constructor(private http: HttpClient, private authService: AuthService) {}

  listAlbums(): Observable<Album[]> {
    let jwt = this.authService.getToken();
    jwt = 'Bearer ' + jwt;
    let httpHeaders = new HttpHeaders({ Authorization: jwt });
    return this.http.get<Album[]>(apiURL + '/all', { headers: httpHeaders });
  }

  ajouterAlbum(album: Album): Observable<Album> {
    let jwt = this.authService.getToken();
    jwt = 'Bearer ' + jwt;
    let httpHeaders = new HttpHeaders({ Authorization: jwt });
    return this.http.post<Album>(apiURL + '/addalbum', album, {
      headers: httpHeaders,
    });
  }
  supprimerAlbum(id: number) {
    const url = `${apiURL}/delalbum/${id}`;
    let jwt = this.authService.getToken();
    jwt = 'Bearer ' + jwt;
    let httpHeaders = new HttpHeaders({ Authorization: jwt });

    return this.http.delete(url, { headers: httpHeaders });
  }

  consulterAlbum(id: number): Observable<Album> {
    const url = `${apiURL}/getbyid/${id}`;
    let jwt = this.authService.getToken();
    jwt = 'Bearer ' + jwt;
    let httpHeaders = new HttpHeaders({ Authorization: jwt });
    return this.http.get<Album>(url, { headers: httpHeaders });
  }
  updateAlbum(album: Album): Observable<Album> {
    let jwt = this.authService.getToken();
    jwt = 'Bearer ' + jwt;
    let httpHeaders = new HttpHeaders({ Authorization: jwt });
    return this.http.put<Album>(apiURL + '/updatealbum', album, {
      headers: httpHeaders,
    });
  }
  trierAlbums() {
    this.albums = this.albums.sort((n1, n2) => {
      if (n1.nb_tracks! > n2.nb_tracks!) {
        return 1;
      }
      if (n1.nb_tracks! < n2.nb_tracks!) {
        return -1;
      }
      return 0;
    });
  }
  listeArtist(): Observable<ArtistWrapped> {
    let jwt = this.authService.getToken();
    jwt = 'Bearer ' + jwt;
    let httpHeaders = new HttpHeaders({ Authorization: jwt });
    return this.http.get<ArtistWrapped>(this.artistURL, {
      headers: httpHeaders,
    });
  }

  rechercherParArtist(idArt: number): Observable<Album[]> {
    let jwt = this.authService.getToken();
    jwt = 'Bearer ' + jwt;
    let httpHeaders = new HttpHeaders({ Authorization: jwt });
    return this.http.get<Album[]>(apiURL + '/albumArtist/' + idArt, {
      headers: httpHeaders,
    });
  }

  rechercherParNom(nom: string): Observable<Album[]> {
    let jwt = this.authService.getToken();
    jwt = 'Bearer ' + jwt;
    let httpHeaders = new HttpHeaders({ Authorization: jwt });
    const url = `${apiURL}/albumByName/${nom}`;
    return this.http.get<Album[]>(url, { headers: httpHeaders });
  }
  ajouterArtist(artist: Artist): Observable<Artist> {
    let jwt = this.authService.getToken();
    jwt = 'Bearer ' + jwt;
    let httpHeaders = new HttpHeaders({ Authorization: jwt });
    return this.http.post<Artist>(this.artistURL, artist, {
      headers: httpHeaders,
    });
  }

  uploadImage(file: File, filename: string): Observable<Image> {
    const imageFormData = new FormData();
    imageFormData.append('image', file, filename);

    let jwt = this.authService.getToken();
    jwt = 'Bearer ' + jwt;

    const httpHeaders = new HttpHeaders({ Authorization: jwt });

    const url = `${apiURL + '/image/upload'}`;
    return this.http.post<Image>(url, imageFormData, { headers: httpHeaders });
  }

  loadImage(id: number): Observable<Image> {
    let jwt = this.authService.getToken();
    jwt = 'Bearer ' + jwt;
    const httpHeaders = new HttpHeaders({ Authorization: jwt });

    const url = `${apiURL + '/image/get/info'}/${id}`;
    return this.http.get<Image>(url, { headers: httpHeaders });
  }

  uploadImageAlbum(
    file: File,
    filename: string,
    idAlb: number
  ): Observable<any> {
    const imageFormData = new FormData();
    imageFormData.append('image', file, filename);

    let jwt = this.authService.getToken();
    jwt = 'Bearer ' + jwt;
    const httpHeaders = new HttpHeaders({ Authorization: jwt });

    const url = `${apiURL + '/image/uplaodImageAlb'}/${idAlb}`;
    return this.http.post(url, imageFormData, { headers: httpHeaders });
  }

  supprimerImage(id: number) {
    let jwt = this.authService.getToken();
    jwt = 'Bearer ' + jwt;
    const httpHeaders = new HttpHeaders({ Authorization: jwt });

    const url = `${apiURL}/image/delete/${id}`;
    return this.http.delete(url, { headers: httpHeaders });
  }

  getbyAlbum(id: number): Observable<Image[]> {
    let jwt = this.authService.getToken();
    jwt = 'Bearer ' + jwt;
    const httpHeaders = new HttpHeaders({ Authorization: jwt });

    const url = `${apiURL}/getbyalbum/${id}`;
    return this.http.get<Image[]>(url, { headers: httpHeaders });
  }
}
