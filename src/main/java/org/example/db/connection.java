package org.example.db;
import org.example.models.Videogame;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class connection {
    String path = System.getProperty("user.dir") + "/src/main/java/org/example/db/TiendaDeVideojuegos.accdb";
    String URL = "jdbc:ucanaccess://" + path;

    public List<Videogame> findAll () {
        List<Videogame> videogames = new ArrayList<>();

        String sql = "SELECT Videojuegos.*, " +
                "Desarrolladoras.empresa, " +
                "Directores.Director AS RealNameDirector, " +
                "Generos.Genero As GenreVideogame, " +
                "Clasificacion_ESRB.Sigla As ClasificationESRB, " +
                "Motores.Nombre_Motor As Engine " +
                "FROM (((((Videojuegos " +
                "INNER JOIN Desarrolladoras ON Videojuegos.Desarrollador = Desarrolladoras.Id) " +
                "INNER JOIN Directores ON Videojuegos.Director = Directores.Id)" +
                "INNER JOIN Generos ON Videojuegos.Genero = Generos.Id)" +
                "INNER JOIN Clasificacion_ESRB ON Videojuegos.Clasificacion_ESBR = Clasificacion_ESRB.Pk)" +
                "INNER JOIN Motores ON Videojuegos.Motor = Motores.Id)";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt  = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Connection succesfully");

            while (rs.next()) {
                System.out.println(rs.getInt("Id_juego"));
                System.out.println(rs.getString("Titulo"));
                System.out.println(rs.getDate("fechaPublicacion"));
                System.out.println(rs.getString("empresa"));
                System.out.println(rs.getString("RealNameDirector"));
                System.out.println(rs.getString("GenreVideogame"));
                System.out.println(rs.getString("ClasificationESRB"));
                System.out.println(rs.getString("Engine"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return videogames;
    }



}
