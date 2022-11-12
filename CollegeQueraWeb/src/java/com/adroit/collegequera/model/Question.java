package com.adroit.collegequera.model;

import java.sql.Date;

public class Question 
{
    private int qusid;
    private String qus;
    private Date qusDate;
    private int student;
    private String studentName;

    public Question(int qusid, String qus, Date qusDate, String name) {
        this.qusid = qusid;
        this.qus = qus;
        this.qusDate = qusDate;
        this.studentName = name;
    }
    
    public Question() {
    }

    public Question(int qusid, String qus, Date qusDate, int student) {
        this.qusid = qusid;
        this.qus = qus;
        this.qusDate = qusDate;
        this.student = student;
    }
    
    public Question(String qus, Date qusDate, int student) {        
        this.qus = qus;
        this.qusDate = qusDate;
        this.student = student;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    
    
    public int getQusid() {
        return qusid;
    }

    public void setQusid(int qusid) {
        this.qusid = qusid;
    }

    public String getQus() {
        return qus;
    }

    public void setQus(String qus) {
        this.qus = qus;
    }

    public Date getQusDate() {
        return qusDate;
    }

    public void setQusDate(Date qusDate) {
        this.qusDate = qusDate;
    }

    public int getStudent() {
        return student;
    }

    public void setStudent(int student) {
        this.student = student;
    }
}
