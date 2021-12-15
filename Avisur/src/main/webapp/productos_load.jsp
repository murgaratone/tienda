<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2>cargar Productos</h2>
<form  class="pure-form pure-form-stacked" action="app" method="post"  enctype="multipart/form-data">
	<fieldset>
		<input type="hidden" name="modulo" id="modulo" value="productos">
		<label for="archivo">Archivo</label>
		<input type="file" name="archivo" id="archivo"  accept=".csv,text/csv" required>
	</fieldset>
	<fieldset>
		<input class="button"  type="submit" name="accion" value="Cargar">
		<input class="button" type="submit" name="accion" value="Volver">
	</fieldset>
</form>