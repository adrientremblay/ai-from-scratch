package chess;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MovesGenerator {
    private Piece[][] board;

    public MovesGenerator(Piece[][] board) {
        this.board = board;
    }

    public ArrayList<Position> findMoves(Piece p, int row, int col) {
        switch (p.getType()) {
            case PAWN -> {
                return findMovesPawn(p, row, col);
            }
        }

        return null;
    }

    private ArrayList<Position> findMovesPawn(Piece piece, int row, int col) {
        ArrayList<Position> ret = new ArrayList<Position>();

        if (piece.getPlayer() == Player.WHITE) {
            // move up 1
            if (row != 0 &&  board[row - 1][col] == null)
                ret.add(new Position(row - 1, col));
            // move up 2
            if (row == 6 &&  board[4][col] == null)
                ret.add(new Position(4, col));
            // eat right
            if (row > 0 && col < 7 && board[row-1][col+1] != null && board[row-1][col+1].getPlayer() == Player.BLACK)
                ret.add(new Position(row-1, col+1));
            // eat left
            if (row > 0 && col > 0 && board[row-1][col-1] != null && board[row-1][col-1].getPlayer() == Player.BLACK)
                ret.add(new Position(row-1, col-1));
        } else {
            // move down 1
            if (row != 7 &&  board[row+1][col] == null)
                ret.add(new Position(row+1, col));
            // move down 2
            if (row == 1 &&  board[3][col] == null)
                ret.add(new Position(3, col));
            // eat right
            if (row < 7 && col < 7 && board[row+1][col+1] != null && board[row+1][col+1].getPlayer() == Player.WHITE)
                ret.add(new Position(row+1, col+1));
            // eat left
            if (row < 7 && col > 0 && board[row+1][col-1] != null && board[row+1][col-1].getPlayer() == Player.WHITE)
                ret.add(new Position(row+1, col-1));
        }

        return ret;
    }
}
