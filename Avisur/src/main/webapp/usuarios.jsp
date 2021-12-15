<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="modelo.*" %>

<% List<UsuariosDTO> data = (List<UsuariosDTO>)request.getAttribute("data"); %>

<h2>Usuarios</h2>
<a class="button"  href="app?modulo=usuarios&accion=crear">Crear Cargo De Empleado</a>
<% if (data.size() > 0) { %>
<table>
<tr>
<th>&nbsp;</th>
<th>N' Usuario</th>
<th>Cedula</th>
<th>Email</th>
<th>Nombre</th>
<th>Usuario</th>
<th>Password</th>
<th>Rol</th>
</tr>

<% for (UsuariosDTO dato: data) { %>
<tr>
<td><a class="button"  href="app?modulo=usuarios&accion=editar&id=<%=dato.getId()%>">Editar</a></td>
<td><%=dato.getId() %></td>
<td><%=dato.getCedula() %></td>
<td><%=dato.getEmail() %></td>
<td><%=dato.getNombre() %></td>
<td><%=dato.getUsuario() %></td>
<td><%=dato.getPassword() %></td>
<td><%=dato.getRol() %></td>
</tr>
<% } %>
</table>
<% } else { %>
<p>No se ha encontrado nigún registro.</p>
<%}%>