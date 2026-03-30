package org.example.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Videogame {
    private int id;
    private String title;
    private LocalDate publicationDate;
    private String director;
    private String genre;
    private String clasification_ESRB;
    private String engine;
    private String enterprise;

        public Videogame (int id, String title, LocalDate publicationDate, String director, String enterprise, String genre,
                          String clasification_ESRB, String engine) {
        this.id = id;
        this.title = title;
        this.publicationDate = publicationDate;
        this.director = director;
        this.enterprise = enterprise;
        this.genre = genre;
        this.clasification_ESRB = clasification_ESRB;
        this.engine = engine;
    }

    public String getGenre () {
            return genre;
    }

    public String getEnterprise () {
        return enterprise;
    }

    @Override
    public String toString() {
        return "------------------------------------------\n" +
                "VIDEOGAME [" + id + "]\n" +
                "------------------------------------------\n" +
                "Title:       " + title + "\n" +
                "Date:        " + publicationDate + "\n" +
                "Director:     " + director + "\n" +
                "Enterprise: " + enterprise + "\n" +
                "Genre:       " + genre + "\n" +
                "ESRB:         " + clasification_ESRB + "\n" +
                "Engine: " + engine + "\n" +
                "------------------------------------------";
    }
}
