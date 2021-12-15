package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.Conexion;

public class LoginDAO {
	PreparedStatement ps=null;
	ResultSet res=null;
	Conexion con= new Conexion();
	Connection conecta=con.getConexion();

	
	
	
	 public LoginDTO login(LoginDTO us){
	  
		    LoginDTO u=null;
		    /*JOptionPane.showMessageDialog(null, us.getusuario());*/
		    /*JOptionPane.showMessageDialog(null, us.getPassword());*/
		    try{
		    String sql="select * from usuarios where usuario=? and password=?";
		    
		    ps =conecta.prepareStatement(sql);
		    ps.setString(1, us.getusuario());
			ps.setString(2, us.getPassword());
			res=ps.executeQuery();
			/*JOptionPane.showMessageDialog(null, "consulto");*/
		    if(res.next()){
		    /*JOptionPane.showMessageDialog(null, res.getString(5));*/
		       u= new LoginDTO(res.getString(5), res.getString(6), res.getString(7));
		       
		     }
		    }catch(SQLException ex){
		     /*JOptionPane.showMessageDialog(null,"Error al Consultar" +ex);*/
		    }
		    return u;
		    }
}

