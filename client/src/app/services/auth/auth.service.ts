import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Route, Router } from '@angular/router';
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

  constructor(private http: HttpClient,private router:Router ) { }


  /*public login(username: string, password: string) {
    let options = {
      headers: new HttpHeaders().set("Content-Type","application/x-www-form-urlencoded")
    }
    let params = new HttpParams()
      .set("username", username)
      .set("password", password);
    return this.http.post(this.apiUrl+"/login",params,options);
  }
  
  public logout() {
    this.isAuthenticated = false;
    this.roles = undefined
    this.username = undefined
    this.accessToken = undefined
    //window.localStorage.removeItem("access-token")
    this.router.navigateByUrl('/login')
    // Add any additional cleanup logic here
  }
  
  loadProfile(data: any) {
    this.isAuthenticated=true;
    this.accessToken = data['access-token'];

    let decodedJwt:any = jwtDecode(this.accessToken);
    
    this.username = decodedJwt.sub;
    this.roles = decodedJwt.scope;

    window.localStorage.setItem("jwt-token",this.accessToken)
    
  }

  loadJwtTokenFromLocalStorage() {
    let token = window.localStorage.getItem("jwt-token")

    if(token){
      this.loadProfile({"access-token" : token});
      this.router.navigateByUrl("/");
    }
  }*/
}













