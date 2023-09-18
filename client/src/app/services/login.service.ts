import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class LoginService {
  jwt: string ;
  username: string | null = null;
  roles: string[] = [];
  isAuthenticated: boolean = false;

  private readonly host2: string = "http://localhost:8089";

  constructor(private http: HttpClient, private router: Router) {
    this.loadJwtTokenFromLocalStorage();
  }

  login(data: any): Observable<any> {
    return this.http.post(`${this.host2}/login`, data, { observe: 'response' });
  }

  saveToken(jwt: string) {
    localStorage.setItem('jwt-token', jwt);
    this.jwt = jwt;
    this.parseJWT();
  }

  parseJWT() {
    let jwtHelper = new JwtHelperService();

    try {
      let objJWT = jwtHelper.decodeToken(this.jwt);
      console.log(objJWT);

      if (objJWT && objJWT.sub && objJWT.roles) {
        this.username = objJWT.sub;
        this.roles = objJWT.roles;
        this.isAuthenticated = true;
      } else {
        this.initParams();
        console.error('JWT payload does not contain expected properties.');
      }
    } catch (error) {
      this.initParams();
      console.error('Error decoding JWT:', error);
    }
  }

  logout() {
    this.isAuthenticated = false;
    localStorage.removeItem('jwt-token');
    this.initParams();
    this.router.navigateByUrl('/login');
  }

  private initParams() {
    this.jwt = "";
    this.username = null;
    this.roles = [];
  }

  loadJwtTokenFromLocalStorage() {
    const storedToken = window.localStorage.getItem('jwt-token');

    if (storedToken) {
      this.isAuthenticated = true;
      this.jwt = storedToken;
      this.parseJWT();
    }
  }

  isAdmin() {
    return this.roles.indexOf('ADMIN') >= 0;
  }
  isUser() {
    return this.roles.indexOf('USER') >= 0;
  }

  /*isAuthenticated() {
    return this.roles && (this.isAdmin() || this.isUser());
  }*/
}
/*export class LoginService {

  jwt: any;
  username: any;
  roles: Array<string>;
  isAuthenticate :boolean=false;

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

    try {
      let objJWT = jwtHelper.decodeToken(this.jwt);
  
      if (objJWT && objJWT.username && objJWT.roles) {
        this.username = objJWT.username;
        this.roles = objJWT.roles;
      } else {
        // Handle the case where the JWT doesn't have the expected properties
        console.error('JWT payload does not contain expected properties.');
      }
    } catch (error) {
      // Handle decoding errors
      console.error('Error decoding JWT:', error);
    }
  }
  public logout() {
    this.isAuthenticate = false;
    localStorage.removeItem("token")
    this.initParams();

    this.router.navigateByUrl('/login')
    // Add any additional cleanup logic here
  }

  private initParams() {
    this.jwt = undefined
    this.username=""
    this.roles = []
  }

  loadJwtTokenFromLocalStorage() {
    this.isAuthenticate = true;
    this.jwt = window.localStorage.getItem("jwt-token");
    this.parseJWT();
    
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
}*/


