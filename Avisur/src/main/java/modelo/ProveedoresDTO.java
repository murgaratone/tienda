package modelo;

import java.util.ArrayList;

public class ProveedoresDTO {

  private int id;
  private long nit;
  private String ciudad;
  private String direccion;
  private String nombre;
  private String telefono;

  public ProveedoresDTO() {
    this.id = 0;
    this.nit = 0L;
    this.ciudad = "";
    this.direccion = "";
    this.nombre = "";
    this.telefono = "";
  }

  public ProveedoresDTO( int id,  long nit,  String ciudad,  String direccion,  String nombre,  String telefono ) {
    super();
    this.id = id;
    this.nit = nit;
    this.ciudad = ciudad;
    this.direccion = direccion;
    this.nombre = nombre;
    this.telefono = telefono;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public long getNit() {
    return nit;
  }

  public void setNit(long nit) {
    this.nit = nit;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
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