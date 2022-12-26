package chess;

public enum Piece {
    BLACK_PAWN(Player.BLACK, Type.PAWN),
    BLACK_ROOK(Player.BLACK, Type.ROOK),
    BLACK_KNIGHT(Player.BLACK, Type.KNIGHT),
    BLACK_BISHOP(Player.BLACK, Type.BISHOP),
    BLACK_KING(Player.BLACK, Type.KING),
    BLACK_QUEEN(Player.BLACK, Type.QUEEN),
    WHITE_PAWN(Player.WHITE, Type.PAWN),
    WHITE_ROOK(Player.WHITE, Type.ROOK),
    WHITE_KNIGHT(Player.WHITE, Type.KNIGHT),
    WHITE_BISHOP(Player.WHITE, Type.BISHOP),
    WHITE_KING(Player.WHITE, Type.KING),
    WHITE_QUEEN(Player.WHITE, Type.QUEEN);

    private Player player;
    private Type type;

    private Piece(Player player, Type type) {
        this.player = player;
        this.type = type;
    }

    @Override
    public String toString() {
        return type.toString();
    }

    public Player getPlayer() {
        return player;
    }
}
