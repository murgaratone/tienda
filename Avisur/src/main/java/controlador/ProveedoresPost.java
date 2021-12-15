package controlador;
import modelo.*;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class  ProveedoresPost {

    public static void insertar(HttpServletRequest request, HttpServletResponse response) throws IOException {

     ProveedoresDAO ProveedoresDAO = new  ProveedoresDAO();

       ProveedoresDTO dato = new  ProveedoresDTO (
        Integer.parseInt(request.getParameter("id")),
        Long.parseLong(request.getParameter("nit")),
        String.valueOf(request.getParameter("ciudad")),
        String.valueOf(request.getParameter("direccion")),
        String.valueOf(request.getParameter("nombre")),
        String.valueOf(request.getParameter("telefono")) 
      );


      ProveedoresDAO.insertar(dato);

      System.out.println("Se insertó la Tabla con el Id:" + dato.getId());
      response.sendRedirect("app?modulo=Proveedores&accion=editar&id=" + dato.getId());
    }


    public static void actualizar(HttpServletRequest request, HttpServletResponse response) throws IOException {

     ProveedoresDAO ProveedoresDAO = new  ProveedoresDAO();

       ProveedoresDTO dato = new  ProveedoresDTO (
        Integer.parseInt(request.getParameter("id")),
        Long.parseLong(request.getParameter("nit")),
        String.valueOf(request.getParameter("ciudad")),
        String.valueOf(request.getParameter("direccion")),
        String.valueOf(request.getParameter("nombre")),
        String.valueOf(request.getParameter("telefono")) 
      );

      ProveedoresDAO.actualizar(dato);

      System.out.println("Se actualizó la Tabla con el Id:" + dato.getId());
      response.sendRedirect("app?modulo=proveedores&accion=editar&id=" + dato.getId());

    }


    public static void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException {

     ProveedoresDAO ProveedoresDAO = new  ProveedoresDAO();

    ProveedoresDAO.eliminar(Integer.parseInt(request.getParameter("id")));
    response.sendRedirect("app?modulo=proveedores&accion=listar");
    }

    public static void regresar(HttpServletRequest request, HttpServletResponse response) throws IOException {
      response.sendRedirect("app?modulo=proveedores&accion=listar");
  }
}