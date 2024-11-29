import { Artist } from './artist.model';
export class ArtistWrapped{
  _embedded!: { artists: Artist[] };
}
