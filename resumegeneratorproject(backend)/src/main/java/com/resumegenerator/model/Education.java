package com.resumegenerator.model;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int education_id;
    private String education_college;
    private String education_qualification;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate education_startdate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate education_enddate;
    private String education_summary;
    
    
    public Education() {
        super();
        //TODO Auto-generated constructor stub
    }
    public Education(int education_id, String education_college, String education_qualification,
            LocalDate education_startdate, LocalDate education_enddate, String education_summary) {
        super();
        this.education_id = education_id;
        this.education_college = education_college;
        this.education_qualification = education_qualification;
        this.education_startdate = education_startdate;
        this.education_enddate = education_enddate;
        this.education_summary = education_summary;
    }
    public int getEducation_id() {
        return education_id;
    }
    public void setEducation_id(int education_id) {
        this.education_id = education_id;
    }
    public String getEducation_college() {
        return education_college;
    }
    public void setEducation_college(String education_college) {
        this.education_college = education_college;
    }
    public String getEducation_qualification() {
        return education_qualification;
    }
    public void setEducation_qualification(String education_qualification) {
        this.education_qualification = education_qualification;
    }
    public LocalDate getEducation_startdate() {
        return education_startdate;
    }
    public void setEducation_startdate(LocalDate education_startdate) {
        this.education_startdate = education_startdate;
    }
    public LocalDate getEducation_enddate() {
        return education_enddate;
    }
    public void setEducation_enddate(LocalDate education_enddate) {
        this.education_enddate = education_enddate;
    }
    public String getEducation_summary() {
        return education_summary;
    }
    public void setEducation_summary(String education_summary) {
        this.education_summary = education_summary;
    }
}
    
