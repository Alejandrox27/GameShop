package org.example.logic;

import org.example.db.videogameDAO;
import org.example.models.Videogame;
import java.util.List;

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
    public void showAllVideogames () {
        internalList.forEach(System.out::println);
    }
}
