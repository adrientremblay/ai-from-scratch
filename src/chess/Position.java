package chess;

public class Position {
    public int row;
    public int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Position))
            return super.equals(obj);

        Position p = (Position) obj;
        return this.row == p.row && this.col == p.col;
    }
}
