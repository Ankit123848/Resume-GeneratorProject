import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(private http:HttpClient) { }
  getProfiles() : Observable<object>
  {
    //access httpclient module
    //import httpclientmodule in app.module.ts
    return this.http.get("http://localhost:8080/findAllProfiles");
  }
  add(profile: object): Observable<object> {  
    return this.http.post("http://localhost:8080/save", profile);  
  }  
}
