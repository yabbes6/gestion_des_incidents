import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from '../services/auth/auth.service';

@Injectable()
export class AppHttpInterceptor implements HttpInterceptor {

  constructor(private authService: AuthService) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    const newRequest = request.clone({
      headers : 
        request.headers.set('Authorization', 'Bearer '+ this.authService.accessToken)
      });
      console.log(newRequest)
    //let newRequest = request.clone({headers: request.headers.set('Authorization', "Bearer " + this.authService.accessToken)});
    return next.handle(newRequest);
    // console.log(!request.url.includes('/auth/login'))
    // if (!request.url.includes('/auth/login')) {
    //   console.log("yassine")
      
    // }else{
    //   console.log("abbes")
    //    return next.handle(request);}



  }
}
