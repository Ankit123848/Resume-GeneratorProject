import { Component, OnInit } from '@angular/core';
import { ProfileService } from '../profile.service';
import {FormControl,FormGroup,Validators} from '@angular/forms';  /*added*/
import {Profile} from '../profile';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  // profiles : any;
  data= new Profile();
  constructor(private service : ProfileService) { }
  profile : Profile =new Profile();  
  submitted = false; 
  

  // ngOnInit(): void {
  //   // this.service.getProfiles().subscribe(data=>{
  //   //    this.profiles=data;
  //   this.submitted=false;
    
  //   };
  // }
  ngOnInit() {
    // this.service.getProfiles().subscribe(data=>{
    //    this.profiles=data;
    this.submitted=false;
  }
  profilesaveform = new FormGroup({  
    first_name :new FormControl('' , [Validators.required , Validators.minLength(3) ] ),
    last_name :new FormControl('' , [Validators.required , Validators.minLength(3) ] ),  
    email :new FormControl('',[Validators.required,Validators.email]),  
    phone: new FormControl('',  Validators.compose([Validators.required, Validators.minLength(10), Validators.maxLength(12)])),
    designation :  new FormControl('' , [Validators.required , Validators.minLength(1) ] ) 
  });  
  
  saveProfile(){  
    //this.profile=new Profile();     
    this.profile.first_name=this.FirstName(); 
    this.profile.last_name=this.LastName();  
    this.profile.email=this.Email();  
    this.profile.phone =this.Phone();
    this.profile.designation = this.Designation(); 
    this.save();  
  }  
  
    
  
  save() {  
    this.service.add(this.profile)  
      .subscribe((data: any) => console.log(data), (error: any) => console.log(error));  
    this.profile = new Profile();  
  }  
  
  
  public FirstName(){  
    return this.profilesaveform.get('first_name')?.value || ''; 
  }  
  public LastName(){  
    return this.profilesaveform.get('last_name')?.value || '';  
  } 
  
  public Email(){  
    return this.profilesaveform.get('email')?.value || '' ;  
  }  
  
  public Phone(){  
    return this.profilesaveform.get('phone')?.value || '';  
  }  
  
  public Designation(){  
    return this.profilesaveform.get('designation')?.value || '';  
  }  
   
  
  addStudentForm(){  
    this.submitted=false;  
    this.profilesaveform.reset();  
  }

}
