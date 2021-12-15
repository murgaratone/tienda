<%@page import="javax.swing.JOptionPane"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="modelo.*" %>
<%@ page import="java.util.*" %>


<%
  String modulo = (String)request.getAttribute("modulo");
  VentasDTO data = (VentasDTO)request.getAttribute("data");
  List<Detalles_ventasDTO> dataDetalle = (List<Detalles_ventasDTO>)request.getAttribute("data_detalle");
  
  ListaDTO listaUsuarios = (ListaDTO)request.getAttribute("listaUsuarios");
  ListaDTO listaClientes = (ListaDTO)request.getAttribute("listaClientes");

	ListaDAO listaDAO = new ListaDAO();
	ItemListaDTO itemProducto;
	/*JOptionPane.showMessageDialog(null, data);*/
%>

<h2>Editar Venta</h2>


<div id="factura" style="background:rgb(59, 66, 82);">
<form action="app" method="post">
<fieldset>
  
  <% if (data.getId() == 0 ) { %>
  
    <input type="submit" name="accion" value="crear">
  
  <% } else { %>
    
    <input type="submit" name="accion" value="Guardar">
    <input type="submit" name="accion" value="Eliminar">
  
  <% } %> 
    <input type="submit" name="accion" value="Volver">
    
  </fieldset>
  <fieldset>
    <input type="hidden" name="modulo" id="modulo" value="ventas">
    <input type="hidden" name="id" id="id" value="<%=data.getId()%>" >
    <label for="codigo">conductor</label>
    <input type="text" name="codigo" id="codigo" value="<%=data.getCodigo()%>" >
    <label for="codigo">Placa</label>
    <input type="text" name="codigo" id="codigo" value=" " >
   
   
    

    <label for="cliente_id">Cliente</label>
    
	<select name="cliente_id" id="cliente_id" >
		<% for (ItemListaDTO item : listaClientes.getItems()) { %>
			<option value="<%=item.getId()%>" <%=(item.getId() == data.getCliente_id())?"selected":""%>>
				<%=item.getDescripcion()%>
			</option>
		<% } %>
	</select>     
    
    <label for="usuario_id">Vendedor</label>
	<select name="usuario_id" id="usuario_id" >
		<% for (ItemListaDTO item : listaUsuarios.getItems()) { %>
			<option value="<%=item.getId()%>" <%=(item.getId() == data.getUsuario_id())?"selected":""%>>
				<%=item.getDescripcion()%>
			</option>
		<% } %>
	</select>    
    
    <input type="hidden" name="subtotal" id="subtotal" value="<%=data.getSubtotal()%>" required>
    <input type="hidden" name="iva" id="iva" value="<%=data.getIva()%>" required>
    <input type="hidden" name="total" id="total" value="<%=data.getTotal()%>" required>
  </fieldset>
  
</form>

<% if (data.getId() != 0 ) { %>

<a class="button"  href="app?modulo=detalles_ventas&accion=crear&venta_id=<%=data.getId()%>">Agregar Nuevo Producto</a>
<a class="button" href="javascript:imprimir_factura()">Descagar Factura</a>
<script>
    	function imprimirPagina(el) {
			var restorepage = document.body.innerHTML;
			var printcontent = document.getElementById(el).innerHTML;
			document.body.innerHTML = printcontent;
			window.print();
			document.body.innerHTML = restorepage;
		}
    </script>
    <button onclick="imprimirPagina('factura-para-imprimir');">Imprimir</button>
<% if (dataDetalle.size() > 0) { %>
<table class="los-th">
<tr>
<th>&nbsp;</th>
<th>Id</th>
<th>Producto</th>
<th align="right">Cantidad</th>
<th align="right">Valor</th>
<th align="right">Valor Total</th>
</tr>

<% for (Detalles_ventasDTO dato: dataDetalle) { %>
<tr>
<td><a class="button" href="app?modulo=detalles_ventas&accion=editar&id=<%=dato.getId()%>">Editar</a></td>
<td><%=dato.getId() %></td>

<% itemProducto = listaDAO.seleccionar("PRODUCTOS",dato.getProducto_id()); %>

<td><%=itemProducto.getDescripcion() %></td>

<td align="right"><%=dato.getCantidad() %></td>
<!-- <td align="right"><%=dato.getValor() %></td>-->
<!-- <td align="right"><%=dato.getValor_total() %></td>-->
</tr>
<% } %>
<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<th>Subtotal</th>
<!-- <td align="right"><%=data.getSubtotal()%></td> -->
</tr>

<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<th>IVA</th>
<!-- <td align="right"><%=data.getIva()%></td> -->
</tr>

<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<th>Total</th>
<!-- <td align="right"><%=data.getTotal()%></td> -->
</tr>

</table>
<% } else { %>
<p>No se ha encontrado nigún registro.</p>
<%}%>

<%}%>
</div>


<div style="display: none;">
<div id="factura-para-imprimir" style="color:#000000 ;padding: 20px; padding-bottom: 60px">
<h2>Super Tienda Online</h2>
<form action="app" method="post">
  <fieldset>
    <label for="codigo">Nùmero de Factura</label>
    <label for="codigo">conductor</label>
    <input class="conductor" type="text" name="codigo" id="codigo" value="<%=data.getCodigo()%>" required>

    <label for="cliente_id2">Cliente</label>
   
	<div>
		<% for (ItemListaDTO item : listaClientes.getItems()) { %>
		<% if (item.getId() == data.getCliente_id()) { %>
				<%=item.getDescripcion()%>
		<% } %>
		<% } %>
	</div>     
    
    <label for="usuario_id2">Nombre Vendedor</label>
	<div>
		<% for (ItemListaDTO item : listaUsuarios.getItems()) { %>
		<% if (item.getId() == data.getUsuario_id()) { %>
				<%=item.getDescripcion()%>

		<% } %>
		<% } %>
	</div>    
  </fieldset>
</form>

<% if (data.getId() != 0 ) { %>



<% if (dataDetalle.size() > 0) { %>
<table>
<tr>
<th>&nbsp;</th>
<th>Id</th>
<th>Producto</th>
<th align="right">Cantidad</th>
<th align="right">Valor</th>
<th align="right">Valor Total</th>
</tr>

<% for (Detalles_ventasDTO dato: dataDetalle) { %>
<tr>
<td>&nbsp;</td>
<td><%=dato.getId() %></td>

<% itemProducto = listaDAO.seleccionar("PRODUCTOS",dato.getProducto_id()); %>

<td><%=itemProducto.getDescripcion() %></td>

<td align="right"><%=dato.getCantidad() %></td>
<!-- <td align="right"><%=dato.getValor() %></td>-->
<!--<td align="right"><%=dato.getValor_total() %></td>
</tr>
<% } %>
<!--<tr>-->
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<!-- <th>Subtotal</th>-->
<!-- <td align="right"><%=data.getSubtotal()%></td>-->
</tr>

<!--<tr>-->
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<!-- <th>IVA</th>-->
<!-- <td align="right"><%=data.getIva()%></td>-->
</tr>

<!--<tr>-->
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<!-- <th>Total</th>-->
<!-- <td align="right"><%=data.getTotal()%></td>-->
</tr>

</table>
<% } else { %>
<p>No se ha encontrado nigún registro.</p>
<%}%>

<%}%>
</div>
</div>