<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="modelo.*" %>
<%@ page import="java.util.*" %>


<%
/*HttpSession session=request.getSession();*/

UsuariosDTO usuarioConectado=(UsuariosDTO)session.getAttribute("usuarioConectado");
	if(usuarioConectado==null){
		response.sendRedirect("login.jsp");
	}
	
%>

<%
  String modulo = (String)request.getAttribute("modulo");
  Detalles_ventasDTO data = (Detalles_ventasDTO)request.getAttribute("data");
  
  ListaDTO listaProductos = (ListaDTO)request.getAttribute("listaProductos");
  ArrayList<ProductosDTO> listaProductosDAO = (ArrayList<ProductosDTO>)request.getAttribute("listaProductosDAO");
  
%>
<% if (usuarioConectado.getRol().equals("vendedor")||usuarioConectado.getRol().equals("Secretaria")){%>
<h2>Editar Registro del Detalle ventas</h2>
<form action="app" method="post">
  <fieldset>
    <input type="hidden" name="modulo" id="modulo" value="detalles_ventas">
    <input type="hidden" name="id" id="id" value="<%=data.getId()%>" required>
    
    
    <label for="producto_id">Producto</label>
   
   	<script>
   		function setValor_Venta(){
   			const selectProducto = document.getElementById('producto_id')
   			const producto = selectProducto[selectProducto.selectedIndex]
   			const valor_venta = producto.attributes.getNamedItem('data_valor_venta').value
   			document.getElementById('valor').value = parseFloat(valor_venta)
   		}
   	</script>
	<select name="producto_id" id="producto_id" onchange="setValor_Venta()" >
			<option disabled selected value> -- Selecciona un producto -- </option>
		<% for (ProductosDTO item : listaProductosDAO) { %>
			<option data_valor_venta="<%=item.getValor_venta()%>" value="<%=item.getId()%>" <%=(item.getId() == data.getProducto_id())?"selected":""%>>
			
				<%=item.getId()%> - <%=item.getNombre()%> :) <%=item.getValor_venta()%>
			</option>
		<% } %>
	</select>   
		
    <input type="hidden" name="venta_id" id="venta_id" value="<%=data.getVenta_id()%>" required>
    <label for="cantidad">Cantidad</label>
    <input type="number" name="cantidad" id="cantidad" value="<%=data.getCantidad()%>" required>
    <label for="valor">Valor</label>
    <input type="number" name="valor" id="valor" value="0" readonly="readonly">
    <input type="hidden" name="valor_total" id="valor_total" value="<%=data.getValor_total()%>" required>
  </fieldset>
  <fieldset>
  
  <% if (data.getId() == 0 ) { %>
  
    <input type="submit" name="accion" value="crear">
  
  <% } else { %>
    <input type="submit" name="accion" value="eliminar">
    <input type="submit" name="accion" value="Guardar">
    
  
  <% } %> 
    <input type="submit" name="accion" value="Volver">
    
  </fieldset>
</form>
<% } %>

<% if (usuarioConectado.getRol().equals("administrador")||usuarioConectado.getRol().equals("Secretaria")){%>
<h2>Elimiar dato</h2>
<form action="app" method="post">
  <fieldset>
    <input type="hidden" name="modulo" id="modulo" value="detalles_ventas">
    <input type="hidden" name="id" id="id" value="<%=data.getId()%>" required>
    
    
    <label for="producto_id">Producto</label>
   
   	<script>
   		function setValor_Venta(){
   			const selectProducto = document.getElementById('producto_id')
   			const producto = selectProducto[selectProducto.selectedIndex]
   			const valor_venta = producto.attributes.getNamedItem('data_valor_venta').value
   			document.getElementById('valor').value = parseFloat(valor_venta)
   		}
   	</script>
	<select name="producto_id" id="producto_id" onchange="setValor_Venta()" >
			<option disabled selected value> -- Selecciona un producto -- </option>
		<% for (ProductosDTO item : listaProductosDAO) { %>
			<option data_valor_venta="<%=item.getValor_venta()%>" value="<%=item.getId()%>" <%=(item.getId() == data.getProducto_id())?"selected":""%>>
			
				<%=item.getId()%> - <%=item.getNombre()%> :) <%=item.getValor_venta()%>
			</option>
		<% } %>
	</select>   
		
    <input type="hidden" name="venta_id" id="venta_id" value="<%=data.getVenta_id()%>" required>
    <label for="cantidad">Cantidad</label>
    <input type="number" name="cantidad" id="cantidad" value="<%=data.getCantidad()%>" required>
    <label for="valor">Valor</label>
    <input type="number" name="valor" id="valor" value="0" readonly="readonly">
    <input type="hidden" name="valor_total" id="valor_total" value="<%=data.getValor_total()%>" required>
  </fieldset>
  <fieldset>
  
  <% if (data.getId() == 0 ) { %>
  
    
  
  <% } else { %>
    
    <input type="submit" name="accion" value="Guardar">
    <input type="submit" name="accion" value="Eliminar">
  
  <% } %> 
    <input type="submit" name="accion" value="Volver">
    
  </fieldset>
</form>
<% } %>
