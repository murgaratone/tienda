package controlador;
import modelo.*;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class ProductosGet {

    public static void listar(HttpServletRequest request) {
      ProductosDAO productosDAO = new ProductosDAO();
      List<ProductosDTO> datos = productosDAO.seleccionar();

      request.setAttribute("data",datos);
      request.setAttribute("vista","productos.jsp");

    }

    public static void crear(HttpServletRequest request) {
      ProductosDTO dato = new ProductosDTO();
      request.setAttribute("data",dato);
     
      
      ListaDAO listaDAO = new ListaDAO();
      ListaDTO listaProveedor = listaDAO.seleccionar("PROVEEDORES");
      request.setAttribute("listaProveedor",listaProveedor);
      
      request.setAttribute("vista","productos_edit.jsp");
    }


    public static void editar(HttpServletRequest request) {
      ProductosDAO productosDAO = new ProductosDAO();

      ProductosDTO dato = new ProductosDTO();

      int id = Integer.parseInt(request.getParameter("id"));
      dato = productosDAO.seleccionar(id);
      request.setAttribute("data",dato);
      
      ListaDAO listaDAO = new ListaDAO();
      ListaDTO listaProveedor = listaDAO.seleccionar("PROVEEDORES");
      request.setAttribute("listaProveedor",listaProveedor);      
      
      request.setAttribute("vista","productos_edit.jsp");
  }

    public static void cargar(HttpServletRequest request) {		
		request.setAttribute("vista","productos_load.jsp");
    }    
}
