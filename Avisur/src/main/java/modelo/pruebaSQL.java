package modelo;

import java.util.List;

public class pruebaSQL {

	public pruebaSQL() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VentasDAO dao = new VentasDAO();
		
		List<VentasDTO> datos = dao.seleccionar();

	}

}
