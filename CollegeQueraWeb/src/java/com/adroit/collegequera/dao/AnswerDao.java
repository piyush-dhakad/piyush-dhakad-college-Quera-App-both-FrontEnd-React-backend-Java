package com.adroit.collegequera.dao;

import com.adroit.collegequera.model.Answer;
import com.adroit.collegequera.model.Question;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AnswerDao implements BaseDao<Answer>
{

    @Override
    public boolean save(Answer ob)
    {
 try 
        {
         Connection cnn = DBConnection.getConnection();
         
         String query = "insert into "
                 + "answer(ans,ansdate,faculty,question) "
                 + "value(?,?,?,?)";         
         PreparedStatement ps = cnn.prepareStatement(query);
         ps.setString(1, ob.getAns());
         ps.setDate(2, ob.getAnsDate());
         ps.setInt(3, ob.getFaculty());
         ps.setInt(4, ob.getQuestion());
         
         ps.executeUpdate();
         
         cnn.close();
         return true;
        }catch(Exception ex){
            System.out.println("Ans Save Error : " + ex.getMessage());
            return false;
        }        
    }

    @Override
    public boolean update(Answer ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Answer> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Answer get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Answer> list(int qid) 
    {
        List<Answer> alist = new ArrayList<>();
        
        try {
        
            Connection cnn = DBConnection.getConnection();            
            Statement stm = cnn.createStatement();

        String query = "select ans,ansdate,username "
                + "from answer,user "
                + "where question=" + qid
                + " and answer.faculty=user.userid";
            
        ResultSet rs = stm.executeQuery(query);
            
            while(rs.next())
            {                
                String ans = rs.getString("ans");
                Date date = rs.getDate("ansdate");
                String name = rs.getString("username");
                
                Answer ob = new Answer(ans, date, qid, 0);
                ob.setUserName(name);
                alist.add(ob);
            }
            cnn.close();
        }catch(Exception ex){
            System.out.println("Qus list : " + ex.getMessage());
        }
        return alist;
    }
    
}
