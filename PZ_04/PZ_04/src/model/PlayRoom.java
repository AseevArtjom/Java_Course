package model;

import java.io.NotActiveException;
import java.util.ArrayList;

public class PlayRoom {
    public static ArrayList<Game.GameDisk> GameDisks = new ArrayList<>();
    public static ArrayList<Game.VirtualGame> VirtualGames = new ArrayList<>();

    public static void main(String[] args) {
        GameDisks.add(Game.getDisk("Need for Speed", Game.Genre.RACE, "Race game"));
        GameDisks.add(Game.getDisk("NBA", Game.Genre.SPORT, "Sport game"));
        GameDisks.add(Game.getDisk("BattleField 1", Game.Genre.ACTION, "WWI"));
        GameDisks.add(Game.getDisk("Test_Game", Game.Genre.ADVENTURE, "Adventure game"));

        VirtualGames.add(Game.getVirtualGame("Test1", Game.Genre.SPORT));
        VirtualGames.add(Game.getVirtualGame("Test2", Game.Genre.ADVENTURE));
        VirtualGames.add(Game.getVirtualGame("Test3", Game.Genre.ACTION));
        VirtualGames.add(Game.getVirtualGame("Test4", Game.Genre.RACE));

        GameConsole gameConsole = new GameConsole(GameConsole.Brand.SONY, "X234FNAS-2DJKS");

        GameConsole.GamePad gamePad1 = gameConsole.getFirstGamepad();
        GameConsole.GamePad gamePad2 = gameConsole.getSecondGamepad();

        gamePad1.powerOn();

        gameConsole.loadGame(VirtualGames.get(1).getGame());

        gameConsole.playGame();

        gamePad1.powerOff();
        gamePad2.powerOn();

        gameConsole.playGame();
        gameConsole.playGame();
        gameConsole.playGame();
        gameConsole.playGame();
        gameConsole.playGame();
        gameConsole.playGame();
        gameConsole.playGame();
        gameConsole.playGame();
        gameConsole.playGame();
        gameConsole.playGame();
    }
}
