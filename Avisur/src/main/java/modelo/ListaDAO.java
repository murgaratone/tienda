package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListaDAO {

	Map<String,String> definiciones;
	private Connection conexion;
	private PreparedStatement comando;	
	
	
	public ListaDAO() {
		
		definiciones = new HashMap<String,String>();
		
		definiciones.put("PROVEEDORES", "select nombre d, id r from proveedores order by 1");
		definiciones.put("PROVEEDORES_NIT", "select nit d, id r from proveedores order by 1");
		definiciones.put("CLIENTES", "select concat(cedula,' - ',nombre) d, id r from clientes order by 1");
		definiciones.put("USUARIOS", "select nombre d, id r from usuarios order by 1");
		definiciones.put("PRODUCTOS", "select concat(codigo,' - ',nombre) d, id r from productos order by 1");
		definiciones.put("REPORTES", "select nombre d, id r from generaappweb.reportes order by 1");
				
		
	    try {
	        conexion = Conexion.getConexion();
	      }
	      catch (Exception e) {
	        System.out.println("Error de SQL: " + e);
	      }
	    
	}
	
	
	public ListaDTO seleccionar(String nombre) {
		
		ListaDTO lista = new ListaDTO();
		ArrayList<ItemListaDTO> items = new ArrayList<ItemListaDTO>();
		

		String SQL = definiciones.get(nombre);		
		
	    try {
		      comando = conexion.prepareStatement(SQL);
		      ResultSet rs = comando.executeQuery();

		      while(rs.next()) {
		        items.add(new ItemListaDTO(
		                rs.getInt("R"),
		                rs.getString("D")
		        ));
		      }

		    } catch (SQLException e) {
		      System.out.println("Error de SQL al seleccionar: " + e);
		    }
	    
	    	lista.setNombre(nombre);
	    	lista.setItems(items);

		    return lista;
		
	}
	
	public ItemListaDTO seleccionar(String nombre, int id) {
		
		ItemListaDTO item = new ItemListaDTO();
		
		String SQL = 
				
				"select d, r from ( " +
    				definiciones.get(nombre) +
    			" ) as x where r = ?";
				
				;

	    try {
		      comando = conexion.prepareStatement(SQL);
		      comando.setInt(1,id);
		      ResultSet rs = comando.executeQuery();

		      if(rs.next()) {
		        item = new ItemListaDTO(
		                rs.getInt("R"),
		                rs.getString("D")
		        );
		      }
		      
		      

		    } catch (SQLException e) {
		      System.out.println("Error de SQL al seleccionar: " + e);
		    }
	    
		    return item;
		
	}	
	
	
	public int getId(String nombre, String descripcion) {
		
		int r=0;
		
		String SQL = 
				
				"select d, r from ( " +
    				definiciones.get(nombre) +
    			" ) x where d like '%'||?||'%'";
				
				;

	    try {
		      comando = conexion.prepareStatement(SQL);
		      comando.setString(1,descripcion);
		      
		      ResultSet rs = comando.executeQuery();

		      if(rs.next()) {
		        r = rs.getInt("R");
		      }
		      
		      

		    } catch (SQLException e) {
		      System.out.println("Error de SQL al seleccionar: " + e);
		    }
	    
		    return r;
		
	}	
	
	

}