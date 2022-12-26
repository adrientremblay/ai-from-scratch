package chess;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MovesGenerator {
    private int[][] board;

    public int[][] findMoves(Piece p, int row, int col) {
        ArrayList<int[]> ret = new ArrayList<int[]>();

        switch (p.getType()) {
            case PAWN -> ret = findMovesPawn(p, row, col);
        }

        return (int[][]) ret.toArray();
    }

    private ArrayList<int[]> findMovesPawn(Piece p, int row, int col) {
        ArrayList<int[]> ret = new ArrayList<int[]>();
        return ret;
    }
}
