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
    private String empresa;

        public Videogame (int id, String title, LocalDate publicationDate, String director, String empresa, String genre,
                          String clasification_ESRB, String engine) {
        this.id = id;
        this.title = title;
        this.publicationDate = publicationDate;
        this.director = director;
        this.empresa = empresa;
        this.genre = genre;
        this.clasification_ESRB = clasification_ESRB;
        this.engine = engine;
    }

    public String getGenre () {
            return genre;
    }

    @Override
    public String toString() {
        return "------------------------------------------\n" +
                "VIDEOGAME [" + id + "]\n" +
                "------------------------------------------\n" +
                "Title:       " + title + "\n" +
                "Date:        " + publicationDate + "\n" +
                "Director:     " + director + "\n" +
                "Enterprise: " + empresa + "\n" +
                "Genre:       " + genre + "\n" +
                "ESRB:         " + clasification_ESRB + "\n" +
                "Engine: " + engine + "\n" +
                "------------------------------------------";
    }
}
