import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { IncidentsListService } from '../../services/incidents-list.service';
import { Incident } from 'src/app/models/incident';
import { Comment } from 'src/app/models/comment';
import { AuthService } from 'src/app/services/auth/auth.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { LoginService } from 'src/app/services/login.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-incident-list',
  templateUrl: './incident-list.component.html',
  styleUrls: ['./incident-list.component.scss']
})
export class IncidentListComponent implements OnInit {

  //comments: Comment[] = [];
  
  nickname : string;
  formLogin: FormGroup;
  incidents: Incident[];


  comments?:Array<Comment>;
  incident?:any;
  commentForm : FormGroup;
  username = this.loginService.username;
  date_creation = new Date();
  id:any



  constructor(
    private incidentsListService: IncidentsListService,
    public loginService: LoginService,
    private fb:FormBuilder,
    private router:Router
    ) { }

  ngOnInit(): void {
    this.getAllIncidents();

    this.formLogin = this.fb.group({
      nickname: this.fb.control(""),
    });


    this.commentForm = this.fb.group({
      comment:[null,Validators.required],
      date_solution:[this.date_creation,Validators.required],
      incident:[this.incident],
      user:[this.username,Validators.required],
     })
  }


  private getAllIncidents() {
    this.incidentsListService.getIncidentList().subscribe(
      (data:any) => {
        this.incidents = data;
        /*this.incidents.sort((a, b) => 
          new Date(a.date_creation) - new Date(b.date_creation))*/// Compare in descending order);
      },
      (error) => {
        console.error("Error fetching incidents:", error);
      }
    );
  }


  displayComment(id: any) {

    this.incidentsListService.getCommentsByIncidentId(id).subscribe(
      (data: any) => {
        this.comments = data;
        
        console.log(id)
        this.incident = id;
        this.incidentsListService.idIncident2 = id ;
      },
      (error) => {
        console.error("Error fetching comments:", error);
      }
    );
  }



  onSearch() {
    this.incidentsListService.chercherIncident(this.nickname).subscribe(
      (data: Incident[]) => {
        this.incidents = data;
      },
      (error) => {
        console.error("Error fetching incidents:", error);
      }
    );
  }

  validComment(){
    if(this.commentForm.controls["comment"].value === null&&
      this.commentForm.controls["date_solution"].value === null&&
      this.commentForm.controls["incident"].value === null&&
      this.commentForm.controls["user"].value === null){
        return true;
      }
      return false;

  }

  handleComment() {
    const formData = this.commentForm.value;

    // Extract and prepare comment data
    const commentData = {
      comment: formData.comment,
      date_solution: formData.date_solution,
      incident: formData.incident,
      user: formData.user
    };

    // Call the CommentService to add the comment
    this.incidentsListService.addCommentToIncident(this.incident, commentData).subscribe(
      (response:any) => {
        console.log('Comment added successfully:', response);
        //commentData.comment.push(response);
        // Reset the form or take other actions upon successful addition
        
        this.commentForm.reset();
        //location.reload();
      },
      (error:any) => {
       this. displayComment(this.incident);
       this.commentForm.controls["comment"].reset();
        console.error('Error adding comment:', error);
        // Handle the error, display a message to the user, or take appropriate action.
      }
    );
  }

  onModify(){
    
  }
  

}