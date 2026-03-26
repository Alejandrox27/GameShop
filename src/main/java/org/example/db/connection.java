package org.example.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
    private static final String PATH = System.getProperty("user.dir") + "/src/main/java/org/example/db/TiendaDeVideojuegos.accdb";
    private static final String URL = "jdbc:ucanaccess://" + PATH;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}