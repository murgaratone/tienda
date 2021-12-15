package modelo;

import java.sql.*;
import java.util.ArrayList;

public class ProveedoresDAO {

    private Connection conexion;
    private PreparedStatement comando;

    public ProveedoresDAO() {
      try {
        conexion = Conexion.getConexion();
      }
      catch (Exception e) {
        System.out.println("Error de SQL: " + e);
      }
    }


    public ArrayList <ProveedoresDTO> seleccionar () {
      ArrayList <ProveedoresDTO> datos = new ArrayList <ProveedoresDTO>();

      String SQL =
              "SELECT " +
              "  id, " +
              "  nit, " +
              "  ciudad, " +
              "  direccion, " +
              "  nombre, " +
              "  telefono  " +
              "FROM proveedores ORDER BY id";

      try {

        System.out.println("Select: " + SQL);
          
        comando = conexion.prepareStatement(SQL);
        ResultSet rs = comando.executeQuery();

        while(rs.next()) {
          datos.add(new ProveedoresDTO(
                  rs.getInt("id"),
                  rs.getLong("nit"),
                  rs.getString("ciudad"),
                  rs.getString("direccion"),
                  rs.getString("nombre"),
                  rs.getString("telefono") 
          ));
        }

      } catch (SQLException e) {
        System.out.println("Error de SQL al seleccionar: " + e);
      }

      return datos;
    }

    public ProveedoresDTO seleccionar  (int id) {


      ProveedoresDTO dato = null;

      String SQL =
              "SELECT " +
              "  id, " +
              "  nit, " +
              "  ciudad, " +
              "  direccion, " +
              "  nombre, " +
              "  telefono  " +
              "FROM proveedores " +
              "WHERE id = ?";

      try {
        comando = conexion.prepareStatement(SQL);
        comando.setInt(1,id);
        ResultSet rs = comando.executeQuery();

        if (rs.next()) {
          dato = new ProveedoresDTO(
                  rs.getInt("id"),
                  rs.getLong("nit"),
                  rs.getString("ciudad"),
                  rs.getString("direccion"),
                  rs.getString("nombre"),
                  rs.getString("telefono") 
          );
        }

      } catch (SQLException e) {
        System.out.println("Error de SQL al seleccionar: " + e);
      }

      return dato;
    }

    public void insertar (ProveedoresDTO dato) {

      String sqlInsertar =
              "INSERT INTO proveedores (" +
                    "  nit, " +
                    "  ciudad, " +
                    "  direccion, " +
                    "  nombre, " +
                    "  telefono  " +
                      " ) " + 
                      "VALUES (?,?,?,?,? )";

      try {
        comando = conexion.prepareStatement(sqlInsertar,Statement.RETURN_GENERATED_KEYS);
        comando.setLong(1,dato.getNit());
        comando.setString(2,dato.getCiudad());
        comando.setString(3,dato.getDireccion());
        comando.setString(4,dato.getNombre());
        comando.setString(5,dato.getTelefono());

        comando.execute();
       
        ResultSet rs = comando.getGeneratedKeys();

        if (rs.next()) {
          dato.setId(rs.getInt(1));
        }


      } catch (SQLException e) {
        System.out.println("Error de SQL al Insertar: " + e);
      }

    }

    public void actualizar (ProveedoresDTO dato) {

      String SQL =
              "UPDATE proveedores SET " +
                    "  nit= ?, " +
                    "  ciudad= ?, " +
                    "  direccion= ?, " +
                    "  nombre= ?, " +
                    "  telefono= ?  " +
                    "WHERE id = ?";

      try {

        comando = conexion.prepareStatement(SQL);

        comando.setLong(1,dato.getNit());
        comando.setString(2,dato.getCiudad());
        comando.setString(3,dato.getDireccion());
        comando.setString(4,dato.getNombre());
        comando.setString(5,dato.getTelefono());

        comando.setInt(6,dato.getId());

        comando.execute();

      } catch (SQLException e) {
        System.out.println("Error de SQL al Actualizar: " + e);
      }
    }

    public void eliminar (int id) {

      String SQL = "DELETE FROM proveedores WHERE id= ?";

      try {
        comando = conexion.prepareStatement(SQL);
        comando.setInt(1,id);

        comando.execute();

      } catch (SQLException e) {
        System.out.println("Error de SQL al Eliminar: " + e);
      }

    }
  
}