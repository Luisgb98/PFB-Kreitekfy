import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ArtistFormComponent } from './entities/artist/artist-form/artist-form.component';
import { ArtistListComponent } from './entities/artist/artist-list/artist-list.component';
import { GenreFormComponent } from './entities/genre/genre-form/genre-form.component';
import { GenreListComponent } from './entities/genre/genre-list/genre-list.component';
import { SongFormComponent } from './entities/song/song-form/song-form.component';
import { SongListComponent } from './entities/song/song-list/song-list.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  { path: '', component: HomeComponent, pathMatch: 'full' },
  { path: 'genre', component: GenreListComponent },
  { path: 'genre/:genreId', component: GenreFormComponent },
  { path: 'artist', component: ArtistListComponent },
  { path: 'artist/:artistId', component: ArtistFormComponent },
  { path: 'song', component: SongListComponent },
  { path: 'song/:songId', component: SongFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
