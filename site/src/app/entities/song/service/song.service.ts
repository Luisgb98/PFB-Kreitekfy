import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Song } from '../model/song.model';

@Injectable({
  providedIn: 'root',
})
export class SongService {
  constructor(private http: HttpClient) {}

  public getAllSongs(
    page: number,
    size: number,
    sort: string,
    filters?: string
  ): Observable<Song[]> {
    let urlEndpoint: string =
      'http://localhost:8080/kreitekfy/songs?page=' +
      page +
      '&size=' +
      size +
      '&sort=' +
      sort;
    if (filters) {
      urlEndpoint = urlEndpoint + '&filter=' + filters;
    }
    return this.http.get<Song[]>(urlEndpoint);
  }

  public getSongById(songId: number): Observable<Song> {
    let urlEndpoint: string = 'http://localhost:8080/kreitekfy/song/' + songId;
    return this.http.get<Song>(urlEndpoint);
  }

  public insert(song: Song): Observable<Song> {
    let urlEndpoint: string = 'http://localhost:8080/kreitekfy/songs/';
    return this.http.post<Song>(urlEndpoint, song);
  }

  public update(song: Song): Observable<Song> {
    let urlEndpoint: string = 'http://localhost:8080/kreitekfy/songs/';
    return this.http.patch<Song>(urlEndpoint, song);
  }

  public deleteSong(songIdToDelete: number): Observable<any> {
    let urlEndpoint: string = 'http://localhost:8080/kreitekfy/song/' + songIdToDelete;
    return this.http.delete<any>(urlEndpoint);
  }
}
