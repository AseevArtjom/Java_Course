package main;

import model.Human;

public class Main {
    public static void main(String[] args) {
        Human human = new Human();
        human.InputData();
        human.printData();
        System.out.println(human.getFio());
    }
}