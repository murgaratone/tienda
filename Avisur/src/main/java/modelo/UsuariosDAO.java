package modelo;

import java.sql.*;
import java.util.ArrayList;

public class UsuariosDAO {

    private Connection conexion;
    private PreparedStatement comando;

    public UsuariosDAO() {
      try {
        conexion = Conexion.getConexion();
      }
      catch (Exception e) {
        System.out.println("Error de SQL: " + e);
      }
    }


    public ArrayList <UsuariosDTO> seleccionar () {
      ArrayList <UsuariosDTO> datos = new ArrayList <UsuariosDTO>();

      String SQL =
              "SELECT " +
              "  id, " +
              "  cedula, " +
              "  email, " +
              "  nombre, " +
              "  usuario, " +
              "  password, " +
              "  rol  " +
              "FROM usuarios ORDER BY id";

      try {

        System.out.println("Select: " + SQL);
          
        comando = conexion.prepareStatement(SQL);
        ResultSet rs = comando.executeQuery();

        while(rs.next()) {
          datos.add(new UsuariosDTO(
                  rs.getInt("id"),
                  rs.getLong("cedula"),
                  rs.getString("email"),
                  rs.getString("nombre"),
                  rs.getString("usuario"),
                  rs.getString("password"),
                  rs.getString("rol") 
          ));
        }

      } catch (SQLException e) {
        System.out.println("Error de SQL al seleccionar: " + e);
      }

      return datos;
    }
    
    public UsuariosDTO seleccionar  (int id) {


        UsuariosDTO dato = null;

        String SQL =
                "SELECT " +
                "  id, " +
                "  cedula, " +
                "  email, " +
                "  nombre, " +
                "  usuario, " +
                "  password, " +
                "  rol  " +
                "FROM usuarios " +
                "WHERE id = ?";

        try {
          comando = conexion.prepareStatement(SQL);
          comando.setInt(1,id);
          ResultSet rs = comando.executeQuery();

          if (rs.next()) {
            dato = new UsuariosDTO(
                    rs.getInt("id"),
                    rs.getLong("cedula"),
                    rs.getString("email"),
                    rs.getString("nombre"),
                    rs.getString("usuario"),
                    rs.getString("password"),
                    rs.getString("rol") 
            );
          }

        } catch (SQLException e) {
          System.out.println("Error de SQL al seleccionar: " + e);
        }

        return dato;
      }

    
    public UsuariosDTO seleccionarUsuario (String usuario) {


      UsuariosDTO dato = null;

      String SQL =
              "SELECT " +
              "  id, " +
              "  cedula, " +
              "  email, " +
              "  nombre, " +
              "  usuario, " +
              "  password, " +
              "  rol  " +
              "FROM usuarios " +
              "WHERE usuario = ?";

      try {
        comando = conexion.prepareStatement(SQL);
        comando.setString(1,usuario);
        ResultSet rs = comando.executeQuery();

        if (rs.next()) {
          dato = new UsuariosDTO(
                  rs.getInt("id"),
                  rs.getLong("cedula"),
                  rs.getString("email"),
                  rs.getString("nombre"),
                  rs.getString("usuario"),
                  rs.getString("password"),
                  rs.getString("rol") 
          );
        }

      } catch (SQLException e) {
        System.out.println("Error de SQL al seleccionar: " + e);
      }

      return dato;
    }

    public void insertar (UsuariosDTO dato) {

      String sqlInsertar =
              "INSERT INTO usuarios (" +
                    "  cedula, " +
                    "  email, " +
                    "  nombre, " +
                    "  usuario, " +
                    "  password, " +
                    "  rol  " +
                      " ) " + 
                      "VALUES (?,?,?,?,?,? )";

      try {
        comando = conexion.prepareStatement(sqlInsertar,Statement.RETURN_GENERATED_KEYS);
        comando.setLong(1,dato.getCedula());
        comando.setString(2,dato.getEmail());
        comando.setString(3,dato.getNombre());
        comando.setString(4,dato.getUsuario());
        comando.setString(5,dato.getPassword());
        comando.setString(6,dato.getRol());

        comando.execute();
       
        ResultSet rs = comando.getGeneratedKeys();

        if (rs.next()) {
          dato.setId(rs.getInt(1));
        }


      } catch (SQLException e) {
        System.out.println("Error de SQL al Insertar: " + e);
      }

    }

    public void actualizar (UsuariosDTO dato) {

      String SQL =
              "UPDATE usuarios SET " +
                    "  cedula= ?, " +
                    "  email= ?, " +
                    "  nombre= ?, " +
                    "  usuario= ?, " +
                    "  password= ?, " +
                    "  rol= ?  " +
                    "WHERE id = ?";

      try {

        comando = conexion.prepareStatement(SQL);

        comando.setLong(1,dato.getCedula());
        comando.setString(2,dato.getEmail());
        comando.setString(3,dato.getNombre());
        comando.setString(4,dato.getUsuario());
        comando.setString(5,dato.getPassword());
        comando.setString(6,dato.getRol());

        comando.setInt(7,dato.getId());

        comando.execute();

      } catch (SQLException e) {
        System.out.println("Error de SQL al Actualizar: " + e);
      }
    }

    public void eliminar (int id) {

      String SQL = "DELETE FROM usuarios WHERE id= ?";

      try {
        comando = conexion.prepareStatement(SQL);
        comando.setInt(1,id);

        comando.execute();

      } catch (SQLException e) {
        System.out.println("Error de SQL al Eliminar: " + e);
      }

    }
    
    }
  
