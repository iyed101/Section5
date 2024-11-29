import { Artist } from './artist.model';
import { Image } from './image.model';

export class Album {
  idAlbum!: number;
  name!: string;
  date_sortie!: Date;
  genre!: string;
  nb_tracks!: number;
  artist!: Artist;
  image!: Image;
  imageStr!: string;

  images!: Image[];
}
