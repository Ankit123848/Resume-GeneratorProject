// import { NgModule} from '@angular/core';
// import {Routes,RouterModule} from '@angular/router';
// import { AddEducationComponent } from './add-education/add-education.component';
// import { AddExperienceComponent } from './add-experience/add-experience.component';



// const routes: Routes=[
//     { path: '', redirectTo: 'add-experience', pathMatch: 'full' }, 
//   { path: 'add-education', component: AddEducationComponent },  
//   { path: 'add-experience', component: AddExperienceComponent },
      
    
// ]
// @NgModule({
//     imports: [RouterModule.forRoot(routes)],
//     exports: [RouterModule]
// })
// export class AppRoutingModule{ }
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from './login/login.component';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginsuccessComponent } from './loginsuccess/loginsuccess.component';
import { SignupComponent } from './signup/signup.component';
import { AddEducationComponent } from './add-education/add-education.component';
import { AddExperienceComponent } from './add-experience/add-experience.component';
import { ProfileComponent } from './profile/profile.component';
import { UserDetails } from './user-details';
import { UserDetailsComponent } from './user-details/user-details.component';
const routes: Routes = [
  {path : '', component : HomepageComponent},
  {path : 'homepage', component : HomepageComponent},
  {path : 'loginsuccess', component : LoginsuccessComponent},
  {path : 'signup', component : SignupComponent},
  {path : 'login', component : LoginComponent},
  { path: 'add-education', component: AddEducationComponent },  
  { path: 'add-experience', component: AddExperienceComponent },
  {path : 'profile',component: ProfileComponent},
  {path : 'user-details' , component : UserDetailsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


