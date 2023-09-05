import { Component } from '@angular/core';
import { AuthService } from 'src/app/services/auth/auth.service';
import { MatDialog } from '@angular/material/dialog';
import { LoginComponent } from '../login/login.component';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {

  constructor(public dialog:MatDialog ,private authService:AuthService){}

  logout(){
    this.authService.logout();
  }

  openLoginForm(){
    this.dialog.open(LoginComponent,{width: '800px', height: '700px'});
  }
}
