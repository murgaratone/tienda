package controlador;
import modelo.*;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class Detalles_ventasGet {

    public static void listar(HttpServletRequest request) {
      Detalles_ventasDAO detalles_ventasDAO = new Detalles_ventasDAO();
      List<Detalles_ventasDTO> datos = detalles_ventasDAO.seleccionar();
      
      request.setAttribute("data",datos);
      request.setAttribute("vista","detalles_ventas.jsp");

    }

    public static void crear(HttpServletRequest request) {
      Detalles_ventasDTO dato = new Detalles_ventasDTO();
      dato.setVenta_id(Integer.parseInt(request.getParameter("venta_id")));
      request.setAttribute("data",dato);
      
      ProductosDAO productosDAO = new ProductosDAO();
      ArrayList<ProductosDTO> listaProductosDAO = productosDAO.seleccionar();
      request.setAttribute("listaProductosDAO",listaProductosDAO);
      
      
      request.setAttribute("vista","detalles_ventas_edit.jsp");
      
      
    }


    public static void editar(HttpServletRequest request) {
      Detalles_ventasDAO detalles_ventasDAO = new Detalles_ventasDAO();

      Detalles_ventasDTO dato = new Detalles_ventasDTO();

      int id = Integer.parseInt(request.getParameter("id"));
      dato = detalles_ventasDAO.seleccionar(id);      
      request.setAttribute("data",dato);
      
      ListaDAO listaDAO = new ListaDAO();
      
      ProductosDAO productosDAO = new ProductosDAO();
      ArrayList<ProductosDTO> listaProductosDAO = productosDAO.seleccionar();
      request.setAttribute("listaProductosDAO",listaProductosDAO);
      
      ListaDTO listaProductos = listaDAO.seleccionar("PRODUCTOS");
      request.setAttribute("listaProductos",listaProductos);      
      
      request.setAttribute("vista","detalles_ventas_edit.jsp");
  }
}
