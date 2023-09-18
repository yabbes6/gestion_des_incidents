import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth/auth.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  formLogin: FormGroup;

  constructor(private loginService: LoginService,private router:Router) { }

  ngOnInit() {

  }

  handleLogin(data: any) {
    this.loginService.login(data).subscribe(resp => {
      console.log(resp.headers.get('authorization'),resp);
      let jwt = resp.headers.get('authorization');
      this.loginService.saveToken(jwt);
      this.router.navigateByUrl("/");

    }, err => {

    })
  }



}
