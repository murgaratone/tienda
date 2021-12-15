package controlador;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.mysql.cj.Session;

import modelo.*;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		session.invalidate();
		JOptionPane.showMessageDialog(null, session);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion=request.getSession();
		if(request.getParameter("accion")!=null){
	           
	            String u,c,r;
	            LoginDTO usdto;
	            try {
	            u=request.getParameter("usuario");
	            /*JOptionPane.showMessageDialog(null, u);*/
	            c=request.getParameter("password");
	            /*JOptionPane.showMessageDialog(null, c);*/
	            r=request.getParameter("rol");
	            /*JOptionPane.showMessageDialog(null, r);*/
	            LoginDTO lo=new LoginDTO(u,c,r);
	            LoginDAO lodao=new LoginDAO();
	            usdto=lodao.login(lo);
	            String y="pepe";
	            sesion.setAttribute("llevadat",y );
	            /*JOptionPane.showMessageDialog(null, usdto.getrol());*/
	            System.out.println(usdto);
	            /*String y="pepe";
	            sesion.setAttribute("llevadat",y );*/
	            /*JOptionPane.showMessageDialog(null, usdto.getusuario());*/
	            /*JOptionPane.showMessageDialog(null, usdto.getPassword());*/     
	                
	                	if(usdto.getusuario().equals(u) && usdto.getPassword().equals(c)){
	 	                   
		                     UsuariosDTO usuario=new UsuariosDAO().seleccionarUsuario(u); 
		                     /*JOptionPane.showMessageDialog(null, uss);*/
		                     // sesion.setAttribute("vsusuario",lo.getUsuario());
		                     /*JOptionPane.showMessageDialog(null, "iremos a la pagina");*/
		                     sesion.setAttribute("usuarioConectado",usuario );
		                     
		                     /*sesion.setAttribute("vs",usdto);*/
		                   
		                      request.getRequestDispatcher("index.jsp").forward(request, response);
		                      
		                      
			               }else {
			            	   request.getRequestDispatcher("login.jsp").forward(request, response);
			               }
					} catch (Exception e) {
						// TODO: handle exception
						/*request.setAttribute("mensaje", "Datos incorrectos");*/
						
						request.getRequestDispatcher("login.jsp?mensaje=datos+incorrectos").forward(request, response);
					}  
	            
	            }
	           }
	          
		   
	     }
	


