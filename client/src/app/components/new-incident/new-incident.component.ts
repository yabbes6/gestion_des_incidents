import { formatDate } from '@angular/common';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, ValidationErrors, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable, of } from 'rxjs';
import { Incident } from 'src/app/models/incident';
import { IncidentsListService } from 'src/app/services/incidents-list.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-new-incident',
  templateUrl: './new-incident.component.html',
  styleUrls: ['./new-incident.component.scss']
})
export class NewIncidentComponent implements OnInit {
  
  incident:Incident= new Incident();
  incidentForm: FormGroup;
  username = this.loginService.username;
  date_creation = new Date();

  @Input() hide=true 
          

  @Output() event= new EventEmitter<boolean>()
  
  constructor(private route:Router,private incidentsListService: IncidentsListService,public loginService:LoginService,private fb: FormBuilder){}

  ngOnInit(): void {
    this.incidentForm = this.fb.group({
      user: [this.username,Validators.required],
      incidentType: [null, Validators.required],
      description: [null, Validators.required],
      status:[null,Validators.required],
      date_creation:[this.date_creation,Validators.required]
    });
  }

  onHide(){
    this.hide = !this.hide;
    this.event.emit(this.hide)
  }

  formValidators(){
    if(this.incidentForm.value == null ){
      //console.log(this.incidentForm.value);
      return true;
    }else 
      return false;
    

  }

  onSubmit() {
    if (this.incidentForm.valid) {
      console.log(this.incidentForm.value);
      this.incidentsListService.createIncident(this.incidentForm.value).subscribe(
        (incident)=>{
          console.log(incident)
          this.incident = incident;
          this.route.navigate(['/']);
        },
        (error)=>{
            console.error(error.message)
        })
    }
  }
  
}
