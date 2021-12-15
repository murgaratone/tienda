<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="modelo.*" %>
<%@ page import="java.util.*" %>


<%
  String modulo = (String)request.getAttribute("modulo");
  ProductosDTO data = (ProductosDTO)request.getAttribute("data");
  
  ListaDTO listaProveedor = (ListaDTO)request.getAttribute("listaProveedor");
  
%>

<h2>Editar Registro de Productos</h2>
<form action="app" method="post">
  <fieldset>
    <input type="hidden" name="modulo" id="modulo" value="productos">
    <input type="hidden" name="id" id="id" value="<%=data.getId()%>" required>
    <label for="codigo">Codigo</label>
    <input type="number" name="codigo" id="codigo" value="<%=data.getCodigo()%>" required>
    <label for="iva_compra">Iva_compra</label>
    <input type="number" name="iva_compra" id="iva_compra" value="<%=data.getIva_compra()%>" required>
    
    <label for="proveedor_id">Proveedor</label>

		<select name="proveedor_id" id="proveedor_id" >
			<% for (ItemListaDTO item : listaProveedor.getItems()) { %>
				<option value="<%=item.getId()%>" <%= (item.getId() == data.getProveedor_id())?"selected":"" %>>
					<%=item.getDescripcion()%>
				</option>
			<% } %>
		</select>    
    
    <label for="nombre">Nombre</label>
    <input type="text" name="nombre" id="nombre" value="<%=data.getNombre()%>" required>
    <label for="valor_compra">Valor de compra</label>
    <input type="number" name="valor_compra" id="valor_compra" value="<%=data.getValor_compra()%>" required>
    <label for="valor_venta">Valor de venta</label>
    <input type="number" name="valor_venta" id="valor_venta" value="<%=data.getValor_venta()%>" required>
  </fieldset>
  <fieldset>
  
  <% if (data.getId() == 0 ) { %>
  
    <input class="button" type="submit" name="accion" value="Crear">
  
  <% } else { %>
    
    <input class="button" type="submit" name="accion" value="Guardar">
    <input class="button" type="submit" name="accion" value="Eliminar" onclick="return confirm('Confirma que desea eliminar este dato?');">
  
  <% } %> 
    <a href="app?modulo=productos&accion=listar" class="button" >Volver</a>
    
  </fieldset>
</form>