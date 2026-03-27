package org.example.logic;

import org.example.models.Videogame;

import java.util.List;

public interface IGameService {
    List<Videogame> showAllVideogames();
    List<Videogame> filterByGenre(String genre);
    Videogame searchGame(String title);
}
