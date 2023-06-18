import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UserDetailsnew } from 'src/user-detailsnew';
import { Education } from '../education';
import { Experience } from '../experience';
import { Profile } from '../profile';
import { UserDetails } from '../user-details';
import { user } from '../user.service';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {
  user:UserDetails = new UserDetails ;
  education: any;
  profile: any;
  experience: any;
  submitted!: false;


  constructor(private service : user) { }

  ngOnInit(): void {

    this.submitted=false;

  }
  userdetailsaveform1=new FormGroup({  
    education_college:new FormControl('' , [Validators.required , Validators.minLength(5) ] ),  
    education_qualification:new FormControl('',[Validators.required,Validators.minLength(10)]),  
    education_startdate:new FormControl() ,
    education_enddate:new FormControl()  ,
    education_summary:new FormControl('' , [Validators.required , Validators.minLength(20) ]) 



  });  
  save(){
    //UserDetails obj = new UserDetails();
    this.education=new Education();     
    this.education.education_college =this.EducationCollege() ;
    this.education.education_qualification=this.EducationQualification();
    this.education.education_startdate=this.EducationStartDate();
    this.education.education_enddate=this.EducationEndDate();
    this.education.education_summary=this.EducationSummary();
    console.log(this.education);
    this.profile=new Profile();
    this.profile.first_name=this.FirstName(); 
    this.profile.last_name=this.LastName();  
    this.profile.email=this.Email();  
    this.profile.phone = "2238976540";
    this.profile.designation = this.Designation(); 
    console.log(this.profile);
    this.experience=new Experience();
    this.experience.experience_company=this.ExperienceCompany() ;
    this.experience.experience_designation=this.ExperienceDesignation();
    this.experience.experience_startdate=this.ExperienceStartDate();
    this.experience.experience_enddate=this.ExperienceEndDate();
    console.log(this.experience);
    //this.submitted = false;  
    this.saveUser();
    }
    
    saveUser()
   {

    this.service.add(this.user)  
     
      .subscribe((data: any) => console.log(data), (error: any) => console.log(error));  

    this.user= new UserDetails();
  }
  public EducationCollege() {
    return this.userdetailsaveform1.get('education_college')?.value || '';

  }
  public EducationQualification() {
    return this.userdetailsaveform1.get('education_qualification')?.value || '';
  }
  public EducationStartDate(){  
    return this.userdetailsaveform1.get('education_startdate')?.value || '';  
  }  
  
  public EducationEndDate(){  
    return this.userdetailsaveform1.get('education_enddate')?.value || '';  
  } 
  public EducationSummary(){  
    return this.userdetailsaveform1.get('education_summary')?.value || ''; 
  }


  public FirstName(){  
    return this.userdetailsaveform1.get('first_name')?.value || ''; 
  }  
  public LastName(){  
    return this.userdetailsaveform1.get('last_name')?.value || '';  
  } 
  
  public Email(){  
    return this.userdetailsaveform1.get('email')?.value || '' ;  
  }  
  
  public Phone(){  
    return this.userdetailsaveform1.get('phone')?.value || '';  
  }  
  
  public Designation(){  
    return this.userdetailsaveform1.get('designation')?.value || '';  
  }  
   

  public ExperienceCompany() {
    return this.userdetailsaveform1.get('experience_company')?.value || '';

  }
  public ExperienceDesignation() {
    return this.userdetailsaveform1.get('experience_designation')?.value || '';
  }
  public ExperienceStartDate(){  
    return this.userdetailsaveform1.get('experience_startdate')?.value || '';  
  }  
  
  public ExperienceEndDate(){  
    return this.userdetailsaveform1.get('experience_enddate')?.value || '';  
  } 
  adduser() { 
    this.submitted=false;
    this.userdetailsaveform1.reset();  
  }  

}
