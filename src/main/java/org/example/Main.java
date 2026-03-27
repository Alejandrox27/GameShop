package org.example;
import org.example.db.videogameDAO;
import org.example.models.Videogame;
import org.example.logic.GameService;
import org.example.logic.IGameService;
import java.util.List;
import java.util.ArrayList;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        IGameService service = new GameService();

        /*List<Videogame> videogames = service.showAllVideogames();
        System.out.println(videogames);*/

        // FILTER VIDEOGAMES BY GENRE USING FUNCTIONAL PROGRAMMING (STREAMS)
        /*List<Videogame> videogamesFilteredByGenre = service.filterByGenre("platforms");
        System.out.println(videogamesFilteredByGenre);*/

        // FIND VIDEOGAME USING SQL
        /*Videogame videogameFound = service.searchGame("grand theft auto vI");
        System.out.println(videogameFound);*/
    }
}
