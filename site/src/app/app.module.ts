import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { ArticleSongComponent } from './article/article-song/article-song.component';
import { ArticleListComponent } from './article/article-list/article-list.component';
import { GenreListComponent } from './entities/genre/genre-list/genre-list.component';
import { GenreFormComponent } from './entities/genre/genre-form/genre-form.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    FooterComponent,
    ArticleSongComponent,
    ArticleListComponent,
    GenreListComponent,
    GenreFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
