package modelo;

import java.sql.*;
import java.util.ArrayList;

public class ProductosDAO {

    private Connection conexion;
    private PreparedStatement comando;

    public ProductosDAO() {
      try {
        conexion = Conexion.getConexion();
      }
      catch (Exception e) {
        System.out.println("Error de SQL: " + e);
      }
    }


    public ArrayList <ProductosDTO> seleccionar () {
      ArrayList <ProductosDTO> datos = new ArrayList <ProductosDTO>();

      String SQL =
              "SELECT " +
              "  id, " +
              "  codigo, " +
              "  iva_compra, " +
              "  proveedor_id, " +
              "  nombre, " +
              "  valor_compra, " +
              "  valor_venta  " +
              "FROM productos ORDER BY id";

      try {

        System.out.println("Select: " + SQL);
          
        comando = conexion.prepareStatement(SQL);
        ResultSet rs = comando.executeQuery();

        while(rs.next()) {
          datos.add(new ProductosDTO(
                  rs.getInt("id"),
                  rs.getLong("codigo"),
                  rs.getDouble("iva_compra"),
                  rs.getInt("proveedor_id"),
                  rs.getString("nombre"),
                  rs.getDouble("valor_compra"),
                  rs.getDouble("valor_venta") 
          ));
        }

      } catch (SQLException e) {
        System.out.println("Error de SQL al seleccionar: " + e);
      }

      return datos;
    }

    public ProductosDTO seleccionar  (int id) {


      ProductosDTO dato = null;

      String SQL =
              "SELECT " +
              "  id, " +
              "  codigo, " +
              "  iva_compra, " +
              "  proveedor_id, " +
              "  nombre, " +
              "  valor_compra, " +
              "  valor_venta  " +
              "FROM productos " +
              "WHERE id = ?";

      try {
        comando = conexion.prepareStatement(SQL);
        comando.setInt(1,id);
        ResultSet rs = comando.executeQuery();

        if (rs.next()) {
          dato = new ProductosDTO(
                  rs.getInt("id"),
                  rs.getLong("codigo"),
                  rs.getDouble("iva_compra"),
                  rs.getInt("proveedor_id"),
                  rs.getString("nombre"),
                  rs.getDouble("valor_compra"),
                  rs.getDouble("valor_venta") 
          );
        }

      } catch (SQLException e) {
        System.out.println("Error de SQL al seleccionar: " + e);
      }

      return dato;
    }

    public void insertar (ProductosDTO dato) {

      String sqlInsertar =
              "INSERT INTO productos (" +
                    "  codigo, " +
                    "  iva_compra, " +
                    "  proveedor_id, " +
                    "  nombre, " +
                    "  valor_compra, " +
                    "  valor_venta  " +
                      " ) " + 
                      "VALUES (?,?,?,?,?,? )";

      try {
        comando = conexion.prepareStatement(sqlInsertar,Statement.RETURN_GENERATED_KEYS);
        comando.setLong(1,dato.getCodigo());
        comando.setDouble(2,dato.getIva_compra());
        comando.setInt(3,dato.getProveedor_id());
        comando.setString(4,dato.getNombre());
        comando.setDouble(5,dato.getValor_compra());
        comando.setDouble(6,dato.getValor_venta());

        comando.execute();
       
        ResultSet rs = comando.getGeneratedKeys();

        if (rs.next()) {
          dato.setId(rs.getInt(1));
        }


      } catch (SQLException e) {
        System.out.println("Error de SQL al Insertar: " + e);
      }

    }

    public void actualizar (ProductosDTO dato) {

      String SQL =
              "UPDATE productos SET " +
                    "  codigo= ?, " +
                    "  iva_compra= ?, " +
                    "  proveedor_id= ?, " +
                    "  nombre= ?, " +
                    "  valor_compra= ?, " +
                    "  valor_venta= ?  " +
                    "WHERE id = ?";

      try {

        comando = conexion.prepareStatement(SQL);

        comando.setLong(1,dato.getCodigo());
        comando.setDouble(2,dato.getIva_compra());
        comando.setInt(3,dato.getProveedor_id());
        comando.setString(4,dato.getNombre());
        comando.setDouble(5,dato.getValor_compra());
        comando.setDouble(6,dato.getValor_venta());

        comando.setInt(7,dato.getId());

        comando.execute();

      } catch (SQLException e) {
        System.out.println("Error de SQL al Actualizar: " + e);
      }
    }

    public void eliminar (int id) {

      String SQL = "DELETE FROM productos WHERE id= ?";

      try {
        comando = conexion.prepareStatement(SQL);
        comando.setInt(1,id);

        comando.execute();

      } catch (SQLException e) {
        System.out.println("Error de SQL al Eliminar: " + e);
      }

    }
  
}
