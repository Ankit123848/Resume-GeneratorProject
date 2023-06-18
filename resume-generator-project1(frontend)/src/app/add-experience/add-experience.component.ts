import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Experience } from '../experience';
import { ExperienceService } from '../experience.service';

@Component({
  selector: 'app-add-experience',
  templateUrl: './add-experience.component.html',
  styleUrls: ['./add-experience.component.css']
})
export class AddExperienceComponent implements OnInit {
  
  constructor(private experienceservice:ExperienceService) { 
   
  }  
  
  experience : Experience=new Experience();  
  submitted = false;  

  ngOnInit(): void {
    this.submitted=false;  
  }
  experiencesaveform=new FormGroup({  
    experience_company:new FormControl('' , [Validators.required , Validators.minLength(5) ] ),  
    experience_designation:new FormControl('',[Validators.required,Validators.minLength(10)]),  
    experience_startdate:new FormControl() ,
    experience_enddate:new FormControl()  ,
    
  }); 
  saveExperience(){  
    this.experience=new Experience();     
      
    this.experience.experience_company=this.ExperienceCompany() ;
    this.experience.experience_designation=this.ExperienceDesignation();
    this.experience.experience_startdate=this.ExperienceStartDate();
    this.experience.experience_enddate=this.ExperienceEndDate();
  
     console.log(this.experience);
    this.submitted = true;  
    this.save();  
  }  
  save() {
    this.experienceservice.createExperience(this.experience)  
    .subscribe(data => console.log(data), error => console.log(error));   
    this.experience = new Experience();  
  }
  public ExperienceCompany() {
    return this.experiencesaveform.get('experience_company')?.value || '';

  }
  public ExperienceDesignation() {
    return this.experiencesaveform.get('experience_designation')?.value || '';
  }
  public ExperienceStartDate(){  
    return this.experiencesaveform.get('experience_startdate')?.value || '';  
  }  
  
  public ExperienceEndDate(){  
    return this.experiencesaveform.get('experience_enddate')?.value || '';  
  } 
  
  
  addExperienceForm() {  
    this.submitted=false;  
    this.experiencesaveform.reset();  
  }  
}  




