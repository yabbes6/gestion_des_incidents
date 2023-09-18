import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { Incident } from 'src/app/models/incident';
import { IncidentsListService } from 'src/app/services/incidents-list.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-add-comment',
  templateUrl: './add-comment.component.html',
  styleUrls: ['./add-comment.component.scss']
})
export class AddCommentComponent implements OnInit {
  
  comments?:Comment[];
  incidents?:Incident[];
  commentForm : FormGroup;
  username = this.loginService.username;
  date_creation = new Date();
  id:any


  constructor(private fb:FormBuilder,public incident:IncidentsListService,public loginService:LoginService){}
  
  ngOnInit(): void {
    this.commentForm = this.fb.group({
      comment:[null,Validators.required],
      date_solution:[this.date_creation,Validators.required],
      incident:[this.incident.getCommentsByIncidentId(this.id),Validators.required],
      user:[this.username,Validators.required],
     })
   
  }

  handleComment(){
    var formData = this.commentForm.value;
    var data = {
      comment:formData.comment,
      date_solution :formData.date_solution,
      incident :formData.incident,
      user:formData.user
    }
    console.log(data);
    console.log(this.incident.idIncident)
    

  }

  

  
}
