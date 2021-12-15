<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="modelo.*" %>

<% List<ClientesDTO> data = (List<ClientesDTO>)request.getAttribute("data"); %>

<h2>Clientes</h2>
<a class="button" href="app?modulo=clientes&accion=crear">Crear Cliente</a>
<a class="button" href="app?modulo=clientes&accion=cargar">Cargar</a>
<% if (data.size() > 0) { %>
<table>
<tr>
<th>&nbsp;</th>
<th>N' Cliente</th>
<th>Cedula</th>
<th>Direccion</th>
<th>Email</th>
<th>Nombre Completo</th>
<th>Telefono</th>
</tr>


<% for (ClientesDTO dato: data) { %>
<tr>
<td><a class="button" href="app?modulo=clientes&accion=editar&id=<%=dato.getId()%>">Editar Cliente</a></td>
<td><%=dato.getId() %></td>
<td><%=dato.getCedula() %></td>
<td><%=dato.getDireccion() %></td>
<td><%=dato.getEmail() %></td>
<td><%=dato.getNombre() %></td>
<td><%=dato.getTelefono() %></td>
</tr>
<% } %>
</table>
<% } else { %>
<p>No se ha encontrado nigún registro.</p>
<%}%>