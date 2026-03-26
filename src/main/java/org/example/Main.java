package org.example;
import org.example.db.connection;
import org.example.models.Videogame;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        final connection repo = new connection();
        List<Videogame> internatList = repo.findAll();
    }
}
