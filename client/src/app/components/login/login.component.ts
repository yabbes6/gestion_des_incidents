import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  formLogin:FormGroup;
  
  constructor( 
    private fb:FormBuilder, 
    private authService:AuthService, 
    private router:Router
    ){}

  ngOnInit(){
    this.formLogin= this.fb.group({
      username:this.fb.control(""),
      password:this.fb.control("")
    })

  }

  handleLogin(){
    let username = this.formLogin.value.username;
    let password = this.formLogin.value.password;
    console.log(username,password);
    this.authService.login(username,password).subscribe({
      next : value => {
        console.log('hhhh ',value)
          //this.authService.loadProfile(value);
          //this.router.navigateByUrl("/");
      },error:err=>{
        console.log('gggg',err);
      }
    })
  }

}
