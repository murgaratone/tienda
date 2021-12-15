<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="javax.swing.JOptionPane"%>    

<%@page import="javax.servlet.http.HttpSession"%>
<%
	String tipoMensaje =  (String)request.getParameter("tipoMensaje");
	tipoMensaje = (tipoMensaje != null)?tipoMensaje:"info";
	
	String mensaje =  (String)request.getParameter("mensaje");
	HttpSession session2=request.getSession();
	session.removeAttribute("usuario");
	/*JOptionPane.showMessageDialog(null, session2);*/
%>   


<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/milligram.css">
	<link rel="stylesheet" href="css/styles.css">
	
	<script src="https://kit.fontawesome.com/712575d4a5.js" crossorigin="anonymous"></script>

	<title>vielfalt</title>

</head>
<body>
	<% if (mensaje != null) {   %>
	<div class="notificacion <%=tipoMensaje%>">
	  <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
	  <%=mensaje%>
	</div>
	<% } %>
	<main class="login-main container">
	
	
		
    <div class="row">
     <div class="column">
	    <div class="logo"></div>
	        <p>Bienvenidos al sistema </p>
	    <form action="Login" method="POST">
	      
		    <div id="login">
		      <label for="usuario">Usuario</label>
		      <input type="hidden" name="modulo" id="modulo" value="login">
		      <input name="usuario" id="usuario" type="text">
		      <label for="password">Password</label>
		      <input name="password" id="password" type="password">
		      
		      </div>
		      
		      <div class="row">
		      
		       <input type="submit" name="accion" value="Login">
		        <!-- <a class="button" href="index.jsp">MENU</a> -->
				
		    </div>
	      
	    </form>

    </div>
  </div>
  </main>

<footer>
	  <!-- <div class="redes">
       <a href="https://www.facebook.com/supertiendaonlineLATAM/"  class="fab fa-facebook-f icon1"  target="_blank"></a>
       <a href="https://www.instagram.com/supertiendaonlinelatam/?hl=es" class="fab fa-instagram icon2" target="_blank"></a>
       <a href="https://twitter.com/supertiendaonl1" class="fab fa-twitter icon3" target="_blank"></a>
       
    
    
    
    </div>  -->
    </footer>
    	
</body>
</html>

