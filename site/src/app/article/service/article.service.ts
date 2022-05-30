import { Injectable } from '@angular/core';
import { Article } from '../model/article.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  constructor(private http: HttpClient) { }

  public getAllArticles(): Observable<Article[]>{
    const urlEndpoint: string = "http://localhost:8080/kreitekfy/songs-old";
    return this.http.get<Article[]>(urlEndpoint);

  }
}
