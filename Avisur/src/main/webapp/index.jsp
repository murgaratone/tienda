<%@page import="javax.swing.JOptionPane"%>
<%@ page import="modelo.*" %>
<%
/*HttpSession session=request.getSession();*/

UsuariosDTO usuarioConectado=(UsuariosDTO)session.getAttribute("usuarioConectado");
	if(usuarioConectado==null){
		response.sendRedirect("login.jsp");
	}
	
%>



<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	/*
    String usuario = (String)session.getAttribute("usuario");
	
	if (usuario==null) {
		response.sendRedirect("login.jsp");
	}
	*/
	
	
	
	  String vista = (String)request.getAttribute("vista");
	
	  int estilo;  
	
	  if (request.getParameter("estilo") != null) {
		  estilo = Integer.parseInt((String)request.getParameter("estilo")); 
	  } else if (session.getAttribute("estilo") != null) {
		  estilo = (int)session.getAttribute("estilo");  
	  } else {
		  estilo = 1;
	  }
		  
	  session.setAttribute("estilo", estilo);

	  if (vista == null) {
		  vista = "presentacion.jsp"; 
	  }
	  
	  String tipoMensaje =  (String)request.getParameter("tipoMensaje");
	  tipoMensaje = (tipoMensaje != null)?tipoMensaje:"info";
	  
	  String mensaje =  (String)request.getParameter("mensaje");	  
	  
	  System.out.println("Estilo utilizado: "+estilo);
	  
		String styleSheet = "styles.css";		 
	  
		if (estilo == 2) { 
		  styleSheet = "styleparty.css";
	  }
	

%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="css/milligram.css">
	
	
		<link rel="stylesheet" href="css/<%=styleSheet%>">

	

	
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	
	<link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
	<script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.10.1/html2pdf.bundle.min.js"></script>
	
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.63.1/codemirror.min.css" integrity="sha512-6sALqOPMrNSc+1p5xOhPwGIzs6kIlST+9oGWlI4Wwcbj1saaX9J3uzO3Vub016dmHV7hM+bMi/rfXLiF5DNIZg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<script src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.63.1/codemirror.min.js" integrity="sha512-w8mdbtlkBpU0p/dbFb4Oa1Hfd5k2mvOX82w0FnArHOPB28Ixai1Uj68X/3aK+/+35zNbTzBf9OfuSG+XTwnwCw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	
<script src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.63.1/mode/clike/clike.min.js" integrity="sha512-GAled7oA9WlRkBaUQlUEgxm37hf43V2KEMaEiWlvBO/ueP2BLvBLKN5tIJu4VZOTwo6Z4XvrojYngoN9dJw2ug==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.63.1/mode/sql/sql.min.js" integrity="sha512-dfObApt1XdGl62IJLrjbIOc9QtnRORA5TCwdnJkSj6C/KjwMz2L/Sc4WlcrgAuWoY+n5xTf6NMMojoUOlgwjug==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	
  
	<style>
	.CodeMirror {
  border: 1px solid #eee;
  height: auto;
}
	
	</style>
	
	<script>
	
	function imprimir_factura() {
		var factura = document.getElementById('factura-para-imprimir');
		html2pdf(factura);
	}
	
	var editor;
	$(document).ready(function() {
	  
	  $('select').select2({
		  theme: "classic"
	  });
	  
	  
	  
	  let codeArea = document.getElementById('definicion');
	  if (codeArea != undefined) { 
	  console.log(codeArea);
	  editor = CodeMirror.fromTextArea(codeArea, {
		    mode: 'text/x-sql',
		  	lineNumbers: true
		  });
	  }
	  
	 });  
	</script>	

	<title>avisur</title>

</head>
<body id="body_main" class="body_main">

<header >
	<div id="header" class="cabecera">
			<img class="inicio" href="login.jsp" src="./imgs/cropped-LOGO.png" alt="" width="150" height="60">
		<h1><a class="titulo" href="index.jsp"></a> <%=usuarioConectado.getRol()%></h1>
		<button class="close button line-height-2.8 text-white rounded p-2"arial-label="Close" ><a class="titulo" href="login.jsp">CERRAR SESION
		<span>&times;</span></a></button>
	</div>
	
	
</header>

<%if (estilo==2) { %>

<!--Cubos cayendo-->
<div class="fondo-animado">
	
		<span class="uno delay-1"></span>
		<span class="dos"></span>
		<span class="tres delay-5"></span>
		<span class="cuatro delay-1"></span>	
		
		<span class="uno delay-3"></span>
		<span class="dos delay-7"></span>
		<span class="tres delay-5"></span>
		<span class="cuatro delay-4"></span>
		
		<span class="uno delay-2"></span>
		<span class="dos delay-3"></span>
		<span class="tres delay-6"></span>
		<span class="cuatro delay-3"></span>	
	
</div>	
<!--fin-->

<% } %>

	
<nav class="navegacion" id="navega">
	<ul id="menu" class="menu">
		<%if (usuarioConectado.getRol().equals("administrador")){	%>
		
		<li><a href="index.jsp">Inicio</a></li>
		<%} %>
		<%if (usuarioConectado.getRol().equals("administrador")){	%>
		<li><a href="app?modulo=usuarios&accion=listar">Contador</a></li>
		<%} %>
		<%if (usuarioConectado.getRol().equals("administrador")||usuarioConectado.getRol().equals("Secretaria")){	%>
		<li><a href="app?modulo=clientes&accion=listar">Clientes</a></li>
		<%} %>
		<%if (usuarioConectado.getRol().equals("administrador")){	%>
		<li><a href="app?modulo=proveedores&accion=listar">Proveedores</a></li>
		<%} %>
		<%if (usuarioConectado.getRol().equals("administrador")){	%>
		<li><a href="app?modulo=productos&accion=listar">Productos</a></li>
		<%} %>
		
		<%if (usuarioConectado.getRol().equals("administrador")||usuarioConectado.getRol().equals("Secretaria")){	%>
		<li><a href="app?modulo=ventas&accion=listar">Secretaria</a></li>
		<%} %>
		<%if (usuarioConectado.getRol().equals("vendedor")
		||usuarioConectado.getRol().equals("administrador")){	%>
		<li><a href="app?modulo=ventas&accion=listar">Ventas</a></li>
		<%} %>
		<%if (usuarioConectado.getRol().equals("administrador")){	%>
		<li><a href="app?modulo=reportes&accion=ejecutar">Reportes</a></li>
		<%} %>
	</ul>
</nav>	

	<% if (mensaje != null) {   %>
	<div class="notificacion <%=tipoMensaje%>">
	  <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
	  <%=mensaje%>
	</div>
	<% } %>

	<main class="container">
	  <jsp:include  page="<%=vista%>" />
    </main>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>