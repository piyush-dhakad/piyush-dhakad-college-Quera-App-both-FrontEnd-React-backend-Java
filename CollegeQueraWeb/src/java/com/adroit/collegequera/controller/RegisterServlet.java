package com.adroit.collegequera.controller;

import com.adroit.collegequera.dao.UserDao;
import com.adroit.collegequera.model.User;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "register",urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet
{
    private UserDao userDao;

    @Override
    public void init(ServletConfig config) throws ServletException 
    {
        this.userDao = new UserDao();
        super.init(config); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("application/json");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        
        JsonParser parser = new JsonParser();
        JsonElement mainElement =  parser.parse(request.getReader());        
        JsonObject mainObj = mainElement.getAsJsonObject();
                
        String name = mainObj.get("name").getAsString();
        String email = mainObj.get("email").getAsString();
        String password = mainObj.get("password").getAsString();
        String type = mainObj.get("type").getAsString();
        String branch = mainObj.get("branch").getAsString();
        
        User user = new User(name, email, password, type, branch);
        
        boolean status = userDao.save(user);
        
        JsonObject obj = new JsonObject();
        obj.addProperty("status", status);
        
        PrintWriter pw = response.getWriter();
        pw.write(obj.toString());
    }    
}


/*
http://localhost:8084/mitcollege/register.jsp
http://localhost:8084/mitcollege/register.jsp?status=true
http://localhost:8084/mitcollege/register.jsp?status=false
*/


