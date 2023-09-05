import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Route } from '@angular/router';
import jwtDecode from 'jwt-decode';
import { firstValueFrom } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  
  isAuthenticated :boolean=false;
  roles:any;
  username:any;
  accessToken: any ;

  private apiUrl = 'http://localhost:8089';

  constructor(private http: HttpClient ) { }


  public login(username: string, password: string) {
    let options = {
      headers: new HttpHeaders().set("Content-Type","application/x-www-form-urlencoded")
    }
    let params = new HttpParams()
      .set("username", username)
      .set("password", password);
    return this.http.post(this.apiUrl+"/auth/login",params,options);
  }
  
  public logout() {
    this.isAuthenticated = false;
    this.roles = [];
    this.username = '';
    this.accessToken = '';
    // Add any additional cleanup logic here
  }
  
  loadProfile(data: any) {
    this.isAuthenticated=true;
    this.accessToken = data['access-token'];

    let jwtdecoder:any = jwtDecode(this.accessToken);
    
    this.username = jwtdecoder.sub;
    this.roles = jwtdecoder.scope;
    
  }
}













