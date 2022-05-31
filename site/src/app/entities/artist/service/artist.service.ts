import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Artist } from '../model/artist.model';

@Injectable({
  providedIn: 'root'
})
export class ArtistService {

  constructor(private http: HttpClient) { }

  public getAllArtists(partialName?: string): Observable<Artist[]> {
    let urlEndpoint: string = "http://localhost:8080/kreitekfy/artists";
    if (partialName) {
      urlEndpoint = urlEndpoint + "?partialName=" + partialName;

    }
    return this.http.get<Artist[]>(urlEndpoint);
  }

  public getArtistById(artistId: number): Observable<Artist> {
    let urlEndpoint: string = "http://localhost:8080/kreitekfy/artist/" + artistId;
    return this.http.get<Artist>(urlEndpoint);
  }

  public insert(artist: Artist): Observable<Artist> {
    let urlEndpoint: string = "http://localhost:8080/kreitekfy/artists/";
    return this.http.post<Artist>(urlEndpoint, artist);
  }

  public update(artist: Artist): Observable<Artist> {
    let urlEndpoint: string = "http://localhost:8080/kreitekfy/artists/";
    return this.http.patch<Artist>(urlEndpoint, artist);
  }

  public deleteArtist(artistIdToDelete: number): Observable<any> {
    let urlEndpoint: string = "http://localhost:8080/kreitekfy/artist/" + artistIdToDelete;
    return this.http.delete<any>(urlEndpoint);
  }
}
