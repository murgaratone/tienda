package controlador;
import modelo.*;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class ReportesGet {

    public static void listar(HttpServletRequest request) {
      ReportesDAO reportesDAO = new ReportesDAO();
      List<ReportesDTO> datos = reportesDAO.seleccionar();

      request.setAttribute("data",datos);
      request.setAttribute("vista","reportes.jsp");

    }

    public static void crear(HttpServletRequest request) {
      ReportesDTO dato = new ReportesDTO();
      request.setAttribute("data",dato);
      request.setAttribute("vista","reportes_edit.jsp");
    }


    public static void editar(HttpServletRequest request) {
      ReportesDAO reportesDAO = new ReportesDAO();

      ReportesDTO dato = new ReportesDTO();

      int id = Integer.parseInt(request.getParameter("id"));
      dato = reportesDAO.seleccionar(id);
      request.setAttribute("data",dato);
      request.setAttribute("vista","reportes_edit.jsp");
  }
    
    public static void ejecutar(HttpServletRequest request) {  
    	
    	int reporteId = 0;
    	
    	if (request.getParameter("reporteId") != null) {
    	
    		reporteId = Integer.parseInt(request.getParameter("reporteId"));
    		
   		
    		if (reporteId != 0) {
    			GeneradorReportesDAO dao = new GeneradorReportesDAO();
    			DefinicionReporteDTO reporte = dao.seleccionar(reporteId);
    			request.setAttribute("reporte",reporte);
    		}
    		

    	}
    	   	
    	ListaDAO listaDAO = new ListaDAO();
	    ListaDTO listaReportes = listaDAO.seleccionar("REPORTES");
	    
	    
	    request.setAttribute("listaReportes",listaReportes);
	    request.setAttribute("reporteId",reporteId);
	    
	    
	    
	    request.setAttribute("vista","reportes_display.jsp");

    	
    }
    
    
}