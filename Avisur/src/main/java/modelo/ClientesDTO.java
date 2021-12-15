package modelo;

public class ClientesDTO {

  private int id;
  private long cedula;
  private String direccion;
  private String email;
  private String nombre;
  private String telefono;

  public ClientesDTO() {
    this.id = 0;
    this.cedula = 0L;
    this.direccion = "";
    this.email = "";
    this.nombre = "";
    this.telefono = "";
  }

  public ClientesDTO( int id,  long cedula,  String direccion,  String email,  String nombre,  String telefono ) {
    super();
    this.id = id;
    this.cedula = cedula;
    this.direccion = direccion;
    this.email = email;
    this.nombre = nombre;
    this.telefono = telefono;
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

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
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

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

}