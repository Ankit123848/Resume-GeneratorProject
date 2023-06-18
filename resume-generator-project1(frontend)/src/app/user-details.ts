import { Education } from "./education";
import { Experience } from "./experience";
import { Profile } from "./profile";


export class UserDetails {
    education!: Education;
    profile!: Profile;
     experience!: Experience;
  email: string | undefined;
  password: string | undefined;
  first_name: string | undefined;
  last_name: string | undefined;
  cpassword: string | undefined;
//     first_name! : string;
//     last_name! : string;
//     email! : string;
//     phone!: string;
//     designation!: string;

//     password!:string;
//     cpassword:any;

//     education_id!: number;
// education_college!: String ;
// education_qualification!: String;
// education_startdate!: String;
// education_enddate!: String;
// education_summary!: String;
  
// college: any;
// qualification: any;
// startdate: any;
// enddate: any;
// summary: any;

// experience_id!: number;
// experience_company!: String;
// experience_designation!: String;
// experience_startdate!: String;
// experience_enddate!: String;
}

   
