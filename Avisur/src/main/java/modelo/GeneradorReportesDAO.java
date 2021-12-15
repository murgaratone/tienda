package modelo;

import java.sql.*;
import java.util.ArrayList;

public class GeneradorReportesDAO {

	private Connection conexion;
	private PreparedStatement comando;	
	
	
	public GeneradorReportesDAO() {
		
		
	    try {
	        conexion = Conexion.getConexion();
	      }
	      catch (Exception e) {
	        System.out.println("Error de SQL: " + e);
	      }
	    
	}
	
	
	public DefinicionReporteDTO seleccionar(int reporteId) {
		
		
		ReportesDAO dao = new ReportesDAO();
		ReportesDTO reportesDTO = dao.seleccionar(reporteId);
		
		
		DefinicionReporteDTO reporte = new DefinicionReporteDTO();
		String SQL = reportesDTO.getDefinicion();
		boolean getEncabezado = false;
		
	    try {
	    	
		      comando = conexion.prepareStatement(SQL);
		      ResultSet rs = comando.executeQuery();
		      ResultSetMetaData metadata = rs.getMetaData();
		      int columnas = metadata.getColumnCount();    
		      


		      while(rs.next()) {

		    	  if (!getEncabezado) {

			    	  for (int numColumna = 1; numColumna <= columnas; numColumna++ ) {
			    		  reporte.addColumna(metadata.getColumnLabel(numColumna));
			    		  //System.out.println(metadata.getColumnName(numColumna));
			    		  //System.out.println(metadata.getColumnTypeName(numColumna));
		    		  
			    	  }
			    	  
			    	  getEncabezado = true;
		    	  
			      }
		    	  
		    	  ArrayList<String> registro = new ArrayList<String>();
		    	  
		    	  for (int numColumna = 1; numColumna <= columnas; numColumna++ ) {
		    	  
		    		  String valorColumna = (rs.getString(numColumna) != "null") ? rs.getString(numColumna) :""; 
		    		  
		    		  registro.add(valorColumna);
		    		  
		    	  }
		    	  
		    	  reporte.addRegistro(registro);
		    	  
		      }

		    } catch (SQLException e) {
		      System.out.println("Error de SQL al seleccionar: " + e);
		    }
	    

		    return reporte;
		
	}

}