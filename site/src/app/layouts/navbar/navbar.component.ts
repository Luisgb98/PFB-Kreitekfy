import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/entities/user/service/user.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  constructor(public nav: UserService) { }

  ngOnInit(): void {
  }

}
