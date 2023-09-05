import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Incident } from '../models/incident';

@Injectable({
  providedIn: 'root'
})
export class IncidentsListService {

  baseUrl ="http://localhost:8089";

  constructor(private http:HttpClient) { }

  getIncidentList(): Observable<Incident[]> {
    return this.http.get<Incident[]>(this.baseUrl+"/incidents");
  }

  public saveIncident(incident: Incident):Observable<Incident>{
    return this.http.post<Incident>( this.baseUrl+"/incident",incident);
  }

  public searchIncidents(keyword : string):Observable<Array<Incident>>{
    return this.http.get<Array<Incident>>(this.baseUrl+"/incident?nickname="+keyword)
  }

  /*searchIncident(nickname:string): Observable<Incident[]> {
    return this.http.get<Incident[]>(this.baseUrl + "/incidents?nickname="+ nickname);
  }*/
}
