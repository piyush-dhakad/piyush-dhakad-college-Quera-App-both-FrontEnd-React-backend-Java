package com.adroit.collegequera.model;

public class User 
{
    private int userid;
    private String userName;
    private String email;
    private String password;
    private String type;
    private String branch;

    public User() {
    }

    public User(int userid, String userName, String email, String password, String type, String branch) {
        this.userid = userid;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.type = type;
        this.branch = branch;
    }
    
    public User(String userName, String email, String password, String type, String branch) {        
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.type = type;
        this.branch = branch;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
