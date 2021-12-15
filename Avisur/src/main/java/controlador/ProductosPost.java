package controlador;
import modelo.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class  ProductosPost {

    public static void insertar(HttpServletRequest request, HttpServletResponse response) throws IOException {

     ProductosDAO ProductosDAO = new  ProductosDAO();

       ProductosDTO dato = new  ProductosDTO (
        Integer.parseInt(request.getParameter("id")),
        Long.parseLong(request.getParameter("codigo")),
        Double.parseDouble(request.getParameter("iva_compra")),
        Integer.parseInt(request.getParameter("proveedor_id")),
        String.valueOf(request.getParameter("nombre")),
        Double.parseDouble(request.getParameter("valor_compra")),
        Double.parseDouble(request.getParameter("valor_venta")) 
      );


      ProductosDAO.insertar(dato);

      System.out.println("Se insertó la Tabla con el Id:" + dato.getId());
      response.sendRedirect("app?modulo=Productos&accion=editar&id=" + dato.getId());
    }


    public static void actualizar(HttpServletRequest request, HttpServletResponse response) throws IOException {

     ProductosDAO ProductosDAO = new  ProductosDAO();

       ProductosDTO dato = new  ProductosDTO (
        Integer.parseInt(request.getParameter("id")),
        Long.parseLong(request.getParameter("codigo")),
        Double.parseDouble(request.getParameter("iva_compra")),
        Integer.parseInt(request.getParameter("proveedor_id")),
        String.valueOf(request.getParameter("nombre")),
        Double.parseDouble(request.getParameter("valor_compra")),
        Double.parseDouble(request.getParameter("valor_venta")) 
      );

      ProductosDAO.actualizar(dato);

      System.out.println("Se actualizó la Tabla con el Id:" + dato.getId());
      response.sendRedirect("app?modulo=productos&accion=editar&id=" + dato.getId());

    }


    public static void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException {

     ProductosDAO ProductosDAO = new  ProductosDAO();

    ProductosDAO.eliminar(Integer.parseInt(request.getParameter("id")));
    response.sendRedirect("app?modulo=productos&accion=listar");
    }

    public static void regresar(HttpServletRequest request, HttpServletResponse response) throws IOException {
      response.sendRedirect("app?modulo=productos&accion=listar");
  }
    
    public static void cargar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	
     	
    	Part filePart = request.getPart("archivo");	

        InputStream inputStream = filePart.getInputStream();       

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            while (reader.ready()) {
                String line = reader.readLine();
                String[] datos = line.split(";");
                
                System.out.print("Proveedor NIT:" + datos[2].trim());
                System.out.print("Proveedor ID: "+new ListaDAO().getId("PROVEEDORES_NIT",datos[2].trim()));
                
                ProductosDTO productosDTO = new ProductosDTO(
                		0,
                		Long.parseLong(datos[0]),
                		Double.parseDouble(datos[1]),
                		/*Integer.parseInt(datos[2].trim()),*/
                		new ListaDAO().getId("PROVEEDORES_NIT",datos[2].trim()),
                		datos[3],
                		Double.parseDouble(datos[4]),
                		Double.parseDouble(datos[5])              		
                );
                
            	try {
        			
            		ProductosDAO productosDAO = new ProductosDAO();
            		productosDAO.insertar(productosDTO);

        			
            	} catch (Exception e) {

            		e.printStackTrace();
         			
        		}  
                
                System.out.println(line);
            }
        } catch (IOException e) {
 
            e.printStackTrace();
    		
			
        }
        
    
        response.sendRedirect("app?modulo=productos&accion=listar");
        
    }
    
        
        
}