package model;

public class Game {

    public enum Genre {
        ADVENTURE, ACTION, SPORT, RACE
    }

    public enum Type {
        VIRTUAL, PHYSICAL
    }

    private final String name;
    private final Genre genre;
    private final Type type;
    private Game(String name, Genre genre, Type type) {
        this.name = name;
        this.genre = genre;
        this.type = type;
    }

    public static GameDisk getDisk(String name, Genre genre, String description) {
        return new GameDisk(name, genre, description, "");
    }

    public static VirtualGame getVirtualGame(String name,Genre genre){
        return new VirtualGame(0,"",name,genre);
    }

    public String getName() {
        return name;
    }

    public Genre getGenre() {
        return genre;
    }

    public Type getType() {
        return type;
    }

    public static class GameDisk {
        private final String description;
        private final String gameData;
        private final Game game;

        private GameDisk(String name, Genre genre, String description, String gameData) {
            this.description = description;
            this.gameData = gameData;
            this.game = new Game(name, genre, Type.PHYSICAL);
        }

        public String getDescription() {
            return description;
        }

        public String getGameData() {
            return gameData;
        }

        public Game getGame() {
            return game;
        }
    }

    public static class VirtualGame {
        private int rating;
        private final String gameData;
        private final Game game;

        private VirtualGame(int rating, String gameData, String name, Genre genre) {
            this.gameData = gameData;
            setRating(rating);
            this.game = new Game(name, genre, Type.VIRTUAL);
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            if (rating >= 0 && rating <= 5) {
                this.rating = rating;
            }
        }

        public String getGameData() {
            return gameData;
        }

        public Game getGame() {
            return game;
        }
    }
}
