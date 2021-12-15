<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="modelo.*" %>

<% List<ReportesDTO> data = (List<ReportesDTO>)request.getAttribute("data"); %>

<h2>Reportes</h2>
<a class="button button-primary" href="app?modulo=reportes&accion=crear">Crear</a>
<% if (data.size() > 0) { %>
<table>
<thead>
<tr>
<th>&nbsp;</th>
<th>Id</th>
<th>Nombre</th>
<th>Definicion</th>
</tr>
</thead>
<tbody>
<% for (ReportesDTO dato: data) { %>
<tr>
<td><a class="button button-primary" href="app?modulo=reportes&accion=editar&id=<%=dato.getId()%>">Editar</a></td>
<td><%=dato.getId() %></td>
<td><%=dato.getNombre() %></td>
<td><%=dato.getDefinicion() %></td>
</tr>
<% } %>
</tbody>
</table>
<% } else { %>
<p>No se ha encontrado nigún registro.</p>
<%}%>