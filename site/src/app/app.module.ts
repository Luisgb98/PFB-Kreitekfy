import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { GenreListComponent } from './entities/genre/genre-list/genre-list.component';
import { GenreFormComponent } from './entities/genre/genre-form/genre-form.component';
import { ArtistListComponent } from './entities/artist/artist-list/artist-list.component';
import { ArtistFormComponent } from './entities/artist/artist-form/artist-form.component';
import { SongListComponent } from './entities/song/song-list/song-list.component';
import { SongFormComponent } from './entities/song/song-form/song-form.component';
import { AlbumListComponent } from './entities/album/album-list/album-list.component';
import { AlbumFormComponent } from './entities/album/album-form/album-form.component';

import { AutoCompleteModule } from 'primeng/autocomplete';
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    FooterComponent,
    GenreListComponent,
    GenreFormComponent,
    ArtistListComponent,
    ArtistFormComponent,
    SongListComponent,
    SongFormComponent,
    AlbumListComponent,
    AlbumFormComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    AutoCompleteModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
