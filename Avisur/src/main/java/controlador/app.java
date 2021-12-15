package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet
 */
@WebServlet(name = "ServletMetadata", urlPatterns = { "/app" })
@MultipartConfig/*para que los archivos carguen*/
public class app extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private String modulo;
	private String accion;
	
	private RequestDispatcher dispatcher;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public app() {
        super();
    }    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		modulo = request.getParameter("modulo").toLowerCase();
		accion = request.getParameter("accion").toLowerCase();
		
		System.out.println("Modulo: "+modulo);
		System.out.println("Accion: "+accion);
		
		switch (modulo.toLowerCase()) {
			case "login":
				switch (accion.toLowerCase()) {
				case "login":
					break;
				case "logout":
					break;
				default:
					break;
				}				
				break;
				
			case "usuarios":

				switch (accion) {
				case "listar":
					UsuariosGet.listar(request);
					break;					
				case "crear":
					UsuariosGet.crear(request);
					break;
				case "editar":
					UsuariosGet.editar(request);
					break;					
				}
				break;
			
			case "clientes":

				switch (accion) {
				case "listar":
					ClientesGet.listar(request);
					break;					
				case "crear": 
					ClientesGet.crear(request);
					break;
				case "editar":
					ClientesGet.editar(request);
					break;		
				case "cargar":
					ClientesGet.cargar(request);
					break;
				}
				break;
				
			case "proveedores":

				switch (accion) {
				case "listar":
					ProveedoresGet.listar(request);
					break;					
				case "crear": 
					ProveedoresGet.crear(request);
					break;
				case "editar":
					ProveedoresGet.editar(request);
					break;					
				}
				break;
				
			case "productos":

				switch (accion) {
				case "listar":
					ProductosGet.listar(request);
					break;					
				case "crear": 
					ProductosGet.crear(request);
					break;
				case "editar":
					ProductosGet.editar(request);
					break;
				case "cargar":
					ProductosGet.cargar(request);
					break;					
				}
				break;
				
			case "ventas":

				switch (accion) {
				case "listar":
					VentasGet.listar(request);
					break;					
				case "crear": 
					VentasGet.crear(request);
					break;
				case "editar":
					VentasGet.editar(request);
					break;					
				}
				break;	
				
			case "detalles_ventas":

				switch (accion) {
				case "crear": 
					Detalles_ventasGet.crear(request);
					break;
				case "editar":
					Detalles_ventasGet.editar(request);
					break;					
				}
				break;	
				
			case "reportes":

				switch (accion) {
				case "listar": 
					ReportesGet.listar(request);
					break;
				case "crear": 
					ReportesGet.crear(request);
					break;
				case "editar":
					ReportesGet.editar(request);
					break;					
				case "ejecutar":
					ReportesGet.ejecutar(request);
					break;					
				}
				break;						
				
			default:
				request.setAttribute("vista","presentacion.jsp");		
		}
		
		
			
		dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
		
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String modulo = request.getParameter("modulo");
		String accion = request.getParameter("accion");
		
		switch(modulo.toLowerCase()) {
			
	
			case "login": {

					switch (accion.toLowerCase()) {
						
					case "login": 
						break;
						

					default:
						break;					
				}
			}
			break;
				
			case "usuarios": {
				
				switch (accion.toLowerCase()) {
				
				case "crear":
					UsuariosPost.insertar(request, response);
					break;
					
				case "guardar":
					UsuariosPost.actualizar(request, response);
					break;
				
				case "eliminar": 
					UsuariosPost.eliminar(request, response);
					break;

				case "volver":
					UsuariosPost.regresar(request, response);
					break;

				default:
					UsuariosPost.regresar(request, response);
					break;
				}
			}
			
			break;
			
			case "clientes": {
				
				switch (accion.toLowerCase()) {
				
				case "crear":
					ClientesPost.insertar(request, response);
					break;
					
				case "guardar":
					ClientesPost.actualizar(request, response);
					break;
				
				case "eliminar": 
					ClientesPost.eliminar(request, response);
					break;

				case "volver":
					ClientesPost.regresar(request, response);
					break;
				case "cargar":
					ClientesPost.cargar(request, response);
					break;

				default:
					ClientesPost.regresar(request, response);
					break;
				}
			}
			
			break;
			
            case "proveedores": {
				
				switch (accion.toLowerCase()) {
				
				case "crear":
					ProveedoresPost.insertar(request, response);
					break;
					
				case "guardar":
					ProveedoresPost.actualizar(request, response);
					break;
				
				case "eliminar": 
					ProveedoresPost.eliminar(request, response);
					break;

				case "volver":
					ProveedoresPost.regresar(request, response);
					break;

				default:
					ProveedoresPost.regresar(request, response);
					break;
					
				}
			}
			
			break;
			
            case "productos": {
				
				switch (accion.toLowerCase()) {
				
				case "crear":
					ProductosPost.insertar(request, response);
					break;
					
				case "guardar":
					ProductosPost.actualizar(request, response);
					break;
				
				case "eliminar": 
					ProductosPost.eliminar(request, response);
					break;

				case "cargar":
					ProductosPost.cargar(request, response);
					break;
				
				case "volver":
					ProductosPost.regresar(request, response);
					break;

				default:
					ProductosPost.regresar(request, response);
					break;
					
				}
			}
			
			break;
			
            case "ventas": {
				
				switch (accion.toLowerCase()) {
				
				case "crear":
					VentasPost.insertar(request, response);
					break;
					
				case "guardar":
					VentasPost.actualizar(request, response);
					break;
				
				case "eliminar": 
					VentasPost.eliminar(request, response);
					break;

				case "volver":
					VentasPost.regresar(request, response);
					break;

				default:
					VentasPost.regresar(request, response);
					break;
					
				}
			}
			
			break;		
			
            case "detalles_ventas": {
				
				switch (accion.toLowerCase()) {
				
				case "crear":
					Detalles_ventasPost.insertar(request, response);
					break;
					
				case "guardar":
					Detalles_ventasPost.actualizar(request, response);
					break;
				
				case "eliminar": 
					Detalles_ventasPost.eliminar(request, response);
					break;

				case "volver":
					Detalles_ventasPost.regresar(request, response);
					break;

				default:
					Detalles_ventasPost.regresar(request, response);
					break;
					
				}
			}
			
			break;	
			
			case "reportes": {
				
				switch (accion.toLowerCase()) {
				
				case "crear": 
					ReportesPost.insertar(request, response);
					break;
					
				case "guardar": 
					ReportesPost.actualizar(request, response);
					break;
				
				case "eliminar": 
					ReportesPost.eliminar(request, response);
					break;

				case "volver":
					ReportesPost.regresar(request, response);
					break;
					
				default:
					ReportesPost.regresar(request, response);
					break;
				}
			}
			break;			
			
		}
		
	}

}