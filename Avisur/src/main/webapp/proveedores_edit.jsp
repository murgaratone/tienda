<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="modelo.*" %>
<%@ page import="java.util.*" %>


<%
  String modulo = (String)request.getAttribute("modulo");
  ProveedoresDTO data = (ProveedoresDTO)request.getAttribute("data");
%>

<h2>Editar Registro de Proveedores</h2>
<form action="app" method="post">
  <fieldset>
    <input type="hidden" name="modulo" id="modulo" value="proveedores">
    <input type="hidden" name="id" id="id" value="<%=data.getId()%>" required>
    <label for="nit">Nit</label>
    <input type="number" name="nit" id="nit" value="<%=data.getNit()%>" required>
    <label for="ciudad">Ciudad</label>
    <input type="text" name="ciudad" id="ciudad" value="<%=data.getCiudad()%>" required>
    <label for="direccion">Direccion</label>
    <input type="text" name="direccion" id="direccion" value="<%=data.getDireccion()%>" required>
    <label for="nombre">Nombre Empresa</label>
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
    <a href="app?modulo=proveedores&accion=listar" class="button" >Volver</a>
    
  </fieldset>
</form>