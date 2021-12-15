package controlador;
import modelo.*;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class  VentasPost {

    public static void insertar(HttpServletRequest request, HttpServletResponse response) throws IOException {

     VentasDAO VentasDAO = new  VentasDAO();

       VentasDTO dato = new  VentasDTO (
        Integer.parseInt(request.getParameter("id")),
        String.valueOf(request.getParameter("codigo")),
        Integer.parseInt(request.getParameter("cliente_id")),
        Integer.parseInt(request.getParameter("usuario_id")),
        Double.parseDouble(request.getParameter("subtotal")),
        Double.parseDouble(request.getParameter("iva")),
        Double.parseDouble(request.getParameter("total")) 
      );


      VentasDAO.insertar(dato);

      System.out.println("Se insertó la Tabla con el Id:" + dato.getId());
      response.sendRedirect("app?modulo=Ventas&accion=editar&id=" + dato.getId());
    }


    public static void actualizar(HttpServletRequest request, HttpServletResponse response) throws IOException {

     VentasDAO VentasDAO = new  VentasDAO();

       VentasDTO dato = new  VentasDTO (
        Integer.parseInt(request.getParameter("id")),
        String.valueOf(request.getParameter("codigo")),
        Integer.parseInt(request.getParameter("cliente_id")),
        Integer.parseInt(request.getParameter("usuario_id")),
        Double.parseDouble(request.getParameter("subtotal")),
        Double.parseDouble(request.getParameter("iva")),
        Double.parseDouble(request.getParameter("total")) 
      );

      VentasDAO.actualizar(dato);

      System.out.println("Se actualizó la Tabla con el Id:" + dato.getId());
      response.sendRedirect("app?modulo=ventas&accion=editar&id=" + dato.getId());

    }


    public static void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException {

     VentasDAO VentasDAO = new  VentasDAO();

    VentasDAO.eliminar(Integer.parseInt(request.getParameter("id")));
    response.sendRedirect("app?modulo=ventas&accion=listar");
    }

    public static void regresar(HttpServletRequest request, HttpServletResponse response) throws IOException {
      response.sendRedirect("app?modulo=ventas&accion=listar");
  }
}
