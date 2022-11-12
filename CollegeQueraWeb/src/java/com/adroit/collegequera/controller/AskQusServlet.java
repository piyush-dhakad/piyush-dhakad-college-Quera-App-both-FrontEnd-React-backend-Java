package com.adroit.collegequera.controller;

import com.adroit.collegequera.dao.QuestionDao;
import com.adroit.collegequera.model.Question;
import com.adroit.collegequera.model.User;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "askqus",urlPatterns = {"/askqus"})
public class AskQusServlet extends HttpServlet
{
    private QuestionDao questionDao;

    @Override
    public void init(ServletConfig config) throws ServletException 
    {
        this.questionDao = new QuestionDao();
        super.init(config); //To change body of generated methods, choose Tools | Templates.
    }    
    
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("loginuser");
        
        String qus = request.getParameter("qus");
        Date date = new Date(System.currentTimeMillis());
        int userid = user.getUserid();
        
        Question question = new Question(qus, date, userid);
        
        questionDao.save(question);
        response.sendRedirect("askquestion.jsp");
    }
    
}
