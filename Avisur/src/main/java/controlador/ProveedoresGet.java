package controlador;
import modelo.*;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class ProveedoresGet {

    public static void listar(HttpServletRequest request) {
      ProveedoresDAO proveedoresDAO = new ProveedoresDAO();
      List<ProveedoresDTO> datos = proveedoresDAO.seleccionar();

      request.setAttribute("data",datos);
      request.setAttribute("vista","proveedores.jsp");

    }

    public static void crear(HttpServletRequest request) {
      ProveedoresDTO dato = new ProveedoresDTO();
      request.setAttribute("data",dato);
      request.setAttribute("vista","proveedores_edit.jsp");
    }


    public static void editar(HttpServletRequest request) {
      ProveedoresDAO proveedoresDAO = new ProveedoresDAO();

      ProveedoresDTO dato = new ProveedoresDTO();

      int id = Integer.parseInt(request.getParameter("id"));
      dato = proveedoresDAO.seleccionar(id);
      request.setAttribute("data",dato);
      request.setAttribute("vista","proveedores_edit.jsp");
  }
}