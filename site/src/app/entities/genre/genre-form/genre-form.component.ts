import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Genre } from '../model/genre.model';
import { GenreService } from '../service/genre.service';

@Component({
  selector: 'app-genre-form',
  templateUrl: './genre-form.component.html',
  styleUrls: ['./genre-form.component.scss']
})
export class GenreFormComponent implements OnInit {
  mode: 'NEW' | 'UPDATE' = 'NEW';
  genreId?: number;
  genre?: Genre;

  constructor(
    private route: ActivatedRoute,
    private genreService: GenreService
  ) { }

  ngOnInit(): void {
    const entryParam: string =
      this.route.snapshot.paramMap.get('genreId') ?? 'new';
    if (entryParam !== 'new') {
      this.genreId = +this.route.snapshot.paramMap.get('genreId')!;
      this.mode = 'UPDATE';
      this.getGenreById(this.genreId!);
    } else {
      this.mode = 'NEW';
      this.initializeGenre();
    }
  }

  public saveGenre(): void {
    if (this.mode === 'NEW') {
      this.insertGenre();
    }

    if (this.mode === 'UPDATE') {
      this.updateGenre();
    }
  }

  private insertGenre(): void {
    this.genreService.insert(this.genre!).subscribe({
      next: (genreInserted) => {
        console.log('Insertado correctamente');
        console.log(genreInserted);
      },
      error: (err) => {
        this.handleError(err);
      },
    });
  }

  private updateGenre(): void {
    this.genreService.update(this.genre!).subscribe({
      next: (genreUpdated) => {
        console.log('Modificado correctamente');
        console.log(genreUpdated);
      },
      error: (err) => {
        this.handleError(err);
      },
    });
  }

  private getGenreById(genreId: number) {
    this.genreService.getGenreById(genreId).subscribe({
      next: (genreRequest) => {
        this.genre = genreRequest;
      },
      error: (err) => {
        this.handleError(err);
      },
    });
  }

  private initializeGenre(): void {
    this.genre = new Genre(undefined, '');
  }

  private handleError(err: any): void {
    // ToDo
  }

}
