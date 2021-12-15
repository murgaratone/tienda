package modelo;

import java.util.ArrayList;

public class Detalles_ventasDTO {

  private int id;
  private int producto_id;
  private int venta_id;
  private double cantidad;
  private double valor;
  private double valor_total;

  public Detalles_ventasDTO() {
    this.id = 0;
    this.producto_id = 0;
    this.venta_id = 0;
    this.cantidad = 0.0;
    this.valor = 0.0;
    this.valor_total = 0.0;
  }

  public Detalles_ventasDTO( int id,  int producto_id,  int venta_id,  double cantidad,  double valor,  double valor_total ) {
    super();
    this.id = id;
    this.producto_id = producto_id;
    this.venta_id = venta_id;
    this.cantidad = cantidad;
    this.valor = valor;
    this.valor_total = valor_total;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getProducto_id() {
    return producto_id;
  }

  public void setProducto_id(int producto_id) {
    this.producto_id = producto_id;
  }

  public int getVenta_id() {
    return venta_id;
  }

  public void setVenta_id(int venta_id) {
    this.venta_id = venta_id;
  }

  public double getCantidad() {
    return cantidad;
  }

  public void setCantidad(double cantidad) {
    this.cantidad = cantidad;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public double getValor_total() {
    return valor_total;
  }

  public void setValor_total(double valor_total) {
    this.valor_total = valor_total;
  }

}
