import { Injectable } from '@angular/core';



// @Injectable({

//   providedIn: 'root'

// })

// export class UserService {



//   constructor() { }

// }

import { UserDetails } from './user-details';



import { Observable } from 'rxjs';



import {HttpClient} from '@angular/common/http';



@Injectable({



  providedIn: 'root'



})



export class user {



  constructor(private _http : HttpClient) { }



  public add(user: UserDetails):Observable<any>



  {
    console.log(user);

    return this._http.post<any>("http://localhost:8080/save",user)

  }



  public loginUserFromRemote(user: UserDetails):Observable<any>

  {
    const headers = { 'content-type': 'application/json'}  
   
    const body = JSON.stringify(user);

    return this._http.post<any>("http://localhost:8080/login",body,{"headers":headers});

  }



  public signupUserFromRemote(user: UserDetails):Observable<any>

  {

    console.log(user);

    return this._http.post<any>("http://localhost:8080/signup",user)

  }



}