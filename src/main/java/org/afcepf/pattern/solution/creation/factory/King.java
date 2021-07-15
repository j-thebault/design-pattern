package org.afcepf.pattern.solution.creation.factory;

public class King extends Piece {

    @Override
    public int getPoints() {
        throw new PieceHasNoPointException();
    }

    @Override
    boolean looseGameIfTake() {
        return true;
    }
}
