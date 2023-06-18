import { Injectable } from '@angular/core';  
import { HttpClient } from '@angular/common/http';  
import { Observable } from 'rxjs';  
import { Experience } from './experience';

@Injectable({  
    providedIn: 'root'  
  })  
  export class ExperienceService {
 
    private baseUrl = 'http://localhost:8080/exp/';  
  
  
  constructor(private http:HttpClient) { } 
  getExperienceList(): Observable<any> {  
    return this.http.get(`${this.baseUrl}`+'experience');  
  }  
    
  createExperience(experience: any): Observable<object> {  
    return this.http.post(`${this.baseUrl}`+'save-experience', experience);  
  }  
  
  deleteExperience(id: number): Observable<any> {  
    return this.http.delete(`${this.baseUrl}/delete-experience/${id}`, { responseType: 'text' });  
  }  
  
  getExperience(id: number): Observable<Object> {  
    return this.http.get(`${this.baseUrl}/experience/${id}`);  
  }  
  updateExperience(id: number, value: any): Observable<Object> {  
    return this.http.post(`${this.baseUrl}/update-experience/${id}`, value);  
  }  
  
}  

   