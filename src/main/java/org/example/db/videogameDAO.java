package org.example.db;
import org.example.models.Videogame;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class videogameDAO {

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

        try (Connection conn = connection.getConnection();
             Statement stmt  = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Videogame videogame = new Videogame(
                        rs.getInt("Id_juego"),
                        rs.getString("Titulo"),
                        rs.getObject("fechaPublicacion", LocalDate.class),
                        rs.getString("RealNameDirector"),
                        rs.getString("empresa"),
                        rs.getString("GenreVideogame"),
                        rs.getString("ClasificationESRB"),
                        rs.getString("Engine")
                );
                videogames.add(videogame);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return videogames;
    }

    public Videogame searchByTitle (String videogameTitle) {
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
                "INNER JOIN Motores ON Videojuegos.Motor = Motores.Id) " +
                "WHERE Videojuegos.Titulo = ?";

        try (Connection conn = connection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, videogameTitle);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Videogame(
                            rs.getInt("Id_juego"),
                            rs.getString("Titulo"),
                            rs.getObject("fechaPublicacion", LocalDate.class),
                            rs.getString("RealNameDirector"),
                            rs.getString("empresa"),
                            rs.getString("GenreVideogame"),
                            rs.getString("ClasificationESRB"),
                            rs.getString("Engine")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        return null;
    }

    public List<Videogame> searchByGenre (String genre) {
        List<Videogame> videogamesFilteredByGenre = new ArrayList<>();

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
                "INNER JOIN Motores ON Videojuegos.Motor = Motores.Id) " +
                "WHERE Generos.genero = ?";

        try (Connection conn = connection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {


            pstmt.setString(1, genre);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Videogame videogame = new Videogame(
                            rs.getInt("Id_juego"),
                            rs.getString("Titulo"),
                            rs.getObject("fechaPublicacion", LocalDate.class),
                            rs.getString("RealNameDirector"),
                            rs.getString("empresa"),
                            rs.getString("GenreVideogame"),
                            rs.getString("ClasificationESRB"),
                            rs.getString("Engine")
                    );
                    videogamesFilteredByGenre.add(videogame);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return videogamesFilteredByGenre;
    }

    public List<Videogame> searchEnterpriseVideogames (String enterprise) {
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
                "INNER JOIN Motores ON Videojuegos.Motor = Motores.Id) " +
                "WHERE Desarrolladoras.empresa = ?";

        try (Connection conn = connection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, enterprise);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Videogame videogame = new Videogame(
                            rs.getInt("Id_juego"),
                            rs.getString("Titulo"),
                            rs.getObject("fechaPublicacion", LocalDate.class),
                            rs.getString("RealNameDirector"),
                            rs.getString("empresa"),
                            rs.getString("GenreVideogame"),
                            rs.getString("ClasificationESRB"),
                            rs.getString("Engine")
                    );
                    videogames.add(videogame);
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return videogames;
    }

    public String enterpriseWithMoreVideogames () {
        String sql = "SELECT Desarrolladoras.empresa, COUNT(*) As total " +
                "FROM Videojuegos " +
                "INNER JOIN Desarrolladoras ON Videojuegos.desarrollador = Desarrolladoras.Id " +
                "GROUP BY Desarrolladoras.empresa " +
                "ORDER BY total DESC " +
                "LIMIT 1";

        try (Connection conn = connection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                String enterprise = rs.getString("empresa");
                int count = rs.getInt("total");

                return enterprise + " with " + count + " games";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public List<Videogame> searchGamesAfterYear (int year) {
        List<Videogame> videogamesAfterYear = new ArrayList<>();

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
                "INNER JOIN Motores ON Videojuegos.Motor = Motores.Id) " +
                "WHERE YEAR(fechaPublicacion) >= ? " +
                "ORDER BY fechaPublicacion ASC";

        try (Connection conn = connection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, year);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Videogame videogame = new Videogame(
                            rs.getInt("Id_juego"),
                            rs.getString("Titulo"),
                            rs.getObject("fechaPublicacion", LocalDate.class),
                            rs.getString("RealNameDirector"),
                            rs.getString("empresa"),
                            rs.getString("GenreVideogame"),
                            rs.getString("ClasificationESRB"),
                            rs.getString("Engine")
                    );
                    videogamesAfterYear.add(videogame);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return videogamesAfterYear;
    }

}
