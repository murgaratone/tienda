package modelo;

import java.sql.*;
import java.util.ArrayList;

public class ClientesDAO {

    private Connection conexion;
    private PreparedStatement comando;

    public ClientesDAO() {
      try {
        conexion = Conexion.getConexion();
      }
      catch (Exception e) {
        System.out.println("Error de SQL: " + e);
      }
    }


    public ArrayList <ClientesDTO> seleccionar () {
      ArrayList <ClientesDTO> datos = new ArrayList <ClientesDTO>();

      String SQL =
              "SELECT " +
              "  id, " +
              "  cedula, " +
              "  direccion, " +
              "  email, " +
              "  nombre, " +
              "  telefono  " +
              "FROM clientes ORDER BY id";

      try {

        System.out.println("Select: " + SQL);
          
        comando = conexion.prepareStatement(SQL);
        ResultSet rs = comando.executeQuery();

        while(rs.next()) {
          datos.add(new ClientesDTO(
                  rs.getInt("id"),
                  rs.getLong("cedula"),
                  rs.getString("direccion"),
                  rs.getString("email"),
                  rs.getString("nombre"),
                  rs.getString("telefono") 
          ));
        }

      } catch (SQLException e) {
        System.out.println("Error de SQL al seleccionar: " + e);
      }

      return datos;
    }

    public ClientesDTO seleccionar  (int id) {


      ClientesDTO dato = null;

      String SQL =
              "SELECT " +
              "  id, " +
              "  cedula, " +
              "  direccion, " +
              "  email, " +
              "  nombre, " +
              "  telefono  " +
              "FROM clientes " +
              "WHERE id = ?";

      try {
        comando = conexion.prepareStatement(SQL);
        comando.setInt(1,id);
        ResultSet rs = comando.executeQuery();

        if (rs.next()) {
          dato = new ClientesDTO(
                  rs.getInt("id"),
                  rs.getLong("cedula"),
                  rs.getString("direccion"),
                  rs.getString("email"),
                  rs.getString("nombre"),
                  rs.getString("telefono") 
          );
        }

      } catch (SQLException e) {
        System.out.println("Error de SQL al seleccionar: " + e);
      }

      return dato;
    }

    public void insertar (ClientesDTO dato) {

      String sqlInsertar =
              "INSERT INTO clientes (" +
                    "  cedula, " +
                    "  direccion, " +
                    "  email, " +
                    "  nombre, " +
                    "  telefono  " +
                      " ) " + 
                      "VALUES (?,?,?,?,? )";

      try {
        comando = conexion.prepareStatement(sqlInsertar,Statement.RETURN_GENERATED_KEYS);
        comando.setLong(1,dato.getCedula());
        comando.setString(2,dato.getDireccion());
        comando.setString(3,dato.getEmail());
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

    public void actualizar (ClientesDTO dato) {

      String SQL =
              "UPDATE clientes SET " +
                    "  cedula= ?, " +
                    "  direccion= ?, " +
                    "  email= ?, " +
                    "  nombre= ?, " +
                    "  telefono= ?  " +
                    "WHERE id = ?";

      try {

        comando = conexion.prepareStatement(SQL);

        comando.setLong(1,dato.getCedula());
        comando.setString(2,dato.getDireccion());
        comando.setString(3,dato.getEmail());
        comando.setString(4,dato.getNombre());
        comando.setString(5,dato.getTelefono());

        comando.setInt(6,dato.getId());

        comando.execute();

      } catch (SQLException e) {
        System.out.println("Error de SQL al Actualizar: " + e);
      }
    }

    public void eliminar (int id) {

      String SQL = "DELETE FROM clientes WHERE id= ?";

      try {
        comando = conexion.prepareStatement(SQL);
        comando.setInt(1,id);

        comando.execute();

      } catch (SQLException e) {
        System.out.println("Error de SQL al Eliminar: " + e);
      }

    }
  
}