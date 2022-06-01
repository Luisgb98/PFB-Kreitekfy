import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Genre } from '../model/genre.model';

@Injectable({
  providedIn: 'root',
})
export class GenreService {
  constructor(private http: HttpClient) {}

  public getAllGenres(partialName?: string): Observable<Genre[]> {
    let urlEndpoint: string = 'http://localhost:8080/kreitekfy/genres';
    if (partialName) {
      urlEndpoint = urlEndpoint + '?partialName=' + partialName;
    }
    return this.http.get<Genre[]>(urlEndpoint);
  }

  public getGenreById(genreId: number): Observable<Genre> {
    let urlEndpoint: string = 'http://localhost:8080/kreitekfy/genre/' + genreId;
    return this.http.get<Genre>(urlEndpoint);
  }

  public insert(genre: Genre): Observable<Genre> {
    let urlEndpoint: string = 'http://localhost:8080/kreitekfy/genres/';
    return this.http.post<Genre>(urlEndpoint, genre);
  }

  public update(genre: Genre): Observable<Genre> {
    let urlEndpoint: string = 'http://localhost:8080/kreitekfy/genres/';
    return this.http.patch<Genre>(urlEndpoint, genre);
  }

  public deleteGenre(genreIdToDelete: number): Observable<any> {
    let urlEndpoint: string = 'http://localhost:8080/kreitekfy/genre/' + genreIdToDelete;
    return this.http.delete<any>(urlEndpoint);
  }
}
