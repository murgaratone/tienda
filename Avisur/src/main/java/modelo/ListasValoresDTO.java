package modelo;

public class ListasValoresDTO {
	
	
	private int id;
	private String nombre;
	private String SQL;
	
	public ListasValoresDTO() {
		// TODO Auto-generated constructor stub
	}	

	public ListasValoresDTO(int id, String nombre,String SQL) {
		super();
		this.id = id;		
		this.nombre = nombre;
		this.SQL = SQL;		
	}	
		
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getSQL() {
		return this.SQL;
	}
	
	public void setSQL(String SQL) {
		this.SQL = SQL;
	}
	
}