import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AlbumsComponent } from './albums/albums.component';
import { AddAlbumComponent } from './add-album/add-album.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UpdateAlbumComponent } from './update-album/update-album.component';
import { provideHttpClient,HTTP_INTERCEPTORS } from '@angular/common/http';
import { RechercheParArtistComponent } from './recherche-par-artist/recherche-par-artist.component';
import { RechercheParNomComponent } from './recherche-par-nom/recherche-par-nom.component';
import { SearchFilterPipe } from './search-filter.pipe';
import { ListeArtistsComponent } from './liste-artists/liste-artists.component';
import { UpdateArtistComponent } from './update-artist/update-artist.component';
import { LoginComponent } from './login/login.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { TokenInterceptor } from './services/token.interceptor';
import { RegisterComponent } from './register/register.component';
import { VerifEmailComponent } from './verif-email/verif-email.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';



@NgModule({
  declarations: [
    AppComponent,
    AlbumsComponent,
    AddAlbumComponent,
    UpdateAlbumComponent,
    RechercheParArtistComponent,
    RechercheParNomComponent,
    SearchFilterPipe,
    ListeArtistsComponent,
    UpdateArtistComponent,
    LoginComponent,
    ForbiddenComponent,
    RegisterComponent,
    VerifEmailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot()
  ],
  providers: [
    provideClientHydration(),
    provideHttpClient(),
    { provide : HTTP_INTERCEPTORS,
      useClass : TokenInterceptor,
      multi : true},

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
