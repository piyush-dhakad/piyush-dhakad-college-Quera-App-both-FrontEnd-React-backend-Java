package com.adroit.collegequera.dao;

import com.adroit.collegequera.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UserDao implements BaseDao<User>
{

    @Override
    public boolean save(User ob)
    {
        try 
        {
         Connection cnn = DBConnection.getConnection();
         
         String query = "insert into "
                 + "user(username,email,password,type,branch) "
                 + "value(?,?,?,?,?)";         
         PreparedStatement ps = cnn.prepareStatement(query);
         
         ps.setString(1,ob.getUserName());
         ps.setString(2,ob.getEmail());
         ps.setString(3,ob.getPassword());
         ps.setString(4,ob.getType());
         ps.setString(5,ob.getBranch());
         
         ps.executeUpdate();
         
         cnn.close();
         return true;
        }catch(Exception ex){
            System.out.println("Register Error : " + ex.getMessage());
            return false;
        }
    }
    @Override
    public boolean update(User ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public List<User> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public User get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    

    public User loginUser(String email, String password) 
    {
        try
        {
            Connection cnn = DBConnection.getConnection();
            String query = "select * from user "
                    + "where email=? and password=?";
            PreparedStatement ps = cnn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                int id = rs.getInt("userid");
                String name = rs.getString("username");
                String type = rs.getString("type");
                String branch = rs.getString("branch");
                User ob = new User(id, name, email, "", type, branch);
                return ob;
            }else{
                return null;
            }
        }catch(Exception ex)
        {
            System.out.println("Login User : " + ex.getMessage());
            return null;
        }
    }
}
