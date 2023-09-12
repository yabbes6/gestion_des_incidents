import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Incident } from 'src/app/models/incident';
import { IncidentsListService } from 'src/app/services/incidents-list.service';

@Component({
  selector: 'app-new-incident',
  templateUrl: './new-incident.component.html',
  styleUrls: ['./new-incident.component.scss']
})
export class NewIncidentComponent implements OnInit {
  
  incident:Incident= new Incident();

  @Input() hide=true 
          

  @Output() event= new EventEmitter<boolean>()
  
  constructor(private incidentsListService: IncidentsListService){}

  ngOnInit(): void {}

  onHide(){
    this.hide = !this.hide;
    this.event.emit(this.hide)
  }

  createIncident() {
    this.incidentsListService.createIncident(this.incident).subscribe(
      (data: Incident) => {
        console.log("Incident created:", data);
        // Optionally, navigate to a different page or perform other actions after successful creation
      },
      (error) => {
        console.error("Error creating incident:", error);
      }
    );
  }
  
}
