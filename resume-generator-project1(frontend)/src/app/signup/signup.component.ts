import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { user } from '../user.service';
import { UserDetails } from '../user-details';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  user = new UserDetails;
  submitted = false;
  msg = '';
  firstName: any;
  lastName: any;
  email: any;
  password: any;
  cpassword: any;
  constructor(private _service : user, private _router : Router) { }

  ngOnInit(): void {
    this.submitted = false;
  }

  form = new FormGroup({  
    firstName : new FormControl('' , Validators.required),  
    lastName : new FormControl('' , Validators.required), 
    email : new FormControl('' , Validators.required),  
    password : new FormControl('' , Validators.required),  
    cpassword : new FormControl('', Validators.required)
  });
  
  save(){  
    this.user.first_name=this.FirstName();
    this.user.last_name=this.LastName();
    this.user.email=this.Email();
    this.user.password=this.Password(); 
    this.user.cpassword = this.Cpassword(); 
    this.signupUser();  
  }  
  
  
  signupUser()
  {
    this._service.signupUserFromRemote(this.user)  
      .subscribe((data: any) => console.log(data), (error: any) => console.log(error));  
    this.user= new UserDetails();

    /*console.log(this.user);
    this.submitted = true;
    

    this._service.signupUserFromRemote(this.user).subscribe(
      _data =>{
        console.log("response recieved");
        this._router.navigate(['/login']);
      },
      error =>{
        console.log("error occured");
        this.msg = error.error;
      }
    );*/
  }
  public FirstName()
  {
    return this.form.get('firstName')?.value || '';    
  }
  public LastName()
  {
    return this.form.get('lastName')?.value || '';
  }
  public Email()
  {
    return this.form.get('email')?.value || '';
  }
  public Password()
  {
    return this.form.get('password')?.value || '';
  }
  public Cpassword()
  {
    return this.form.get('cpassword')?.value || '';
  }

  addUser(){  
    this.submitted=false;  
    this.form.reset();  
  }
}