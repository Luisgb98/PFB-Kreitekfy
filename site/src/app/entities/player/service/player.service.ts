import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Song } from '../../song/model/song.model';

@Injectable({
  providedIn: 'root',
})
export class PlayerService {
  constructor(private http: HttpClient) {}

  public getAllSongs(
    size: number,
    sort: string,
    filters?: string
  ): Observable<Song[]> {
    let urlEndpoint: string =
      'http://localhost:8080/kreitekfy/songs?page=' +
      '&size=' +
      size +
      '&sort=' +
      sort;
    if (filters) {
      urlEndpoint = urlEndpoint + '&filter=' + filters;
    }
    return this.http.get<Song[]>(urlEndpoint);
  }
}
