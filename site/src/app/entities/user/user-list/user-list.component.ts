import { Component, OnInit } from '@angular/core';
import { User } from '../model/user.model';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {
  users: User[] = [];
  userSelected?: string;

  constructor(
    private userService: UserService,
  ) { }

  ngOnInit(): void {
    this.getAllUsers();
  }

  public saveUser(userRol: string): void {
    this.userSelected = userRol;

    if (userRol === 'admin') {
      console.log("HOLA ADMIN")
      this.userService.show();
    }

    if (userRol === 'user') {
      console.log("HOLA USUARIO")
      this.userService.hide();
    }
  }

  private getAllUsers(): void {
    this.userService.getAllUsers().subscribe({
      next: (usersRequest) => {this.users = usersRequest; },
      error: (err) => {this.handleError(err);}
    })
  }

  private handleError(error: any): void {
    console.log(error);
  }

}
