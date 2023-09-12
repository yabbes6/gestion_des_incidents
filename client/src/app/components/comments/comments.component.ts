import { Component, Input, OnInit } from '@angular/core';
import { Comment } from 'src/app/models/comment';
import { Incident } from 'src/app/models/incident';
import { IncidentsListService } from 'src/app/services/incidents-list.service';


@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.scss']
})
export class CommentsComponent implements OnInit {
  comments?:Comment[];
  incidents?:Incident[];


  constructor(private incidentsListService:IncidentsListService){}
  
  ngOnInit(): void {
    //this.getAllComment();
    //this.getAllIncidents();
  }

  /*private getAllComment(){
    return this.incidentsListService.getCommentList().subscribe(
      (data:Comment[])=>{
        this.comments=data;
      },
      (error) => {
        console.error("Error fetching incidents:", error);
      }
    );
  }*/

  private getIncidentComment(id:any){
    return this.incidentsListService.getCommentList().subscribe(
      (data:Comment[])=>{
        this.comments=data;
      },
      (error) => {
        console.error("Error fetching incidents:", error);
      }
    );
  }

  /*private getAllIncidents() {
    this.incidentsListService.getIncidentList().subscribe(
      (data:Incident[]) => {
        this.incidents = data;  
      },
      (error) => {
        console.error("Error fetching incidents:", error);
      }
    );
  }*/

}
