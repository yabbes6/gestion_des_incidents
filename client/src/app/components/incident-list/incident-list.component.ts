import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { IncidentsListService } from '../../services/incidents-list.service';
import { Incident } from 'src/app/models/incident';
import { Comment } from 'src/app/models/comment';


@Component({
  selector: 'app-incident-list',
  templateUrl: './incident-list.component.html',
  styleUrls: ['./incident-list.component.scss']
})
export class IncidentListComponent implements OnInit {

  comments: Comment[] = [];
  incidents: Incident[] = [];

  
  show =false;

  constructor(private incidentsListService: IncidentsListService) { }

  ngOnInit(): void {
    this.getAllIncidents();
  }

  onShow() {
    this.show = !this.show
  }

  private getAllIncidents() {
    this.incidentsListService.getIncidentList().subscribe(
      (data:Incident[]) => {
        this.incidents = data;
        
      },
      (error) => {
        console.error("Error fetching incidents:", error);
      }
    );
  }

  displayComment(){
    console.log("display comments")  
  }

  onSearch() {
  /*  if (this.searchQuery.trim() === '') {
      // Handle empty search query
      return;
    }
    this.incidentsListService.searchIncident(this.searchQuery).subscribe(
      (data: Incident[]) => {
        this.incidents = data;
      },
      (error) => {
        console.log("Error fetching incidents:", error);
      }
    );*/
  }

}