package modelo;

import java.sql.*;
import java.util.ArrayList;

public class VentasDAO {

    private Connection conexion;
    private PreparedStatement comando;

    public VentasDAO() {
      try {
        conexion = Conexion.getConexion();
      }
      catch (Exception e) {
        System.out.println("Error de SQL: " + e);
      }
    }


    public ArrayList <VentasDTO> seleccionar () {
      ArrayList <VentasDTO> datos = new ArrayList <VentasDTO>();

      String SQL =
              "SELECT " +
              "  id, " +
              "  codigo, " +
              "  cliente_id, " +
              "  usuario_id, " +
              "  subtotal, " +
              "  iva, " +
              "  total  " +
              "FROM ventas ORDER BY id";

      try {

        System.out.println("Select: " + SQL);
          
        comando = conexion.prepareStatement(SQL);
        ResultSet rs = comando.executeQuery();

        while(rs.next()) {
            datos.add(new VentasDTO(
                    rs.getInt("id"),
                    rs.getString("codigo"),
                    rs.getInt("cliente_id"),
                    rs.getInt("usuario_id"),
                    rs.getDouble("subtotal"),
                    rs.getDouble("iva"),
                    rs.getDouble("total") 
            ));
          }

      } catch (SQLException e) {
        System.out.println("Error de SQL al seleccionar: " + e);
      }

      return datos;
    }

    public VentasDTO seleccionar  (int id) {


      VentasDTO dato = null;

      String SQL =
              "SELECT " +
              "  id, " +
              "  codigo, " +
              "  cliente_id, " +
              "  usuario_id, " +
              "  subtotal, " +
              "  iva, " +
              "  total  " +
              "FROM ventas " +
              "WHERE id = ?";

      try {
        comando = conexion.prepareStatement(SQL);
        comando.setInt(1,id);
        ResultSet rs = comando.executeQuery();

        if (rs.next()) {
          dato = new VentasDTO(
                  rs.getInt("id"),
                  rs.getString("codigo"),
                  rs.getInt("cliente_id"),
                  rs.getInt("usuario_id"),
                  rs.getDouble("subtotal"),
                  rs.getDouble("iva"),
                  rs.getDouble("total") 
          );
        }

      } catch (SQLException e) {
        System.out.println("Error de SQL al seleccionar: " + e);
      }

      return dato;
    }

    public void insertar (VentasDTO dato) {

      String sqlInsertar =
              "INSERT INTO ventas (" +
                    "  codigo, " +
                    "  cliente_id, " +
                    "  usuario_id, " +
                    "  subtotal, " +
                    "  iva, " +
                    "  total  " +
                      " ) " + 
                      "VALUES (?,?,?,?,?,? )";

      try {
        comando = conexion.prepareStatement(sqlInsertar,Statement.RETURN_GENERATED_KEYS);
        comando.setString(1,dato.getCodigo());
        comando.setInt(2,dato.getCliente_id());
        comando.setInt(3,dato.getUsuario_id());
        comando.setDouble(4,dato.getSubtotal());
        comando.setDouble(5,dato.getIva());
        comando.setDouble(6,dato.getTotal());

        comando.execute();
       
        ResultSet rs = comando.getGeneratedKeys();

        if (rs.next()) {
          dato.setId(rs.getInt(1));
        }


      } catch (SQLException e) {
        System.out.println("Error de SQL al Insertar: " + e);
      }

    }

    public void actualizar (VentasDTO dato) {

      String SQL =
              "UPDATE ventas SET " +
                    "  codigo= ?, " +
                    "  cliente_id= ?, " +
                    "  usuario_id= ? " +
                    "WHERE id = ?";

      try {

        comando = conexion.prepareStatement(SQL);

        comando.setString(1,dato.getCodigo());
        comando.setInt(2,dato.getCliente_id());
        comando.setInt(3,dato.getUsuario_id());

        comando.setInt(7,dato.getId());

        comando.execute();

      } catch (SQLException e) {
        System.out.println("Error de SQL al Actualizar: " + e);
      }
    }
    

    public void actualizarTotal (int id) {

        String SQL =
                "UPDATE ventas v, "
                + "( "
                + "  SELECT venta_id, sum(valor_total) valor_total from detalles_ventas group by venta_id "
                + ") dv "
                + " SET "
                + "v.subtotal = dv.valor_total, "
                + "v.iva = dv.valor_total * 0.19, "
                + "total = dv.valor_total + (dv.valor_total * 0.19) "
                + " WHERE v.id = dv.venta_id "
                + " AND v.id = ?";

        try {

          
          System.out.println(SQL);
          
          comando = conexion.prepareStatement(SQL);
          comando.setLong(1,id);

          comando.execute();

        } catch (SQLException e) {
          System.out.println("Error de SQL al Actualizar: " + e);
        }
      }    

    public void eliminar (int id) {

      String SQL = "DELETE FROM ventas WHERE id= ?";

      try {
        comando = conexion.prepareStatement(SQL);
        comando.setInt(1,id);

        comando.execute();

      } catch (SQLException e) {
        System.out.println("Error de SQL al Eliminar: " + e);
      }

    }
  
}
