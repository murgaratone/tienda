<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="modelo.*" %>
<%@ page import="java.util.*" %>


<%
  String modulo = (String)request.getAttribute("modulo");
  ClientesDTO data = (ClientesDTO)request.getAttribute("data");
%>

<h2>Editar Registro de Clientes</h2>
<form action="app" method="post">
  <fieldset>
    <input type="hidden" name="modulo" id="modulo" value="clientes">
    <input type="hidden" name="id" id="id" value="<%=data.getId()%>" required>
    <label for="cedula">Cedula</label>
    <input type="number" name="cedula" id="cedula" value="<%=data.getCedula()%>" required>
    <label for="direccion">Direccion</label>
    <input type="text" name="direccion" id="direccion" value="<%=data.getDireccion()%>" required>
    <label for="email">Email</label>
    <input type="text" name="email" id="email" value="<%=data.getEmail()%>" required>
    <label for="nombre">Nombre Completo</label>
    <input type="text" name="nombre" id="nombre" value="<%=data.getNombre()%>" required>
    <label for="telefono">Telefono</label>
    <input type="text" name="telefono" id="telefono" value="<%=data.getTelefono()%>" required>
  </fieldset>
  <fieldset>
  
  <% if (data.getId() == 0 ) { %>
  
    <input class="button" type="submit" name="accion" value="Crear">
  
  <% } else { %>
    
    <input class="button" type="submit" name="accion" value="Guardar">
    <input class="button" type="submit" name="accion" value="Eliminar" onclick="return confirm('Confirma que desea eliminar este dato?');">
  
  <% } %> 
    <a href="app?modulo=clientes&accion=listar" class="button" >Volver</a>
    
  </fieldset>
</form>