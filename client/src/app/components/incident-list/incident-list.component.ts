import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { IncidentsListService } from '../../services/incidents-list.service';
import { Incident } from 'src/app/models/incident';
import { Comment } from 'src/app/models/comment';
import { AuthService } from 'src/app/services/auth/auth.service';
import { FormBuilder, FormGroup } from '@angular/forms';


@Component({
  selector: 'app-incident-list',
  templateUrl: './incident-list.component.html',
  styleUrls: ['./incident-list.component.scss']
})
export class IncidentListComponent implements OnInit {

  comments: Comment[] = [];
  
  incidentRecherche:Incident[]=[];
  nickname : string;
  formLogin: FormGroup;
  incidents: Incident[];

  show = false;

  constructor(
    private incidentsListService: IncidentsListService,
    public authService: AuthService,
    private fb:FormBuilder) { }

  ngOnInit(): void {
    this.getAllIncidents();

    this.formLogin = this.fb.group({
      nickname: this.fb.control(""),
    })
  }

  onShow() {
    this.show = !this.show
  }
  
  
  private getAllIncidents() {
    this.incidentsListService.getIncidentList().subscribe(
      (data:any) => {
        this.incidents = data;
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
      },
      (error) => {
        console.error("Error fetching comments:", error);
      }
    );
  }



  onSearch() {
    this.incidentsListService.chercherIncident(this.nickname).subscribe(
      (data: Incident[]) => {
        this.incidentRecherche = data;
      },
      (error) => {
        console.error("Error fetching incidents:", error);
      }
    );
  }

  onModify(){

  }
  

}