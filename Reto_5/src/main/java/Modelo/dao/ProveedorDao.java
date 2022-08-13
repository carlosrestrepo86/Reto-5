package Modelo.dao;

import Modelo.vo.ClasificacionVo;
import Modelo.vo.ProveedorVo;
import util.ConexionJDBC;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDao {
    public static List<ProveedorVo> buscarProveedor() throws SQLException {
        var respuesta = new ArrayList<ProveedorVo>();
        try{
            String sql = "SELECT Compra.ID_Compra," +
                    "Proyecto.Constructora," +
                    "Proyecto.Banco_Vinculado " +
                    "FROM Compra " +
                    "JOIN Proyecto ON Compra.ID_Proyecto = Proyecto.ID_Proyecto " +
                    "WHERE Compra.Proveedor = 'Homecenter'";
            var conexion = ConexionJDBC.getConnection();
            var estado = conexion.prepareStatement(sql);

            try (var rset = estado.executeQuery()){
                while (rset.next()){
                    var proveedor = new ProveedorVo();
                    proveedor.setId(rset.getInt("ID_Compra"));
                    proveedor.setConstructora(rset.getString("Constructora"));
                    proveedor.setBancoVinculado(rset.getString("Banco_Vinculado"));
                    respuesta.add(proveedor);
                }
            }
        }catch (SQLException e){
            System.out.println(e);
        }

        return respuesta;
    }
}
