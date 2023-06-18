import { Injectable } from '@angular/core';  
import { HttpClient } from '@angular/common/http';  
import { Observable } from 'rxjs';  

@Injectable({  
    providedIn: 'root'  
  })  
  export class EducationService {
  
  
    private baseUrl = 'http://localhost:8080/api/';  
 
  
  constructor(private http:HttpClient) { } 
  getEducationList(): Observable<any> {  
    return this.http.get(`${this.baseUrl}`+'education');  
  }  
   
  createEducation(education: any): Observable<object> {  
    return this.http.post(`${this.baseUrl}`+'save-education', education);  
  }  
  
  deleteEducation(id: number): Observable<any> {  
    return this.http.delete(`${this.baseUrl}/delete-education/${id}`, { responseType: 'text' });  
  }  
  
  getEducation(id: number): Observable<Object> {  
    return this.http.get(`${this.baseUrl}/education/${id}`);  
  }  
  
  updateEducation(id: number, value: any): Observable<Object> {  
    return this.http.post(`${this.baseUrl}/update-education/${id}`, value);  
  }  
    
}  
    
