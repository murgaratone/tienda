<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="modelo.*" %>
<%@ page import="java.util.*" %>


<%
  String modulo = (String)request.getAttribute("modulo");
  ReportesDTO data = (ReportesDTO)request.getAttribute("data");
%>

<h2>Editar Registro de Reportes</h2>
<form action="app" method="post" class="pure-form pure-form-stacked vertical-margin">
  <fieldset>
    <input type="hidden" name="modulo" id="modulo" value="reportes">
    <input type="hidden" name="id" id="id" value="<%=data.getId()%>" required>
    <label for="nombre">Nombre</label>
    <input type="text" name="nombre" id="nombre" value="<%=data.getNombre()%>" required>
    <label for="definicion">Definicion</label>
    <textarea type="text" name="definicion" id="definicion"><%=data.getDefinicion()%></textarea>
  </fieldset>
  <fieldset>
  
  <% if (data.getId() == 0 ) { %>
  
    <input class="pure-button pure-button-primary" type="submit" name="accion" value="Crear">
  
  <% } else { %>
    
    <input class="pure-button pure-button-primary" type="submit" name="accion" value="Guardar">
    <input class="pure-button" type="submit" name="accion" value="Eliminar">
  
  <% } %> 
    <input class="pure-button" type="submit" name="accion" value="Volver">
    
  </fieldset>
</form>