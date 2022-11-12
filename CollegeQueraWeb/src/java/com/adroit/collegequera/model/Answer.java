package com.adroit.collegequera.model;

import java.sql.Date;

public class Answer 
{
    private int ansid;
    private String ans;
    private Date ansDate;
    private int question;
    private int faculty;
    
    private String userName;

    public Answer() {
    }

    public Answer(int ansid, String ans, Date ansDate, int question, int faculty) {
        this.ansid = ansid;
        this.ans = ans;
        this.ansDate = ansDate;
        this.question = question;
        this.faculty = faculty;
    }
    
    public Answer(String ans, Date ansDate, int question, int faculty) {     
        this.ans = ans;
        this.ansDate = ansDate;
        this.question = question;
        this.faculty = faculty;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    public int getAnsid() {
        return ansid;
    }

    public void setAnsid(int ansid) {
        this.ansid = ansid;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public Date getAnsDate() {
        return ansDate;
    }

    public void setAnsDate(Date ansDate) {
        this.ansDate = ansDate;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public int getFaculty() {
        return faculty;
    }

    public void setFaculty(int faculty) {
        this.faculty = faculty;
    }
    
    
}
