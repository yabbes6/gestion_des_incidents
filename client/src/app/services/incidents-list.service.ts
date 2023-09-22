import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { Incident } from '../models/incident';
import { Comment } from '../models/comment';
import { AuthService } from './auth/auth.service';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class IncidentsListService {

  baseUrl = "http://localhost:8089";
  idIncident:any;
  idIncident2:any;


  constructor(private http: HttpClient,private loginService:LoginService) { }

  getIncidentList(){
    return this.http.get(this.baseUrl + "/incidents");
  }

  public saveIncident(incident: Incident){
    return this.http.post(this.baseUrl + "/incidents", incident);
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
    const url = `${this.baseUrl}/new-incidents`;
    console.log(incident)
    const headers = new HttpHeaders({
      'Content-Type' : 'application/x-www-form-urlencoded',
      'Authorization' : this.loginService.jwt // Replace with your JWT token
    });
    return this.http.post<Incident>(url, incident);
  }

  addCommentToIncident(incidentId: number, comment: Comment){
    const url = `${this.baseUrl}/incidents?id=${incidentId}`;
    return this.http.post(url, comment);
  }

  updateIncident(idIncident2: number, incident: Incident): Observable<any> {
    const url = `${this.baseUrl}/new-incidents/${idIncident2}`;
    return this.http.put(url, incident);
  }
 



  /*searchIncident(nickname:string): Observable<Incident[]> {
    return this.http.get<Incident[]>(this.baseUrl + "/incidents?nickname="+ nickname);
  }*/
}
