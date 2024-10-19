package main;

import java.util.ArrayList;
import java.util.Random;

public class Task_11 {
    public static void main(String[] args) {
        drawLine(10, Direction.HORIZONTAL, '*');
        drawLine(5, Direction.VERTICAL, '#');
        drawLine(5, Direction.HORIZONTAL, '#');
    }
    enum Direction {
        HORIZONTAL,
        VERTICAL
    }
    public static void drawLine(int length, Direction direction, char symbol) {
        if (length <= 0) {
            System.out.println("Length must be > 0");
            return;
        }

        if (direction == Direction.HORIZONTAL) {
            for (int i = 0; i < length; i++) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        } else if (direction == Direction.VERTICAL) {
            for (int i = 0; i < length; i++) {
                System.out.println(symbol);
            }
        }
    }
}
