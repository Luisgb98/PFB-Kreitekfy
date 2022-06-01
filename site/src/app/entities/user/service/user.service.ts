import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  visible: boolean;

  constructor(private http: HttpClient) { this.visible = false; }

  public getAllUsers(): Observable<User[]> {
    let urlEndpoint: string = "http://localhost:8080/kreitekfy/users";
    return this.http.get<User[]>(urlEndpoint);
  }

  hide() { this.visible = false; }

  show() { this.visible = true; }

  toggle() { this.visible = !this.visible; }
}
