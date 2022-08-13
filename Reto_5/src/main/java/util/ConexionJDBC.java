package util;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionJDBC {
    private static final String UBICACION_BD = "ProyectosConstruccion.db";

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:" + UBICACION_BD;
        return DriverManager.getConnection(url);
    }

    public static boolean isDatabaseEmpty() {
        File file = new File(UBICACION_BD);
        return file.length() == 0;
    }
}
