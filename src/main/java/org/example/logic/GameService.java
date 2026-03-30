package org.example.logic;

import org.example.db.videogameDAO;
import org.example.models.Videogame;

import java.util.ArrayList;
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
    public List<Videogame> showAllVideogames () {
        return new ArrayList<>(internalList);
    }

    @Override
    public List<Videogame> filterByGenre (String genre) {

        return repo.searchByGenre(genre);

        /*return internalList.stream()
                .filter(videogame -> videogame.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());*/
    }

    @Override
    public Videogame searchGame (String titleVideogame) {
        Videogame foundVideogame = repo.searchByTitle(titleVideogame);

        if (foundVideogame == null) {
            System.out.println("The videogame '" + titleVideogame + "' doesn't exists in the database.");
        }

        return foundVideogame;
    }

    @Override
    public String EnterpriceMadeMoreVideogames() {

        return repo.enterpriseWithMoreVideogames();

        /*Map<String, Long> countEnterpriceGames = internalList.stream()
                .collect(Collectors.groupingBy(
                        Videogame::getEnterprise,
                        Collectors.counting()
                ));

        return countEnterpriceGames.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(best -> best.getKey() + " with " + best.getValue() + " games")
                .orElse("No data");*/
    }

    @Override
    public List<Videogame> filterEnterpriseVideogames(String enterprise) {
        return repo.searchEnterpriseVideogames(enterprise);
    }

    @Override
    public List<Videogame> filterGamesAfterYearOfPublication(int year) {
        return repo.searchGamesAfterYear(year);
    }
}
