package modelo;

import java.sql.*;
import java.util.ArrayList;

public class ReportesDAO {

    private Connection conexion;
    private PreparedStatement comando;

    public ReportesDAO() {
      try {
        conexion = Conexion.getConexion();
      }
      catch (Exception e) {
        System.out.println("Error de SQL: " + e);
      }
    }


    public ArrayList <ReportesDTO> seleccionar () {
      ArrayList <ReportesDTO> datos = new ArrayList <ReportesDTO>();

      String SQL =
              "SELECT " +
              "  id, " +
              "  nombre, " +
              "  definicion  " +
              "FROM generaappweb.reportes ORDER BY id";

      try {

        System.out.println("Select: " + SQL);
          
        comando = conexion.prepareStatement(SQL);
        ResultSet rs = comando.executeQuery();

        while(rs.next()) {
          datos.add(new ReportesDTO(
                  rs.getInt("id"),
                  rs.getString("nombre"),
                  rs.getString("definicion") 
          ));
        }

      } catch (SQLException e) {
        System.out.println("Error de SQL al seleccionar: " + e);
      }

      return datos;
    }

    public ReportesDTO seleccionar  (int id) {


      ReportesDTO dato = null;

      String SQL =
              "SELECT " +
              "  id, " +
              "  nombre, " +
              "  definicion  " +
              "FROM generaappweb.reportes " +
              "WHERE id = ?";

      try {
        comando = conexion.prepareStatement(SQL);
        comando.setInt(1,id);
        ResultSet rs = comando.executeQuery();

        if (rs.next()) {
          dato = new ReportesDTO(
                  rs.getInt("id"),
                  rs.getString("nombre"),
                  rs.getString("definicion") 
          );
        }

      } catch (SQLException e) {
        System.out.println("Error de SQL al seleccionar: " + e);
      }

      return dato;
    }

    public void insertar (ReportesDTO dato) {

      String sqlInsertar =
              "INSERT INTO generaappweb.reportes (" +
                    "  nombre, " +
                    "  definicion  " +
                      " ) " + 
                      "VALUES (?,? )";

      try {
        comando = conexion.prepareStatement(sqlInsertar,Statement.RETURN_GENERATED_KEYS);
        comando.setString(1,dato.getNombre());
        comando.setString(2,dato.getDefinicion());

        comando.execute();
       
        ResultSet rs = comando.getGeneratedKeys();

        if (rs.next()) {
          dato.setId(rs.getInt(1));
        }


      } catch (SQLException e) {
        System.out.println("Error de SQL al Insertar: " + e);
      }

    }

    public void actualizar (ReportesDTO dato) {

      String SQL =
              "UPDATE generaappweb.reportes SET " +
                    "  nombre= ?, " +
                    "  definicion= ?  " +
                    "WHERE id = ?";

      try {

        comando = conexion.prepareStatement(SQL);

        comando.setString(1,dato.getNombre());
        comando.setString(2,dato.getDefinicion());

        comando.setInt(3,dato.getId());

        comando.execute();

      } catch (SQLException e) {
        System.out.println("Error de SQL al Actualizar: " + e);
      }
    }

    public void eliminar (int id) {

      String SQL = "DELETE FROM generaappweb.reportes WHERE id= ?";

      try {
        comando = conexion.prepareStatement(SQL);
        comando.setInt(1,id);

        comando.execute();

      } catch (SQLException e) {
        System.out.println("Error de SQL al Eliminar: " + e);
      }

    }
  
}
