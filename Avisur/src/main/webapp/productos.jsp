<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="modelo.*" %>

<% 
  	List<ProductosDTO> data = (List<ProductosDTO>)request.getAttribute("data");

	ListaDAO listaDAO = new ListaDAO();
	ItemListaDTO itemProveedor; 


%>

<h2>Productos</h2>
<a class="button" href="app?modulo=productos&accion=crear">Crear</a>
<a class="button" href="app?modulo=productos&accion=cargar">Cargar</a>
<% if (data.size() > 0) { %>
<table>
<tr>
<th>&nbsp;</th>
<th>Id</th>
<th>Codigo</th>
<th>IVA Compra</th>
<th>Proveedor</th>
<th>Nombre</th>
<th>Valor de compra</th>
<th>Valor de venta</th>
</tr>

<% for (ProductosDTO dato: data) { %>
<tr>
	<td><a class="button"  href="app?modulo=productos&accion=editar&id=<%=dato.getId()%>">Editar</a></td>
	<td><%=dato.getId() %></td>
	<td><%=dato.getCodigo() %></td>
	<td align="right"><%=dato.getIva_compra() %></td>
	<% itemProveedor = listaDAO.seleccionar("PROVEEDORES",dato.getProveedor_id()); %>	
	<td><%=itemProveedor.getDescripcion() %></td>
	<td><%=dato.getNombre() %></td>
	<td align="right"><%=dato.getValor_compra() %></td>
	<td align="right"><%=dato.getValor_venta() %></td>
</tr>
<% } %>
</table>
<% } else { %>
<p>No se ha encontrado nigún registro.</p>
<%}%>