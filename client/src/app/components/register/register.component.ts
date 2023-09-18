import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RegisterService } from 'src/app/services/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  registrationForm: FormGroup;
  password:true
  confirmedPassword:true
  responseMessage:any

  constructor(private fb: FormBuilder,private registerService:RegisterService,private router:Router) { }

  ngOnInit():void {
    this.registrationForm = this.fb.group({
      nom: [null, Validators.required],
      prenom: [null, Validators.required],
      username: [null, Validators.required],
      password: [null, [Validators.required, Validators.minLength(4)]],
      confirmedPassword: [null, [Validators.required, Validators.minLength(4)]]
    }); 
  }

  onSubmitValidation() {
    if (this.registrationForm.controls['password'].value != this.registrationForm.controls['confirmedPassword'].value 
        && this.registrationForm.controls['password'].value === null) {
      return true;
    }else {
      return false;}
  }

  onSubmit(){
    let formData = this.registrationForm.value;
    let data = {
      nom:formData.nom,
      prenom:formData.prenom,
      username:formData.username,
      password:formData.password,
    }
    console.log(data)
    
    this.registerService.signup(data).subscribe((response:any)=>{
      this.responseMessage = response?.message;
      console.log(response)
      this.router.navigate(['/']);
    } ,(error)=>{
      if(error.error?.message) 
        this.responseMessage= error.error?.message;
      this.registerService.openSnackBar(this.responseMessage,"something wrong !!");
    }
    )
  }
}

