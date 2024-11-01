package model.Genre;

import java.util.ArrayList;
import java.util.List;

public class GenreCollection {
    private static GenreCollection instance;
    private final List<Genre> genres;

    private GenreCollection(){
        genres = new ArrayList<>();
    }

    public static GenreCollection getInstance(){
        if(instance == null){
            instance = new GenreCollection();
        }
        return instance;
    }

    public void addGenre(Genre genre) {
        if (!genres.contains(genre)) {
            genres.add(genre);
        }
    }
    public void removeGenre(Genre genre){
        genres.remove(genre);
    }
    public Genre findGenreByName(String name){
        for (Genre genre : genres){
            if(genre.getName().equalsIgnoreCase(name)){
                return genre;
            }
        }
        return null;
    }

    public List<Genre> getGenres(){
        return genres;
    }

}
