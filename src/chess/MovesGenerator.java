package chess;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MovesGenerator {
    private Piece[][] board;

    public MovesGenerator(Piece[][] board) {
        this.board = board;
    }

    public int[][] findMoves(Piece p, int row, int col) {
        ArrayList<int[]> ret = new ArrayList<int[]>();

        switch (p.getType()) {
            case PAWN -> ret = findMovesPawn(p, row, col);
        }

        return (int[][]) ret.toArray();
    }

    private ArrayList<int[]> findMovesPawn(Piece piece, int row, int col) {
        ArrayList<int[]> ret = new ArrayList<int[]>();

        if (piece.getPlayer() == Player.WHITE) {
            // move up 1
            if (row != 0 &&  board[row - 1][col] == null)
                ret.add(new int[] {row - 1, col});
            // move up 2
            if (row == 6 &&  board[4][col] == null)
                ret.add(new int[] {4, col});
            // eat right
            if (row > 0 || col < 7 && board[row-1][col+1] != null && board[row-1][col+1].getPlayer() == Player.BLACK)
                ret.add(new int[] {row-1, col+1});
            // eat left
            if (row > 0 || col > 0 && board[row-1][col-1] != null && board[row-1][col-1].getPlayer() == Player.BLACK)
                ret.add(new int[] {row-1, col-1});
        } else {
            // move down 1
            if (row != 7 &&  board[row+1][col] == null)
                ret.add(new int[] {row+1, col});
            // move down 2
            if (row == 1 &&  board[3][col] == null)
                ret.add(new int[] {3, col});
            // eat right
            if (row < 7 || col < 7 && board[row+1][col+1] != null && board[row+1][col+1].getPlayer() == Player.WHITE)
                ret.add(new int[] {row+1, col+1});
            // eat left
            if (row < 7 || col > 0 && board[row+1][col-1] != null && board[row+1][col-1].getPlayer() == Player.WHITE)
                ret.add(new int[] {row+1, col-1});
        }

        return ret;
    }
}
