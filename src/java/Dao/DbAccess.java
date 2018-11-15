/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author KATY
 */
public class DbAccess {
       private static Connection conn = null;
      private static PreparedStatement pst = null;
      private static ResultSet rs = null;
      public static String username = null;
      public static String password = null;
      
    
  
    
  public static Connection getConnection(){ 
      
    Connection conn = null;
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/TestDB");
            conn = ds.getConnection();
 
        } catch (NamingException ex) {
            System.out.println("Problem with pull connection");
        } catch (SQLException ex) {
            System.out.println("Problem with pull connection");
        }
        return conn;

    }
    
    public static Connection CloseConnection(Connection connection){
    try{
        connection.close();
    }catch (SQLException ex) { }
    return connection;
}
   



    
}


