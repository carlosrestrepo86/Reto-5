package Modelo.dao;

import Modelo.vo.ClasificacionVo;
import Modelo.vo.LiderVo;
import util.ConexionJDBC;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClasificacionDao {
    public static List<ClasificacionVo> buscarClasificacion() throws SQLException {
        var respuesta = new ArrayList<ClasificacionVo>();
        try{
            String sql = "SELECT ID_Proyecto," +
                    "Constructora," +
                    "Numero_Habitaciones," +
                    "Ciudad " +
                    "FROM Proyecto " +
                    "WHERE Clasificacion == \"Casa Campestre\" AND (Ciudad == \"Santa Marta\"" +
                    " OR Ciudad == \"Cartagena\"  OR Ciudad == \"Barranquilla\")";
            var conexion = ConexionJDBC.getConnection();
            var estado = conexion.prepareStatement(sql);

            try (var rset = estado.executeQuery()){
                while (rset.next()){
                    var clasificacion = new ClasificacionVo();
                    clasificacion.setId(rset.getInt("ID_Proyecto"));
                    clasificacion.setConstructora(rset.getString("Constructora"));
                    clasificacion.setNumeroHabitaciones(rset.getInt("Numero_Habitaciones"));
                    clasificacion.setCiudadResidencia(rset.getString("Ciudad"));
                    respuesta.add(clasificacion);
                }
            }
        }catch (SQLException e){
            System.out.println(e);
        }

        return respuesta;
    }
}
