package com.adroit.collegequera.controller;

import com.adroit.collegequera.dao.AnswerDao;
import com.adroit.collegequera.model.Answer;
import com.adroit.collegequera.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "sendans",urlPatterns = {"/sendans"})
public class SendAnswerServlet extends HttpServlet
{
    private AnswerDao answerDao;

    @Override
    public void init(ServletConfig config) throws ServletException 
    {
        this.answerDao = new AnswerDao();
        super.init(config); //To change body of generated methods, choose Tools | Templates.
    }  
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("loginuser");
       
        String answer = req.getParameter("ans");
        int qid = Integer.parseInt(req.getParameter("qid"));
        Date date = new Date(System.currentTimeMillis());
        int userid = user.getUserid();
        
        Answer ansOb = new Answer(answer, date, qid, userid);
        
        boolean status = answerDao.save(ansOb);
        PrintWriter pw = resp.getWriter();
        if(status)
            pw.write("success");
        else
            pw.write("failed");
                    
    }    
}
