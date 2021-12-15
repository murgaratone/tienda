<%@page import="javax.swing.JOptionPane"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="modelo.*" %>
<%@ page import="java.util.*" %>


<%
  String moduloVnt = (String)request.getAttribute("moduloVnt");
  Detalles_ventasDTO datoVnt = (Detalles_ventasDTO)request.getAttribute("datoVnt");
  
  ListaDTO listaProductos = (ListaDTO)request.getAttribute("listaProductos");
  ArrayList<ProductosDTO> listaProductosDAO = (ArrayList<ProductosDTO>)request.getAttribute("listaProductosDAO");
  
%>

<%
/*HttpSession session=request.getSession();*/

UsuariosDTO usuarioConectado=(UsuariosDTO)session.getAttribute("usuarioConectado");
	if(usuarioConectado==null){
		response.sendRedirect("login.jsp");
	}
	
%>
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
    <% if (usuarioConectado.getRol().equals("administrador")){%>
    	<input class="button" type="submit" name="accion" value="Eliminar" onclick="return confirm('Confirma que desea eliminar este dato?');">
  	<% }%>
  <% } %> 
    <input type="submit" name="accion" value="Volver">
    
  </fieldset>
  <fieldset>
    <input type="hidden" name="modulo" id="modulo" value="ventas">
    <input type="hidden" name="id" id="id" value="<%=data.getId()%>" >
    <% if (usuarioConectado.getRol().equals("administrador")||usuarioConectado.getRol().equals("Secretaria")){%>
    <label for="codigo">conductor</label>
    <input type="text" name="codigo" id="codigo" value="<%=data.getCodigo()%>" >
    <label for="codigo">Placa</label>
    <input type="text" name="codigo" id="codigo" value=" " >
   <%} %>
   
    

    <label for="cliente_id">Cliente</label>
    
	<select   name="cliente_id" id="cliente_id" >
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
<% if (usuarioConectado.getRol().equals("administrador")){%>
<td><a class="button" href="app?modulo=detalles_ventas&accion=editar&id=<%=dato.getId()%>">eliminar</a></td>
<% } %>
<% if (usuarioConectado.getRol().equals("vendedor")||usuarioConectado.getRol().equals("Secretaria")){%>
<td><a class="button" href="app?modulo=detalles_ventas&accion=editar&id=<%=dato.getId()%>">Editar</a></td>
<% } %>
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


<div class="invisib" id="queda" style="display: none; "><!--  style="display: none; "-->
	<div style="font-size: small; color: black; padding: 20px; padding-bottom: 60px "id="factura-para-imprimir" >
		<h2>Super Tienda Online</h2>
		<form action="app" method="post">
		  
		  <fieldset>
		    
		    <label for="codigo">placa</label>
		    <label for="codigo">conductor</label>
		    <input class="conductor" type="text" name="codigo" id="codigo2" value="<%=data.getCodigo()%>" required>
		   
		   
		    
		
		    <label for="cliente_id">Cedula y Cliente</label>
		    
			<div>
				<% for (ItemListaDTO item : listaClientes.getItems()) { %>
				<%if (item.getId() == data.getCliente_id()) {%>
						<%=item.getDescripcion()%>
				<% } %>
				<% } %>
			</div>     
		    
		    <label for="usuario_id">Vendedor</label>
			<div>
				<% for (ItemListaDTO item : listaUsuarios.getItems()) { %>
				<% if (item.getId() == data.getUsuario_id()) {%>
						<%=item.getDescripcion()%>
				<% } %>
				<% } %>
			</div>    
		  </fieldset>
		  
		</form>
		
		<% if (data.getId() != 0 ) { %>
		
		
		<script>
		    	function imprimirPagina(el) {
					var restorepage = document.body.innerHTML;
					var printcontent = document.getElementById(el).innerHTML;
					document.body.innerHTML = printcontent;
					window.print();
					document.body.innerHTML = restorepage;
				}
		    </script>
		    
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
		<td><a class="button" style="display: none; href="app?modulo=detalles_ventas&accion=editar&id=<%=dato.getId()%>">Editar</a></td>
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
		
		<%}%>
		
		<%}%>
	</div>
</div>