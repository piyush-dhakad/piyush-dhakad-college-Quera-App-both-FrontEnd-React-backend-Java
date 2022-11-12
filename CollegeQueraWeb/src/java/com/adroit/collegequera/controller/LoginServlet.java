package com.adroit.collegequera.controller;

import com.adroit.collegequera.dao.UserDao;
import com.adroit.collegequera.model.User;
import java.io.IOException;
import javax.jws.WebService;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "login",urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet
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
            HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        User user = userDao.loginUser(email,password);
        if(user==null)
            response.sendRedirect("login.jsp?err=1");
        else
        {
            HttpSession session = request.getSession();
            session.setAttribute("loginuser", user);
            
            if(user.getType().equals("faculty"))
                response.sendRedirect("facultyhome.jsp");
            else
                response.sendRedirect("studenthome.jsp");
        }
    }    
}



