package controlador;
import modelo.*;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class  Detalles_ventasPost {

    public static void insertar(HttpServletRequest request, HttpServletResponse response) throws IOException {

	 Detalles_ventasDAO Detalles_ventasDAO = new  Detalles_ventasDAO();
	 VentasDAO ventasDAO = new  VentasDAO();
	 
	 double cantidad = Double.parseDouble(request.getParameter("cantidad"));
	 double valor = Double.parseDouble(request.getParameter("valor"));
	 double valorTotal = cantidad * valor;

       Detalles_ventasDTO dato = new  Detalles_ventasDTO (
        Integer.parseInt(request.getParameter("id")),
        Integer.parseInt(request.getParameter("producto_id")),
        Integer.parseInt(request.getParameter("venta_id")),
        cantidad,
        valor,
        valorTotal
      );

      Detalles_ventasDAO.insertar(dato);
      ventasDAO.actualizarTotal(dato.getVenta_id());

      System.out.println("Se insertó la Tabla con el Id:" + dato.getId());
      response.sendRedirect("app?modulo=ventas&accion=editar&id=" + request.getParameter("venta_id"));
    }


    public static void actualizar(HttpServletRequest request, HttpServletResponse response) throws IOException {

     Detalles_ventasDAO Detalles_ventasDAO = new  Detalles_ventasDAO();
     VentasDAO ventasDAO = new  VentasDAO();

	 double cantidad = Double.parseDouble(request.getParameter("cantidad"));
	 double valor = Double.parseDouble(request.getParameter("valor"));
	 double valorTotal = cantidad * valor;

       Detalles_ventasDTO dato = new  Detalles_ventasDTO (
        Integer.parseInt(request.getParameter("id")),
        Integer.parseInt(request.getParameter("producto_id")),
        Integer.parseInt(request.getParameter("venta_id")),
        cantidad,
        valor,
        valorTotal
      );

      Detalles_ventasDAO.actualizar(dato);
      ventasDAO.actualizarTotal(dato.getVenta_id());      

      System.out.println("Se actualizó la Tabla con el Id:" + dato.getId());
      response.sendRedirect("app?modulo=ventas&accion=editar&id=" + request.getParameter("venta_id"));

    }


    public static void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException {

     Detalles_ventasDAO Detalles_ventasDAO = new  Detalles_ventasDAO();
     VentasDAO ventasDAO = new  VentasDAO();    
     
    Detalles_ventasDTO dato =  Detalles_ventasDAO.seleccionar(Integer.parseInt(request.getParameter("id")));
    Detalles_ventasDAO.eliminar(dato.getId());
    ventasDAO.actualizarTotal(dato.getVenta_id());
    
    response.sendRedirect("app?modulo=ventas&accion=editar&id="+dato.getVenta_id());
    }

    public static void regresar(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	response.sendRedirect("app?modulo=ventas&accion=editar&id=" + request.getParameter("venta_id"));
  }
}