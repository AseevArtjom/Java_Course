package com.company;

import model.Genre.Genre;
import model.Genre.GenreCollection;
import service.Library.LibraryMenu;

public class Main {
    public static void main(String[] args) {
        GenreCollection genreCollection = GenreCollection.getInstance();
        genreCollection.addGenre(new Genre("Horror"));
        genreCollection.addGenre(new Genre("Fantasy"));
        genreCollection.addGenre(new Genre("Science"));
        genreCollection.addGenre(new Genre("Romance"));

        LibraryMenu libraryMenu = new LibraryMenu();
        libraryMenu.Menu();
    }
}