package Modelo.dao;

import Modelo.vo.LiderVo;
import util.ConexionJDBC;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LiderDao {
    public static List<LiderVo> buscarLider() throws SQLException{
        var respuesta = new ArrayList<LiderVo>();
        try{
            String sql = "SELECT ID_Lider," +
                    "Nombre," +
                    "Primer_Apellido," +
                    "Ciudad_Residencia " +
                    "FROM Lider " +
                    "ORDER BY Ciudad_Residencia ASC";
            var conexion = ConexionJDBC.getConnection();
            var estado = conexion.prepareStatement(sql);

            try (var rset = estado.executeQuery()){
                while (rset.next()){
                    var lider = new LiderVo();
                    lider.setId(rset.getInt("ID_Lider"));
                    lider.setNombre(rset.getString("Nombre"));
                    lider.setPrimerApellido(rset.getString("Primer_Apellido"));
                    lider.setCiudadResidencia(rset.getString("Ciudad_Residencia"));
                    respuesta.add(lider);
                }
            }
        }catch (SQLException e){
            System.out.println(e);
        }

        return respuesta;
    }
}
