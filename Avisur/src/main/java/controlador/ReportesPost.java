package controlador;
import modelo.*;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class  ReportesPost {

    public static void insertar(HttpServletRequest request, HttpServletResponse response) throws IOException {

     ReportesDAO ReportesDAO = new  ReportesDAO();

       ReportesDTO dato = new  ReportesDTO (
        Integer.parseInt(request.getParameter("id")),
        String.valueOf(request.getParameter("nombre")),
        String.valueOf(request.getParameter("definicion")) 
      );


      ReportesDAO.insertar(dato);

      System.out.println("Se insertó la Tabla con el Id:" + dato.getId());
      response.sendRedirect("app?modulo=Reportes&accion=editar&id=" + dato.getId());
    }


    public static void actualizar(HttpServletRequest request, HttpServletResponse response) throws IOException {

     ReportesDAO ReportesDAO = new  ReportesDAO();

       ReportesDTO dato = new  ReportesDTO (
        Integer.parseInt(request.getParameter("id")),
        String.valueOf(request.getParameter("nombre")),
        String.valueOf(request.getParameter("definicion")) 
      );

      ReportesDAO.actualizar(dato);

      System.out.println("Se actualizó la Tabla con el Id:" + dato.getId());
      response.sendRedirect("app?modulo=reportes&accion=editar&id=" + dato.getId());

    }

    public static void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException {

     ReportesDAO ReportesDAO = new  ReportesDAO();

    ReportesDAO.eliminar(Integer.parseInt(request.getParameter("id")));
    response.sendRedirect("app?modulo=reportes&accion=listar");
    }

    public static void regresar(HttpServletRequest request, HttpServletResponse response) throws IOException {
      response.sendRedirect("app?modulo=reportes&accion=listar");
  }
}