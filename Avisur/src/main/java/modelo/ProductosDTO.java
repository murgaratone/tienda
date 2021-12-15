package modelo;

import java.util.ArrayList;

public class ProductosDTO {

  private int id;
  private long codigo;
  private double iva_compra;
  private int proveedor_id;
  private String nombre;
  private double valor_compra;
  private double valor_venta;

  public ProductosDTO() {
    this.id = 0;
    this.codigo = 0L;
    this.iva_compra = 0.0;
    this.proveedor_id = 0;
    this.nombre = "";
    this.valor_compra = 0.0;
    this.valor_venta = 0.0;
  }

  public ProductosDTO( int id,  long codigo,  double iva_compra,  int proveedor_id,  String nombre,  double valor_compra,  double valor_venta ) {
    super();
    this.id = id;
    this.codigo = codigo;
    this.iva_compra = iva_compra;
    this.proveedor_id = proveedor_id;
    this.nombre = nombre;
    this.valor_compra = valor_compra;
    this.valor_venta = valor_venta;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public long getCodigo() {
    return codigo;
  }

  public void setCodigo(long codigo) {
    this.codigo = codigo;
  }

  public double getIva_compra() {
    return iva_compra;
  }

  public void setIva_compra(double iva_compra) {
    this.iva_compra = iva_compra;
  }

  public int getProveedor_id() {
    return proveedor_id;
  }

  public void setProveedor_id(int proveedor_id) {
    this.proveedor_id = proveedor_id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public double getValor_compra() {
    return valor_compra;
  }

  public void setValor_compra(double valor_compra) {
    this.valor_compra = valor_compra;
  }

  public double getValor_venta() {
    return valor_venta;
  }

  public void setValor_venta(double valor_venta) {
    this.valor_venta = valor_venta;
  }

}
