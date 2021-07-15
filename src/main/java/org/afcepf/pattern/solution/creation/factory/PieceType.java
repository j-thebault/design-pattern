package org.afcepf.pattern.solution.creation.factory;

public enum PieceType {
    TOWER() {
        @Override
        public Piece buildPiece() {
            return new Tower();
        }
    },
    QUEEN(){
        @Override
        public Piece buildPiece() {
            return new Queen();
        }
    },
    KING(){
        @Override
        public Piece buildPiece() {
            return new King();
        }
    };

    abstract public Piece buildPiece();
}
