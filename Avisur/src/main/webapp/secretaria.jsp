<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="modelo.*" %>

<% 
	List<VentasDTO> data = (List<VentasDTO>)request.getAttribute("data");

	ListaDAO listaDAO = new ListaDAO();
	ItemListaDTO itemCliente;
	ItemListaDTO itemUsuario;

%>

<h2>Edicion Ventas</h2>
<a class="button" href="app?modulo=ventas&accion=crear">Crear Nueva Venta</a>
<% if (data.size() > 0) { %>
<table>
<tr>
<th>&nbsp;</th>
<th>Id</th>
<th>C&oacute;digo</th>
<th>Cliente</th>
<th>Vendedor</th>
<th>Subtotal</th>
<th>Iva</th>
<th>Total</th>
</tr>

<% for (VentasDTO dato: data) { %>
<tr>
<td><a class="button" href="app?modulo=ventas&accion=editar&id=<%=dato.getId()%>">Editar</a></td>
<td><%=dato.getId() %></td>
<td><%=dato.getCodigo() %></td>

<% itemCliente = listaDAO.seleccionar("CLIENTES",dato.getCliente_id()); %>	
<td><%=itemCliente.getDescripcion() %></td>


<% itemUsuario = listaDAO.seleccionar("USUARIOS",dato.getUsuario_id()); %>	
<td><%=itemUsuario.getDescripcion() %></td>

<td><%=dato.getSubtotal() %></td>
<td><%=dato.getIva() %></td>
<td><%=dato.getTotal() %></td>
</tr>
<% } %>
</table>
<% } else { %>
<p>No se ha encontrado nigún registro.</p>
<%}%>
