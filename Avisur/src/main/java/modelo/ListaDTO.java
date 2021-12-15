package modelo;

import java.util.ArrayList;

public class ListaDTO {

	private String nombre;
	ArrayList<ItemListaDTO> items;
	
	public ListaDTO() {
		
	}

	public ListaDTO(String nombre, ArrayList<ItemListaDTO> items) {
		super();
		this.nombre = nombre;
		this.items = items;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<ItemListaDTO> getItems() {
		return items;
	}

	public void setItems(ArrayList<ItemListaDTO> items) {
		this.items = items;
	}
	
	
}
