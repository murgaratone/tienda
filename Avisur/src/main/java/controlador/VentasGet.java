package controlador;
import modelo.*;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class VentasGet {

    public static void listar(HttpServletRequest request) {
      VentasDAO ventasDAO = new VentasDAO();
      List<VentasDTO> datos = ventasDAO.seleccionar();

      request.setAttribute("data",datos);
      request.setAttribute("vista","ventas.jsp");

    }

    public static void crear(HttpServletRequest request) {
      
    	
    	
    	
      VentasDTO dato = new VentasDTO();
      request.setAttribute("data",dato);
      
      ListaDAO listaDAO = new ListaDAO();
      
      ListaDTO listaClientes = listaDAO.seleccionar("CLIENTES");
      ListaDTO listaUsuarios = listaDAO.seleccionar("USUARIOS");
      
      request.setAttribute("listaClientes",listaClientes);
      request.setAttribute("listaUsuarios",listaUsuarios);

      request.setAttribute("vista","ventas_edit.jsp");
      
    }

    public static void editar(HttpServletRequest request) {
      VentasDAO ventasDAO = new VentasDAO();

      VentasDTO dato = new VentasDTO();

      int id = Integer.parseInt(request.getParameter("id"));
      dato = ventasDAO.seleccionar(id);
      request.setAttribute("data",dato);
      
      ListaDAO listaDAO = new ListaDAO();
      
      ListaDTO listaClientes = listaDAO.seleccionar("CLIENTES");
      ListaDTO listaUsuarios = listaDAO.seleccionar("USUARIOS");
      
      request.setAttribute("listaClientes",listaClientes);
      request.setAttribute("listaUsuarios",listaUsuarios);
      
      
      Detalles_ventasDAO detalles_ventasDAO = new Detalles_ventasDAO(); 
      List<Detalles_ventasDTO> datos_detalles = detalles_ventasDAO.seleccionarVenta(id);
      
      request.setAttribute("data_detalle",datos_detalles);
      
      request.setAttribute("vista","ventas_edit.jsp");
  }
}
