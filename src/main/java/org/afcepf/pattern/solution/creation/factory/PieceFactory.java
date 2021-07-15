package org.afcepf.pattern.solution.creation.factory;

public class PieceFactory {
    public static Piece create(PieceType pieceType) {
        return pieceType.buildPiece();
    }
}
