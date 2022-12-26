package chess;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        // main game loop
        Scanner s = new Scanner(System.in);
        while (true) {
            game.printBoard();
            game.playerTurn(s.nextLine());
        }
    }
}