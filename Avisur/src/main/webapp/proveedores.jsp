<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="modelo.*" %>

<% List<ProveedoresDTO> data = (List<ProveedoresDTO>)request.getAttribute("data"); %>

<h2>Proveedores</h2>
<a class="button" href="app?modulo=proveedores&accion=crear">Crear Proveedor</a>
<% if (data.size() > 0) { %>
<table>
<tr>
<th>&nbsp;</th>
<th>Id Prov</th>
<th>Nit</th>
<th>Ciudad</th>
<th>Direccion</th>
<th>Empresa</th>
<th>Telefono</th>
</tr>

<% for (ProveedoresDTO dato: data) { %>
<tr>
<td><a class="button" href="app?modulo=proveedores&accion=editar&id=<%=dato.getId()%>">Editar</a></td>
<td><%=dato.getId() %></td>
<td><%=dato.getNit() %></td>
<td><%=dato.getCiudad() %></td>
<td><%=dato.getDireccion() %></td>
<td><%=dato.getNombre() %></td>
<td><%=dato.getTelefono() %></td>
</tr>
<% } %>
</table>
<% } else { %>
<p>No se ha encontrado nigún registro.</p>
<%}%>