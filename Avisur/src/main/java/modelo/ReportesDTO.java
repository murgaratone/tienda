package modelo;

import java.util.ArrayList;

public class ReportesDTO {

  private int id;
  private String nombre;
  private String definicion;

  public ReportesDTO() {
    this.id = 0;
    this.nombre = "";
    this.definicion = "";
  }

  public ReportesDTO( int id,  String nombre,  String definicion ) {
    super();
    this.id = id;
    this.nombre = nombre;
    this.definicion = definicion;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDefinicion() {
    return definicion;
  }

  public void setDefinicion(String definicion) {
    this.definicion = definicion;
  }

}
