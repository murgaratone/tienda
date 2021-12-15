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

public class  ClientesPost {

    public static void insertar(HttpServletRequest request, HttpServletResponse response) throws IOException {

     ClientesDAO ClientesDAO = new  ClientesDAO();

       ClientesDTO dato = new  ClientesDTO (
        Integer.parseInt(request.getParameter("id")),
        Long.parseLong(request.getParameter("cedula")),
        String.valueOf(request.getParameter("direccion")),
        String.valueOf(request.getParameter("email")),
        String.valueOf(request.getParameter("nombre")),
        String.valueOf(request.getParameter("telefono")) 
      );


      ClientesDAO.insertar(dato);

      System.out.println("Se insertó la Tabla con el Id:" + dato.getId());
      response.sendRedirect("app?modulo=Clientes&accion=editar&id=" + dato.getId());
    }


    public static void actualizar(HttpServletRequest request, HttpServletResponse response) throws IOException {

     ClientesDAO ClientesDAO = new  ClientesDAO();

       ClientesDTO dato = new  ClientesDTO (
        Integer.parseInt(request.getParameter("id")),
        Long.parseLong(request.getParameter("cedula")),
        String.valueOf(request.getParameter("direccion")),
        String.valueOf(request.getParameter("email")),
        String.valueOf(request.getParameter("nombre")),
        String.valueOf(request.getParameter("telefono")) 
      );

      ClientesDAO.actualizar(dato);

      System.out.println("Se actualizó la Tabla con el Id:" + dato.getId());
      response.sendRedirect("app?modulo=clientes&accion=editar&id=" + dato.getId());

    }


    public static void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException {

     ClientesDAO ClientesDAO = new  ClientesDAO();

    ClientesDAO.eliminar(Integer.parseInt(request.getParameter("id")));
    response.sendRedirect("app?modulo=clientes&accion=listar");
    }

    public static void regresar(HttpServletRequest request, HttpServletResponse response) throws IOException {
      response.sendRedirect("app?modulo=clientes&accion=listar");
  }
public static void cargar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	
     	
    	Part filePart = request.getPart("archivo");	

        InputStream inputStream = filePart.getInputStream();       

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            while (reader.ready()) {
                String line = reader.readLine();
                String[] datos = line.split(";");
                
                /*System.out.print("Clientes CEDULA:" + datos[2].trim());
                System.out.print("Clientes ID: "+new ListaDAO().getId("CLIENTES_NIT",datos[2].trim()));*/
                
                ClientesDTO clientesDTO = new ClientesDTO(
                		0,
                		Long.parseLong(datos[0]),
                		(datos[1]),
                		(datos[2]),
                		(datos[3]),
                		(datos[4])            		
                );
                
            	try {
        			
            		ClientesDAO clientesDAO = new ClientesDAO();
            		clientesDAO.insertar(clientesDTO);

        			
            	} catch (Exception e) {

            		e.printStackTrace();
         			
        		}  
                
                System.out.println(line);
            }
        } catch (IOException e) {
 
            e.printStackTrace();
    		
			
        }
        
    
        response.sendRedirect("app?modulo=clientes&accion=listar");
        
    }
}