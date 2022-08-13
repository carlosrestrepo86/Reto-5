package Vista;

import Modelo.vo.ClasificacionVo;
import Modelo.vo.LiderVo;
import Modelo.vo.ProveedorVo;
import controlador.ControladorReportes;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class VistaGUI {
    private static final ControladorReportes controlador;

    static {
        controlador = new ControladorReportes();
    }

    public void Vista() {
        // Create views swing UI components
        JButton botonR1 = new JButton("INFORME 1");
        JButton botonR2 = new JButton("INFORME 2");
        JButton botonR3 = new JButton("INFORME 3");


        // Create table model
        Object[] titulos = { "", "", "", ""};
        DefaultTableModel model = new DefaultTableModel(titulos, 0);
        JTable table = new JTable(model);

        // Create controller
        botonR1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<LiderVo> temp = null;
                try {
                    temp = controlador.buscarPorLider();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                Object []datos = new Object[4];
                Object[] titulos = { "ID_Lider", "Nombre", "Primer Apellido", "Ciudad Residencia"};

                if(temp.size() > 0){
                    model.setRowCount(0);
                    model.setColumnIdentifiers(titulos);
                    for (LiderVo modelo: temp){
                        datos[0] = modelo.getId();
                        datos[1] = modelo.getNombre();
                        datos[2] = modelo.getPrimerApellido();
                        datos[3] = modelo.getCiudadResidencia();
                        model.addRow(datos);
                    }
                }
            }
        });

        botonR2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<ClasificacionVo> temp = null;
                try {
                    temp = controlador.buscarPorClasificacion();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                Object []datos = new Object[4];
                Object[] titulos = { "ID_Proyecto", "Constructora", "Número de habitaciones", "Ciudad de Residencia"};

                if(temp.size() > 0){
                    model.setRowCount(0);
                    model.setColumnIdentifiers(titulos);
                    for (ClasificacionVo modelo: temp){
                        datos[0] = modelo.getId();
                        datos[1] = modelo.getConstructora();
                        datos[2] = modelo.getNumeroHabitaciones();
                        datos[3] = modelo.getCiudadResidencia();
                        model.addRow(datos);
                    }
                }
            }
        });

        botonR3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<ProveedorVo> temp = null;
                try {
                    temp = controlador.buscarPorProveedor();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                Object []datos = new Object[4];
                Object[] titulos = { "ID_Compra", "Constructora", "Banco Vinculado"};

                if(temp.size() > 0){
                    model.setRowCount(0);
                    model.setColumnIdentifiers(titulos);
                    for (ProveedorVo modelo: temp){
                        datos[0] = modelo.getId();
                        datos[1] = modelo.getConstructora();
                        datos[2] = modelo.getBancoVinculado();
                        model.addRow(datos);
                    }
                }
            }
        });

        // Set the view layout
        JPanel ctrlPane = new JPanel();
        ctrlPane.setBackground(new Color(95,104,222));
        ctrlPane.add(botonR1);
        ctrlPane.add(botonR2);
        ctrlPane.add(botonR3);

        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setPreferredSize(new Dimension(700, 500));
        tableScrollPane.setBackground(new Color(95,104,222));
        tableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "INFORME",
                TitledBorder.CENTER, TitledBorder.TOP));

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, ctrlPane, tableScrollPane);
        splitPane.setDividerLocation(35);
        splitPane.setEnabled(false);

        // Display it all in a scrolling window and make the window appear
        JFrame frame = new JFrame("INFORMACIÓN RETO 5");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(700, 500));
        frame.getContentPane().setBackground(new Color(95,104,222));
        frame.add(splitPane);
        frame.pack();
        frame.setLocation(300,100);
        frame.setVisible(true);
    }

}
