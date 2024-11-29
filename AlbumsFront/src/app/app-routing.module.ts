import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlbumsComponent } from './albums/albums.component';
import { AddAlbumComponent } from './add-album/add-album.component';
import { UpdateAlbumComponent } from './update-album/update-album.component';
import { RechercheParArtistComponent } from './recherche-par-artist/recherche-par-artist.component';
import { RechercheParNomComponent } from './recherche-par-nom/recherche-par-nom.component';
import { ListeArtistsComponent } from './liste-artists/liste-artists.component';
import { LoginComponent } from './login/login.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { AlbumGuard } from './album.guard';
import { RegisterComponent } from './register/register.component';
import { VerifEmailComponent } from './verif-email/verif-email.component';
const routes: Routes = [
  {path : "albums", component : AlbumsComponent},
  {path : "add-album", component : AddAlbumComponent, canActivate : [AlbumGuard]},
  {path : "update-album/:id", component : UpdateAlbumComponent, canActivate : [AlbumGuard]},
  {path : "recherche-par-artist", component : RechercheParArtistComponent, canActivate : [AlbumGuard]},
  {path : "recherche-par-nom", component : RechercheParNomComponent, canActivate : [AlbumGuard]},
  {path : "liste-artists", component : ListeArtistsComponent, canActivate : [AlbumGuard]},
  {path : "login", component : LoginComponent},
  {path : 'forbidden', component: ForbiddenComponent},
  {path : 'register', component : RegisterComponent},
  {path : 'verifEmail', component: VerifEmailComponent},
  {path : "", redirectTo : "albums", pathMatch : "full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
