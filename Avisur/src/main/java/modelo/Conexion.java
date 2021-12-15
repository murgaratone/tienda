package modelo;

import java.sql.*;

public class Conexion {
  /**
   * Connect to a sample database
   */
  public static Connection getConexion() {
    Connection conn = null;
    
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
   
        try {


          // db parameters
          conn = DriverManager.getConnection("jdbc:mysql://localhost/avisur","root","maumorales");

          System.out.println("Connection to MySQL has been established.");

        } catch (SQLException e) {
          System.out.println("Error SQL: "+ e.getMessage());
          conn = null;       
        }
        
    } catch (Exception e) {
      System.out.println("Error En Driver: "+ e.getMessage());
    }

    return conn;

  }
  
}