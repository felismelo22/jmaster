/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author felismelo
 */
public class config {
    private ResultSet resultSet;
    private Statement statement;
    private boolean success;
    
    public boolean getSuccess(){
        return success;
    }
    
    public void setSuccess(boolean success){
        this.success = success;
    }    
    
    public config(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            statement = DriverManager.getConnection("jdbc:mysql://localhost/jmaster","root","toor").createStatement();
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void query(String data){
        System.out.println(data);
        try{
            statement.executeUpdate(data);
            setSuccess(true);
        }catch(SQLException e){
            setSuccess(false);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public ResultSet show(String data){
        System.out.println(data);
        try{
            resultSet = statement.executeQuery(data);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return resultSet;
    }    
    
}
