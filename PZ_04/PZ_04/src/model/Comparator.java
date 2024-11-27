package model;

import java.util.ArrayList;

import static model.PlayRoom.*;

public class Comparator
{
    public static void main(String[] args) {
        PlayRoom.main(new String[0]);
        System.out.println("Disks :");
        for (Game.GameDisk disk : GameDisks) {
            System.out.println(disk.getGame().getName() + " - " + disk.getGame().getGenre());
        }
        System.out.println("_".repeat(40));
        ArrayList<Game.GameDisk> filteredGameDisks = new ArrayList<>(GameDisks);
        filteredGameDisks.sort((disk1, disk2) -> disk1.getGame().getGenre().compareTo(disk2.getGame().getGenre()));
        System.out.println("Sorted disks :");
        for (Game.GameDisk disk : filteredGameDisks) {
            System.out.println(disk.getGame().getName() + " - " + disk.getGame().getGenre());
        }

        System.out.println("_".repeat(40));

        System.out.println("Virtual games :");
        for (Game.VirtualGame virtualGame : VirtualGames) {
            System.out.println(virtualGame.getGame().getName() + " - " + virtualGame.getRating());
        }
        System.out.println("_".repeat(40));
        ArrayList<Game.VirtualGame> filteredVirtualGames = new ArrayList<>(VirtualGames);
        filteredVirtualGames.sort((game1,game2) -> Integer.compare(game1.getRating(),game2.getRating()));
        System.out.println("Sorted virtual games by rating :");
        for (Game.VirtualGame virtualGame : filteredVirtualGames) {
            System.out.println(virtualGame.getGame().getName() + " - " + virtualGame.getRating());
        }
    }
}