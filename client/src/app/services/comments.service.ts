import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Comment } from '../models/comment';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class CommentsService {

  baseUrl = "http://localhost:8089"

  constructor(private httpClient:HttpClient) { }

  getCommentList(): Observable<Comment[]> {
    return this.httpClient.get<Comment[]>(this.baseUrl+"/comments");
  }
}
