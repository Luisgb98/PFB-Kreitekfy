import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Genre } from '../model/genre.model';
import { GenreService } from '../service/genre.service';

@Component({
  selector: 'app-genre-list',
  templateUrl: './genre-list.component.html',
  styleUrls: ['./genre-list.component.scss']
})
export class GenreListComponent implements OnInit {
  genres: Genre[] = [];

  genreIdToDelete?: number;

  constructor(
    private route: ActivatedRoute,
    private genreService: GenreService
    ) { }

  ngOnInit(): void {
    this.getAllGenres();
  }

  public prepareGenreToDelete(genreId: number): void {
    this.genreIdToDelete = genreId;
  }

  public deleteGenre(): void {
    if (this.genreIdToDelete) {
      this.genreService.deleteGenre(this.genreIdToDelete).subscribe({
        next: (data) => {
          this.getAllGenres();
        },
        error: (err) => {this.handleError(err)}
      })
    }
  }

  private getAllGenres(): void {
    this.genreService.getAllGenres().subscribe({
      next: (genresRequest) => { this.genres = genresRequest; },
      error: (err) => { this.handleError(err); }
    })
  }

  private handleError(error: any): void {
    console.log(error);
  }
}
