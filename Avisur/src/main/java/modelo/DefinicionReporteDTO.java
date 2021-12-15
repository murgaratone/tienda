package modelo;

import java.util.ArrayList;

public class DefinicionReporteDTO {
	
	private ArrayList<String> columnas;
	
	private ArrayList<ArrayList<String>> tabla;
	
	public DefinicionReporteDTO() {
		columnas = new ArrayList<String>();
		tabla = new ArrayList<ArrayList<String>>();
	}

	public ArrayList<String> getColumnas() {
		return columnas;
	}

	public void setColumnas(ArrayList<String> columnas) {
		this.columnas = columnas;
	}

	public ArrayList<ArrayList<String>> getTabla() {
		return tabla;
	}

	public void setTabla(ArrayList<ArrayList<String>> tabla) {
		this.tabla = tabla;
	}
	
 
	public void addColumna(String columna) {
		columnas.add(columna);
	}
	
	public void addRegistro(ArrayList<String> registro) {
		tabla.add(registro);
	}
	
}
