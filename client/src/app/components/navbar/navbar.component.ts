import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth/auth.service';
import { MatDialog } from '@angular/material/dialog';
import { LoginComponent } from '../login/login.component';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit{

  constructor(public dialog:MatDialog ,public loginService:LoginService,private router:Router){}
  ngOnInit(): void {
  }

  handleLogout(){
    this.loginService.logout();
    this.router.navigateByUrl("/");
  }


  // openLoginForm(){
  //   this.dialog.open(LoginComponent,{width: '800px', height: '700px'});
  // }
}
