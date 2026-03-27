package org.example.logic;

import org.example.db.videogameDAO;
import org.example.models.Videogame;
import java.util.List;
import java.util.stream.Collectors;

public class GameService implements IGameService{
    final videogameDAO repo = new videogameDAO();

    List<Videogame> internalList;

    public GameService() {
        this.internalList = repo.findAll();
    }

    public void refreshData () {
        this.internalList = repo.findAll();
    }

    @Override
    public List<Videogame> showAllVideogames () {
        return internalList.stream()
                .collect(Collectors.toList());
    }

    @Override
    public List<Videogame> filterByGenre (String genre) {
        return internalList.stream()
                .filter(videogame -> videogame.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    @Override
    public Videogame searchGame (String titleVideogame) {
        Videogame foundVideogame = repo.searchByTitle(titleVideogame);

        if (foundVideogame == null) {
            System.out.println("The videogame '" + titleVideogame + "' doesn't exists in the database.");
        }

        return foundVideogame;
    }
}
