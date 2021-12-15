package modelo;

import java.sql.*;
import java.util.ArrayList;

public class Detalles_ventasDAO {

    private Connection conexion;
    private PreparedStatement comando;

    public Detalles_ventasDAO() {
      try {
        conexion = Conexion.getConexion();
      }
      catch (Exception e) {
        System.out.println("Error de SQL: " + e);
      }
    }


    public ArrayList <Detalles_ventasDTO> seleccionar () {
      ArrayList <Detalles_ventasDTO> datos = new ArrayList <Detalles_ventasDTO>();

      String SQL =
              "SELECT " +
              "  id, " +
              "  producto_id, " +
              "  venta_id, " +
              "  cantidad, " +
              "  valor, " +
              "  valor_total  " +
              "FROM detalles_ventas ORDER BY id";

      try {

        System.out.println("Select: " + SQL);
          
        comando = conexion.prepareStatement(SQL);
        ResultSet rs = comando.executeQuery();

        while(rs.next()) {
          datos.add(new Detalles_ventasDTO(
                  rs.getInt("id"),
                  rs.getInt("producto_id"),
                  rs.getInt("venta_id"),
                  rs.getDouble("cantidad"),
                  rs.getDouble("valor"),
                  rs.getDouble("valor_total") 
          ));
        }

      } catch (SQLException e) {
        System.out.println("Error de SQL al seleccionar: " + e);
      }

      return datos;
    }
    
    public ArrayList <Detalles_ventasDTO> seleccionarVenta (int ventaId) {
        ArrayList <Detalles_ventasDTO> datos = new ArrayList <Detalles_ventasDTO>();

        String SQL =
                "SELECT " +
                "  id, " +
                "  producto_id, " +
                "  venta_id, " +
                "  cantidad, " +
                "  valor, " +
                "  valor_total  " +
                "FROM detalles_ventas "
                + " WHERE venta_id = ? "
                + "ORDER BY id";

        try {

          System.out.println("Select: " + SQL);
            
          comando = conexion.prepareStatement(SQL);
          comando.setInt(1,ventaId);
          ResultSet rs = comando.executeQuery();

          while(rs.next()) {
            datos.add(new Detalles_ventasDTO(
                    rs.getInt("id"),
                    rs.getInt("producto_id"),
                    rs.getInt("venta_id"),
                    rs.getDouble("cantidad"),
                    rs.getDouble("valor"),
                    rs.getDouble("valor_total") 
            ));
          }

        } catch (SQLException e) {
          System.out.println("Error de SQL al seleccionar: " + e);
        }

        return datos;
      }    

    public Detalles_ventasDTO seleccionar  (int id) {


      Detalles_ventasDTO dato = null;

      String SQL =
              "SELECT " +
              "  id, " +
              "  producto_id, " +
              "  venta_id, " +
              "  cantidad, " +
              "  valor, " +
              "  valor_total  " +
              "FROM detalles_ventas " +
              "WHERE id = ?";

      try {
        comando = conexion.prepareStatement(SQL);
        comando.setInt(1,id);
        ResultSet rs = comando.executeQuery();

        if (rs.next()) {
          dato = new Detalles_ventasDTO(
                  rs.getInt("id"),
                  rs.getInt("producto_id"),
                  rs.getInt("venta_id"),
                  rs.getDouble("cantidad"),
                  rs.getDouble("valor"),
                  rs.getDouble("valor_total") 
          );
        }

      } catch (SQLException e) {
        System.out.println("Error de SQL al seleccionar: " + e);
      }

      return dato;
    }

    public void insertar (Detalles_ventasDTO dato) {

      String sqlInsertar =
              "INSERT INTO detalles_ventas (" +
                    "  producto_id, " +
                    "  venta_id, " +
                    "  cantidad, " +
                    "  valor, " +
                    "  valor_total  " +
                      " ) " + 
                      "VALUES (?,?,?,?,? )";

      try {
        comando = conexion.prepareStatement(sqlInsertar,Statement.RETURN_GENERATED_KEYS);
        comando.setInt(1,dato.getProducto_id());
        comando.setInt(2,dato.getVenta_id());
        comando.setDouble(3,dato.getCantidad());
        comando.setDouble(4,dato.getValor());
        comando.setDouble(5,dato.getValor_total());

        comando.execute();
       
        ResultSet rs = comando.getGeneratedKeys();

        if (rs.next()) {
          dato.setId(rs.getInt(1));
        }
      


      } catch (SQLException e) {
        System.out.println("Error de SQL al Insertar: " + e);
      }

    }

    public void actualizar (Detalles_ventasDTO dato) {

      String SQL =
              "UPDATE detalles_ventas SET " +
                    "  producto_id= ?, " +
                    "  venta_id= ?, " +
                    "  cantidad= ?, " +
                    "  valor= ?, " +
                    "  valor_total= ?  " +
                    "WHERE id = ?";

      try {

        comando = conexion.prepareStatement(SQL);

        comando.setInt(1,dato.getProducto_id());
        comando.setInt(2,dato.getVenta_id());
        comando.setDouble(3,dato.getCantidad());
        comando.setDouble(4,dato.getValor());
        comando.setDouble(5,dato.getValor_total());

        comando.setInt(6,dato.getId());

        comando.execute();

      } catch (SQLException e) {
        System.out.println("Error de SQL al Actualizar: " + e);
      }
    }
    
    public void eliminar (int id) {

      String SQL = "DELETE FROM detalles_ventas WHERE id= ?";

      try {
        comando = conexion.prepareStatement(SQL);
        comando.setInt(1,id);

        comando.execute();

      } catch (SQLException e) {
        System.out.println("Error de SQL al Eliminar: " + e);
      }

    }
  
}
