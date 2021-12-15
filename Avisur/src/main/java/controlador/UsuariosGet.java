package controlador;
import modelo.*;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class UsuariosGet {

    public static void listar(HttpServletRequest request) {
      UsuariosDAO usuariosDAO = new UsuariosDAO();
      List<UsuariosDTO> datos = usuariosDAO.seleccionar();

      request.setAttribute("data",datos);
      request.setAttribute("vista","usuarios.jsp");

    }

    public static void crear(HttpServletRequest request) {
      UsuariosDTO dato = new UsuariosDTO();
      request.setAttribute("data",dato);
      request.setAttribute("vista","usuarios_edit.jsp");
    }


    public static void editar(HttpServletRequest request) {
      UsuariosDAO usuariosDAO = new UsuariosDAO();

      UsuariosDTO dato = new UsuariosDTO();

      int id = Integer.parseInt(request.getParameter("id"));
      dato = usuariosDAO.seleccionar(id);
      request.setAttribute("data",dato);
      request.setAttribute("vista","usuarios_edit.jsp");
  }
    
}