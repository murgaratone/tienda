<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="modelo.*" %>
<%@ page import="java.util.*" %>    
    
 <%
 	
 		
 	int reporteId = 0;
 	
 	if (request.getAttribute("reporteId") != null) {
 		reporteId = (int)request.getAttribute("reporteId");
 	}
 
    ListaDTO listaReportes = (ListaDTO)request.getAttribute("listaReportes");
 	DefinicionReporteDTO reporte = (DefinicionReporteDTO)request.getAttribute("reporte"); 
 
 %>

<form class="pure-form pure-form-stacked" action="app" method="get">
  <fieldset>
    <input type="hidden" name="modulo" id="modulo" value="reportes">
		<label for="reporteId">Seleccione Reporte</label>
		<select name="reporteId" id="reporteId">
			<option value="0">Seleccionar ...</option>
			<% for (ItemListaDTO item : listaReportes.getItems()) { %>
				<option value="<%=item.getId()%>" <%=(reporteId == item.getId())?"selected":""%>><%=item.getDescripcion()%></option>
			<% } %>
		</select>

  </fieldset>
  <fieldset>
    <input class="button button-primary" type="submit" name="accion" value="Ejecutar">
    <a href="app?modulo=reportes&accion=listar" class="button">Administrar</a>
  </fieldset>  
 </form>
 
 <% if (reporte != null) { %>
	<table class="pure-table pure-table-bordered vertical-margin">
	<thead>
		<tr>
		
		<% for (String columna: reporte.getColumnas()) { %>
			<th><%=columna%></th>
		<% } %>
		</tr>
	</thead>
	
	<tbody>	
	
		<% for (List<String> registro: reporte.getTabla()) { %>
			<tr>
			<% for (String campo:registro) { %>
				<td><%=campo %></td>
			<% } %>
			</tr>
		<% } %>
	</tbody>
	</table>
<% } else { %>
	<p>No se ha encontrado nigún registro.</p>

	<%}%>