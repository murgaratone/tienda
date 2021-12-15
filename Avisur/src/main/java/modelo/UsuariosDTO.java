package modelo;

import java.util.ArrayList;

public class UsuariosDTO {

  private int id;
  private long cedula;
  private String email;
  private String nombre;
  private String usuario;
  private String password;
  private String rol;
  @Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.usuario + "-:" + this.rol;
		
	}

  public UsuariosDTO() {
    this.id = 0;
    this.cedula = 0L;
    this.email = "";
    this.nombre = "";
    this.usuario = "";
    this.password = "";
    this.rol = "";
  }

  public UsuariosDTO( int id,  long cedula,  String email,  String nombre,  String usuario,  String password,  String rol ) {
    super();
    this.id = id;
    this.cedula = cedula;
    this.email = email;
    this.nombre = nombre;
    this.usuario = usuario;
    this.password = password;
    this.rol = rol;
  }

  public UsuariosDTO(String nombre, String password, String rol) {
	super();
	this.nombre = nombre;
	this.password = password;
	this.rol = rol;
}

public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRol() {
    return rol;
  }

  public void setRol(String rol) {
    this.rol = rol;
  }

}