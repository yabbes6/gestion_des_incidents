import { Component, OnInit } from '@angular/core';
import { AuthService } from './services/auth/auth.service';
import { LoginComponent } from './components/login/login.component';
import { LoginService } from './services/login.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
 
  title = 'client';

constructor(private authService:AuthService,private loginService:LoginService){

  }
  ngOnInit(): void {
    //this.loginService.loadJwtTokenFromLocalStorage();
  }


  isAdmin(){
    return this.loginService.isAdmin();
  }
  isUser(){
    return this.loginService.isUser();
  }

  iksAuthenticated(){
    return this.loginService.isAuthenticated();
  }
}
