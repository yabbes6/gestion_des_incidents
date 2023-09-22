import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { IncidentsListService } from 'src/app/services/incidents-list.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-incident-update',
  templateUrl: './incident-update.component.html',
  styleUrls: ['./incident-update.component.scss']
})
export class IncidentUpdateComponent {
  incidentId: any;
  updatedIncident: any = {}; // Define the structure of your incident object
  date_creation = new Date();
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private incidentsListService: IncidentsListService,
    public loginService:LoginService
  ) { }

  ngOnInit(): void {
    
    // Get the incident ID from the route parameters
    this.incidentId = this.route.snapshot.paramMap.get('id') || 'yourDefaultString';;
  }

  updateIncident() {
    this.incidentsListService.updateIncident(this.incidentId, this.updatedIncident)
      .subscribe(
        (response) => {
          console.log('Incident updated successfully:', response);
          // Navigate to a different page or take other actions upon success
          this.router.navigate(['/']);
        },
        (error) => {
          console.error('Error updating incident:', error);
          // Handle the error, display a message to the user, or take appropriate action.
        }
      );
  }
}
