import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { Incident } from '../models/incident';
import { Comment } from '../models/comment';
import { AuthService } from './auth/auth.service';

@Injectable({
  providedIn: 'root'
})
export class IncidentsListService {

  baseUrl = "http://localhost:8089";


  constructor(private http: HttpClient,private authService:AuthService) { }

  getIncidentList(){
    return this.http.get(this.baseUrl + "/incidents");
  }

  public saveIncident(incident: Incident){
    return this.http.post(this.baseUrl + "/incident", incident);
  }

  public searchIncidents(keyword: string): Observable<Array<Incident>> {
    return this.http.get<Array<Incident>>(this.baseUrl + "/incident?nickname=" + keyword)
  }

  ////////  Comment

  public getCommentsByIncidentId(incidentId: number): Observable<Comment[]> {
    const url = `${this.baseUrl}/incidents/${incidentId}`;
    return this.http.get<Comment[]>(url);
  }

  public getCommentList(): Observable<Comment[]> {
    return this.http.get<Comment[]>(this.baseUrl + "/comments");
  }

  public chercherIncident(nickname:string){
    const url = `${this.baseUrl}/recherche?nickname=${nickname}`;
    return this.http.get<Incident[]>(url);

  }

  createIncident(incident: Incident): Observable<Incident> {
    const url = `${this.baseUrl}/incidents`;
    const headers = new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded',
      'Authorization': this.authService.accessToken // Replace with your JWT token
    });

    return this.http.post<Incident>(url, incident, { headers });
  }


  /*searchIncident(nickname:string): Observable<Incident[]> {
    return this.http.get<Incident[]>(this.baseUrl + "/incidents?nickname="+ nickname);
  }*/
}
