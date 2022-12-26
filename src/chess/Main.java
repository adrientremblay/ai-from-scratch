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
                System.err.println("NOT A VALID MOVE!");
                continue;
            }

            String[] source = stringSplit[0].split("");
            int sourceRow = board.length - Integer.valueOf(source[1]); // unchecked
            int sourceCol = source[0].charAt(0) - 'a'; // unchecked
            if (sourceRow < 0 || sourceRow > board.length - 1 || sourceCol < 0 || sourceCol > board.length - 1) {
                System.err.println("NOT A VALID MOVE!");
                continue;
            }
            Piece sourcePiece = board[sourceRow][sourceCol];

            String[] dest = stringSplit[1].split("");
            int destRow = board.length - Integer.valueOf(dest[1]); // unchecked
            int destCol = dest[0].charAt(0) - 'a'; // unchecked
            if (destRow < 0 || destRow > board.length - 1 || destCol < 0 || destCol > board.length - 1) {
                System.err.println("NOT A VALID MOVE!");
                continue;
            }
            Piece destPiece = board[destRow][destCol];

            board[sourceRow][sourceCol] = null;
            board[destRow][destCol] = sourcePiece;
        }
    }

    private static void printBoard(Piece[][] board) {
        for (int row  = 0 ; row < board.length ; row++) {
            System.out.print((board.length - row) + " | ");
            for (int col = 0 ; col < board[row].length ; col++)
                if (board[row][col] == null)
                    System.out.print(". ");
                else
                    System.out.print((board[row][col].getPlayer() == Player.WHITE ? "\u001B[47m" : "\u001B[40m" ) + board[row][col].toString() + "\u001B[0m" + " ");
            System.out.println();
        }
        System.out.println("--------------------");
        System.out.println("    a b c d e f g h");
    }
}