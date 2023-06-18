import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, NgForm, Validators } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { user } from '../user.service';
import {UserDetails} from '../user-details';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user : UserDetails = new UserDetails();
  submitted = false;
  msg = '';
  email: any;
  password: any;
  constructor(private _service : user, private _router : Router) { }

  ngOnInit(): void {
    this.submitted = false;
  }

  form = new FormGroup({  
    email : new FormControl('' , Validators.required),  
    password : new FormControl('' , Validators.required)  
  }); 

 
save(){  
      
  this.user.email=this.Email(); 
  this.user.password = this.Password(); 
  this.loginUser();  
}  

  loginUser()
  {
    this._service.loginUserFromRemote(this.user)  
      .subscribe((data: any) => console.log(data), (error: any) => console.log(error));  
    this.user= new UserDetails();  
    
  
   /* console.log(this.user);
    this.submitted = true;
    this._service.loginUserFromRemote(this.user).subscribe(
     
      data => {
        console.log("Response Recieved");
        this._router.navigate(['/loginsuccess']);
      },
      _error => {
        console.log("Error occured");
        this.msg = "Please enter valid email and password.";
      }
    );*/
  }

  public Email()
  {
    return this.form.get('email')?.value || '';
  }
  public Password()
 {
    return this.form.get('password')?.value || '';
 }

 addUser(){  
  this.submitted=false;  
  this.form.reset();  
}
}


