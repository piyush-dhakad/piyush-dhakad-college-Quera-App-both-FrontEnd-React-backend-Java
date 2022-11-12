package com.adroit.collegequera.dao;

import com.adroit.collegequera.model.Question;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao implements BaseDao<Question>
{

    @Override
    public boolean save(Question ob) 
    {
    try 
        {
         Connection cnn = DBConnection.getConnection();
         
         String query = "insert into "
                 + "question(qus,qusdate,student) "
                 + "value(?,?,?)";         
         PreparedStatement ps = cnn.prepareStatement(query);
         ps.setString(1, ob.getQus());
         ps.setDate(2, ob.getQusDate());
         ps.setInt(3, ob.getStudent());
         
         ps.executeUpdate();
         
         cnn.close();
         return true;
        }catch(Exception ex){
            System.out.println("Qus Save Error : " + ex.getMessage());
            return false;
        }    
    }

    @Override
    public boolean update(Question ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Question> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Question get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Question> list(int studentid) 
    {
        List<Question> qlist = new ArrayList<>();
        
        try {
        
            Connection cnn = DBConnection.getConnection();            
            Statement stm = cnn.createStatement();
            
            ResultSet rs = stm.executeQuery("select * from "
                    + "question where student="+studentid);
            
            while(rs.next())
            {
                int qusid = rs.getInt("qusid");
                String qus = rs.getString("qus");
                Date date = rs.getDate("qusdate");
                Question ob  = new Question(qusid, qus, date, studentid);
                qlist.add(ob);
            }
            cnn.close();
        }catch(Exception ex){
            System.out.println("Qus list : " + ex.getMessage());
        }
        
        return qlist;
    }
    
    public List<Question> list(String branch) 
    {
        List<Question> qlist = new ArrayList<>();
        
        try {
        
            Connection cnn = DBConnection.getConnection();            
            Statement stm = cnn.createStatement();

        String query = "select qusid,qus,qusdate,username "
                + "from question,user "
                + "where student in "
                + "(select userid from user where "
                + "branch='"+branch+"' and type='student') "
                + "and question.student=user.userid";
            
        ResultSet rs = stm.executeQuery(query);
            
            while(rs.next())
            {
                int qusid = rs.getInt("qusid");
                String qus = rs.getString("qus");
                Date date = rs.getDate("qusdate");
                String name = rs.getString("username");
                
                Question ob  = new Question(qusid, qus, date, name);
                qlist.add(ob);
            }
            cnn.close();
        }catch(Exception ex){
            System.out.println("Qus list : " + ex.getMessage());
        }
        
        return qlist;
    }
    
}
