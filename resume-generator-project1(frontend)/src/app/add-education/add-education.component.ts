import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Education } from '../education';
import { EducationService } from '../education.service';

@Component({
  selector: 'app-add-education',
  templateUrl: './add-education.component.html',
  styleUrls: ['./add-education.component.css']
})
export class AddEducationComponent implements OnInit {
  constructor(
    private educationservice:EducationService) { 
   
  }  
  
  education : Education=new Education();  
  submitted = false;  

  ngOnInit(): void {
    this.submitted=false;  
  }
  educationsaveform=new FormGroup({  
    education_college:new FormControl('' , [Validators.required , Validators.minLength(5) ] ),  
    education_qualification:new FormControl('',[Validators.required,Validators.minLength(10)]),  
    education_startdate:new FormControl() ,
    education_enddate:new FormControl()  ,
    education_summary:new FormControl('' , [Validators.required , Validators.minLength(20) ]) 
  });  
  saveEducation(){  
    this.education=new Education();     
      
    this.education.education_college =this.EducationCollege() ;
    this.education.education_qualification=this.EducationQualification();
    this.education.education_startdate=this.EducationStartDate();
    this.education.education_enddate=this.EducationEndDate();
    this.education.education_summary=this.EducationSummary();
     console.log(this.education);
    this.submitted = true;  
    this.save();  
  }  
  save() {
    this.educationservice.createEducation(this.education) 

    .subscribe(data => console.log(data), error => console.log(error));  
    this.education = new Education();   
  }
  
    
  public EducationCollege() {
    return this.educationsaveform.get('education_college')?.value || '';

  }
  public EducationQualification() {
    return this.educationsaveform.get('education_qualification')?.value || '';
  }
  public EducationStartDate(){  
    return this.educationsaveform.get('education_startdate')?.value || '';  
  }  
  
  public EducationEndDate(){  
    return this.educationsaveform.get('education_enddate')?.value || '';  
  } 
  public EducationSummary(){  
    return this.educationsaveform.get('education_summary')?.value || ''; 
  }
  
  addEducationForm() {  
    this.submitted=false;  
    this.educationsaveform.reset();  
  }  
}  
  
  

