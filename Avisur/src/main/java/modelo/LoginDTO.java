package modelo;

public class LoginDTO {
	
	private long cedula;
	private String email;
	private String usuario;
	private String password;
	private String rol;
	
	
	
	
	
	
	public LoginDTO(long cedula, String email, String usuario, String password, String rol) {
		super();
		this.cedula = cedula;
		this.email = email;
		this.usuario = usuario;
		this.password = password;
		this.rol= rol;
	}
	
	
	
	
	
	public LoginDTO(String usuario, String password, String rol) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.rol= rol;
	}
	
	public LoginDTO(String usuario, String password) {
		super();
		this.usuario = usuario;
		this.password = password;
	}

	public long getCedula() {
		return cedula;
	}
	public void setCedula(long cedula) {
		this.cedula = cedula;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getusuario() {
		return usuario;
	}
	public void setNombre(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setClave(String password) {
		this.password = password;
	}
	public String getrol() {
		return rol;
	}
	public void setUsuario(String rol) {
		this.rol = rol;
	}
	
    
    
}
