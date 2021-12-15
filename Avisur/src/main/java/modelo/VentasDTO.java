package modelo;

import java.util.ArrayList;

public class VentasDTO {

  private int id;
  private String codigo;
  private int cliente_id;
  private int usuario_id;
  private double subtotal;
  private double iva;
  private double total;

  public VentasDTO() {
    this.id = 0;
    this.codigo = "";
    this.cliente_id = 0;
    this.usuario_id = 0;
    this.subtotal = 0.0;
    this.iva = 0.0;
    this.total = 0.0;
  }

  public VentasDTO( int id,  String codigo,  int cliente_id,  int usuario_id,  double subtotal,  double iva,  double total ) {
    super();
    this.id = id;
    this.codigo = codigo;
    this.cliente_id = cliente_id;
    this.usuario_id = usuario_id;
    this.subtotal = subtotal;
    this.iva = iva;
    this.total = total;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public int getCliente_id() {
    return cliente_id;
  }

  public void setCliente_id(int cliente_id) {
    this.cliente_id = cliente_id;
  }

  public int getUsuario_id() {
    return usuario_id;
  }

  public void setUsuario_id(int usuario_id) {
    this.usuario_id = usuario_id;
  }

  public double getSubtotal() {
    return subtotal;
  }

  public void setSubtotal(double subtotal) {
    this.subtotal = subtotal;
  }

  public double getIva() {
    return iva;
  }

  public void setIva(double iva) {
    this.iva = iva;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

}
