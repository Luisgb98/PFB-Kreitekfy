import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GenreFormComponent } from './entities/genre/genre-form/genre-form.component';
import { GenreListComponent } from './entities/genre/genre-list/genre-list.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  { path: '', component: HomeComponent, pathMatch: 'full' },
  { path: 'backoffice', loadChildren: () => import('./backoffice/backoffice.module').then(m => m.BackofficeModule) },
  { path: 'songsheet', loadChildren: () => import('./songsheet/songsheet.module').then(m => m.SongsheetModule) },
  { path: 'genre', component: GenreListComponent },
  { path: 'genre/:genreId', component: GenreFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
