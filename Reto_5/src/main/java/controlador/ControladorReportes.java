package controlador;

import Modelo.dao.ClasificacionDao;
import Modelo.dao.LiderDao;
import Modelo.dao.ProveedorDao;
import Modelo.vo.ClasificacionVo;
import Modelo.vo.LiderVo;
import Modelo.vo.ProveedorVo;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

public class ControladorReportes{
    private LiderDao liderdao;
    private ClasificacionDao clasificaciondao;
    private ProveedorDao proveedordao;
    private DefaultTableModel modelo;

    public ControladorReportes() {

        this.liderdao = new LiderDao();
        this.modelo = modelo;
        this.clasificaciondao = new ClasificacionDao();
        this.proveedordao = new ProveedorDao();
    }

    public List<LiderVo> buscarPorLider() throws SQLException{
        return liderdao.buscarLider();
    }

    public List<ClasificacionVo> buscarPorClasificacion() throws SQLException{
        return clasificaciondao.buscarClasificacion();
    }

    public List<ProveedorVo> buscarPorProveedor() throws SQLException{
        return proveedordao.buscarProveedor();
    }


}
