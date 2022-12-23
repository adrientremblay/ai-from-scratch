package chess;

public enum Type {
    PAWN('P'),
    ROOK('R'),
    KNIGHT('H'),
    BISHOP('B'),
    KING('K'),
    QUEEN('Q');

    private char repr;

    private Type(char repr) {
        this.repr = repr;
    }

    @Override
    public String toString() {
        return String.valueOf(repr);
    }
}
