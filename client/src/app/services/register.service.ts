import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { User } from '../models/User';


@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  urlBase = "http://localhost:8089";

  constructor(private snackBar: MatSnackBar ,private http:HttpClient) { }

  openSnackBar(message: string, action: string) {
    if (action === 'error') {
      this.snackBar.open(message, '', {
        horizontalPosition: 'center',
        verticalPosition: 'top',
        duration: 2000,
        panelClass: ['red-snackbar']
      });
    } else {
      this.snackBar.open(message, '', {
        horizontalPosition: 'center',
        verticalPosition: 'top',
        duration: 2000,
        panelClass: ['green-snackbar']
      });
    }
  }

  signup(data:any):Observable<User>{
    return this.http.post<User>(this.urlBase+"/register",data);
  }


}
