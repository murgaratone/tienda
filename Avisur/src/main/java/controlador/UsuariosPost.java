package controlador;
import modelo.*;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class  UsuariosPost {
	
    public static void  insertar(HttpServletRequest request, HttpServletResponse response ) throws IOException {
     request.setCharacterEncoding("UTF-8");
     UsuariosDAO UsuariosDAO = new  UsuariosDAO();
     

       UsuariosDTO dato = new  UsuariosDTO (
        Integer.parseInt(request.getParameter("id")),
        Long.parseLong(request.getParameter("cedula")),
        String.valueOf(request.getParameter("email")),
        String.valueOf(request.getParameter("nombre")),
        String.valueOf(request.getParameter("usuario")),
        new String(request.getParameter("password")),
        String.valueOf(request.getParameter("rol")) 
    		   );

       System.out.println("password " + dato.getPassword());
       System.out.println("password " + request.getCharacterEncoding());
      UsuariosDAO.insertar(dato);

      System.out.println("Se insertó la Tabla con el Id:" + dato.getId());
      response.sendRedirect("app?modulo=Usuarios&accion=editar&id=" + dato.getId());
    }


    public static void actualizar(HttpServletRequest request, HttpServletResponse response) throws IOException {

     UsuariosDAO UsuariosDAO = new  UsuariosDAO();

       UsuariosDTO dato = new  UsuariosDTO (
        Integer.parseInt(request.getParameter("id")),
        Long.parseLong(request.getParameter("cedula")),
        String.valueOf(request.getParameter("email")),
        String.valueOf(request.getParameter("nombre")),
        String.valueOf(request.getParameter("usuario")),
        String.valueOf(request.getParameter("password")),
        String.valueOf(request.getParameter("rol")) 
      );

      UsuariosDAO.actualizar(dato);

      System.out.println("Se actualizó la Tabla con el Id:" + dato.getId());
      response.sendRedirect("app?modulo=usuarios&accion=editar&id=" + dato.getId());

    }


    public static void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException {

     UsuariosDAO UsuariosDAO = new  UsuariosDAO();

    UsuariosDAO.eliminar(Integer.parseInt(request.getParameter("id")));
    response.sendRedirect("app?modulo=usuarios&accion=listar");
    }

    public static void regresar(HttpServletRequest request, HttpServletResponse response) throws IOException {
      response.sendRedirect("app?modulo=usuarios&accion=listar");
  }
    	
    
}