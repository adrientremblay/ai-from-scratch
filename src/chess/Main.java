package chess;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // setting up default board
        Piece[][] board = {
                {Piece.BLACK_ROOK, Piece.BLACK_KNIGHT, Piece.BLACK_BISHOP, Piece.BLACK_QUEEN, Piece.BLACK_KING, Piece.BLACK_BISHOP, Piece.BLACK_KNIGHT, Piece.BLACK_ROOK},
                {Piece.BLACK_PAWN, Piece.BLACK_PAWN, Piece.BLACK_PAWN, Piece.BLACK_PAWN, Piece.BLACK_PAWN, Piece.BLACK_PAWN, Piece.BLACK_PAWN, Piece.BLACK_PAWN},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {Piece.WHITE_PAWN, Piece.WHITE_PAWN, Piece.WHITE_PAWN, Piece.WHITE_PAWN, Piece.WHITE_PAWN, Piece.WHITE_PAWN, Piece.WHITE_PAWN, Piece.WHITE_PAWN},
                {Piece.WHITE_ROOK, Piece.WHITE_KNIGHT, Piece.WHITE_BISHOP, Piece.WHITE_QUEEN, Piece.WHITE_KING, Piece.WHITE_BISHOP, Piece.WHITE_KNIGHT, Piece.WHITE_ROOK},
        };

        // main game loop
        Scanner s = new Scanner(System.in);
        while (true) {
            printBoard(board);

            System.out.println("PLAYER TURN:");
            System.out.println("What move do you want to do?");

            String input = s.nextLine();
            String[] stringSplit = input.split(" ");
            if (stringSplit.length != 2) {
                System.err.println("NO!");
                continue;
            }
        }
    }

    private static void printBoard(Piece[][] board) {
        for (int row  = 0 ; row < board.length ; row++) {
            System.out.print((board.length - row) + " | ");
            for (int col = 0 ; col < board[row].length ; col++)
                if (board[row][col] == null)
                    System.out.print(". ");
                else
                    System.out.print((board[row][col].getPlayer() == Player.WHITE ? "\u001B[40m" : "\u001B[47m" ) + board[row][col].toString() + "\u001B[0m" + " ");
            System.out.println();
        }
        System.out.println("--------------------");
        System.out.println("    a b c d e f g h");
    }
}