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


	  if (vista == null) {
		  vista = "presentacion.jsp"; 
	  }
	  
	  String tipoMensaje =  (String)request.getParameter("tipoMensaje");
	  tipoMensaje = (tipoMensaje != null)?tipoMensaje:"info";
	  
	  String mensaje =  (String)request.getParameter("mensaje");	  
	

%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/styleparty.css"> 
	<link rel="stylesheet" href="css/milligram.css">
	<!--  <link rel="stylesheet" href="css/styles.css"> -->
	<!--  <link rel="stylesheet" href="css/styloyellow.css">-->

	<title>Tienda Genérica</title>

</head>
<body class="body_main">

<header>
	<div id="header" class="cabecera">
		<a  class="logo2" id="logotipo" href="login.jsp"></a>
		<h1>Super Tienda Online</h1>
	</div>
</header>
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
<nav class="navegacion" id="navega">
	<ul class="menu">
		<li><a href="app?modulo=usuarios&accion=listar">Usuarios</a></li>
		<li><a href="app?modulo=clientes&accion=listar">Clientes</a></li>
		<li><a href="app?modulo=proveedores&accion=listar">Proveedores</a></li>
		<li><a href="app?modulo=productos&accion=listar">Productos</a></li>
		<li><a href="app?modulo=ventas&accion=listar">Ventas</a></li>
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
	
</body>
</html>