package controlador;
import modelo.*;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class ClientesGet {

    public static void listar(HttpServletRequest request) {
      ClientesDAO clientesDAO = new ClientesDAO();
      List<ClientesDTO> datos = clientesDAO.seleccionar();

      request.setAttribute("data",datos);
      request.setAttribute("vista","clientes.jsp");

    }

    public static void crear(HttpServletRequest request) {
      ClientesDTO dato = new ClientesDTO();
      request.setAttribute("data",dato);
      request.setAttribute("vista","clientes_edit.jsp");
    }


    public static void editar(HttpServletRequest request) {
      ClientesDAO clientesDAO = new ClientesDAO();

      ClientesDTO dato = new ClientesDTO();

      int id = Integer.parseInt(request.getParameter("id"));
      dato = clientesDAO.seleccionar(id);
      request.setAttribute("data",dato);
      request.setAttribute("vista","clientes_edit.jsp");
  }
    public static void cargar(HttpServletRequest request) {		
		request.setAttribute("vista","clientes_load.jsp");
    }
}