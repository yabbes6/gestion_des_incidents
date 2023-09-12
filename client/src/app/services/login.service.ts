import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  jwt: string;
  username: string;
  roles: Array<string>;

  host2: string = "http://localhost:8089"

  constructor(private http: HttpClient, private router: Router) { }

  login(data: any) {
    return this.http.post(this.host2 + "/login", data, { observe: 'response' });

  }

  saveToken(jwt: any) {
    localStorage.setItem('token', jwt);
    this.jwt = jwt;
    this.parseJWT();
  }


  parseJWT() {
    let jwtHelper = new JwtHelperService();
    let objJWT = jwtHelper.decodeToken(this.jwt);
    this.username = objJWT.sub;
    this.roles = objJWT.roles;
  }
  public logout() {

    localStorage.removeItem("token")
    this.initParams();

    this.router.navigateByUrl('/login')
    // Add any additional cleanup logic here
  }

  initParams() {
    this.jwt = ""
    this.username=""
    this.roles = []
  }

  loadJwtTokenFromLocalStorage() {
    let token = window.localStorage.getItem("jwt-token")

    if (token) {
      this.parseJWT();
      this.router.navigateByUrl("/");
    }
  }

  isAdmin() {
    return this.roles.indexOf('ADMIN') >= 0;
  }
  isUser() {
    return this.roles.indexOf('USER') >= 0;
  }

  isAuthenticated() {
    return this.roles && (this.isAdmin() || this.isUser());
  }
}


