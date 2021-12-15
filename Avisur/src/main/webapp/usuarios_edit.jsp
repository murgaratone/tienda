<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="modelo.*" %>
<%@ page import="java.util.*" %>


<%
  String modulo = (String)request.getAttribute("modulo");
  UsuariosDTO data = (UsuariosDTO)request.getAttribute("data");
%>

<h2>Editar Registro de Usuarios</h2>
<form action="app" method="post">
  <fieldset>
    <input type="hidden" name="modulo" id="modulo" value="usuarios">
    <input type="hidden" name="id" id="id" value="<%=data.getId()%>" >
    <label for="cedula">Cedula</label>
    <input type="number" name="cedula" id="cedula" value="<%=data.getCedula()%>" >
    <label for="email">Correo</label>
    <input type="text" name="email" id="email" value="<%=data.getEmail()%>" >
    <label for="nombre">Nombre Completo</label>
    <input type="text" name="nombre" id="nombre" value="<%=data.getNombre()%>" >
    <label for="usuario">Nombre de Usuario</label>
    <input type="text" name="usuario" id="usuario" value="<%=data.getUsuario()%>" >
    <label for="password">Password</label>
    <input type="text" name="password" id="password" value="<%=data.getPassword()%>" >
    <label for="rol">Cargo de Empleado</label>
    <select name="rol" value="<%=data.getRol()%>">
        <option value="value2">----</option>
       
		<option value="administrador">Administrador</option>
		
		<option value="vendedor">Vendedor</option>
		
		<option value="Secretaria">Secretaria</option>
		
	</select> 
  </fieldset>
  <fieldset>
  
  <% if (data.getId() == 0 ) { %>
  
    <input type="submit" name="accion" value="Crear">
  
  <% } else { %>
    
    <input type="submit" name="accion" value="Guardar">
    <input type="submit" name="accion" value="Eliminar">
  
  <% } %> 
    <input type="submit" name="accion" value="Volver">
    
  </fieldset>
</form>
