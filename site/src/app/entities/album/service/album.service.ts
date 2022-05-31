import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Album } from '../model/album.model';

@Injectable({
  providedIn: 'root'
})
export class AlbumService {

  constructor(private http: HttpClient) { }

  public getAllAlbums(partialName?: string): Observable<Album[]> {
    let urlEndpoint: string = "http://localhost:8080/kreitekfy/albums";
    if (partialName) {
      urlEndpoint = urlEndpoint + "?partialName=" + partialName;

    }
    return this.http.get<Album[]>(urlEndpoint);
  }

  public getAlbumById(albumId: number): Observable<Album> {
    let urlEndpoint: string = "http://localhost:8080/kreitekfy/album/" + albumId;
    return this.http.get<Album>(urlEndpoint);
  }

  public insert(album: Album): Observable<Album> {
    let urlEndpoint: string = "http://localhost:8080/kreitekfy/albums/";
    return this.http.post<Album>(urlEndpoint, album);
  }

  public update(album: Album): Observable<Album> {
    let urlEndpoint: string = "http://localhost:8080/kreitekfy/albums/";
    return this.http.patch<Album>(urlEndpoint, album);
  }

  public deleteAlbum(albumIdToDelete: number): Observable<any> {
    let urlEndpoint: string = "http://localhost:8080/kreitekfy/album/" + albumIdToDelete;
    return this.http.delete<any>(urlEndpoint);
  }
}
