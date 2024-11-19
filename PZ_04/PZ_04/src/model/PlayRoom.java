package model;

import java.util.ArrayList;

public class PlayRoom
{
    public static void main(String[] args) {
        ArrayList<Game.GameDisk> GameDisks = new ArrayList<>();
        GameDisks.add(Game.getDisk("Need for Speed", Game.Genre.RACE,"Race game"));
        GameDisks.add(Game.getDisk("NBA", Game.Genre.SPORT,"Sport game"));
        GameDisks.add(Game.getDisk("BattleField 1", Game.Genre.ACTION,"WWI"));
        GameDisks.add(Game.getDisk("Test_Game", Game.Genre.ADVENTURE,"Adventure game"));

        ArrayList<Game.VirtualGame> VirtualGames = new ArrayList<>();
        VirtualGames.add(Game.getVirtualGame("Test1", Game.Genre.SPORT));
        VirtualGames.add(Game.getVirtualGame("Test2", Game.Genre.ADVENTURE));
        VirtualGames.add(Game.getVirtualGame("Test3", Game.Genre.ACTION));
        VirtualGames.add(Game.getVirtualGame("Test4", Game.Genre.RACE));

        GameConsole gameConsole = new GameConsole(GameConsole.Brand.SONY,"X234FNAS-2DJKS");

    }
}
