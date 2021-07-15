package org.afcepf.pattern.solution.creation.factory;

import org.junit.jupiter.api.Test;

import static org.afcepf.pattern.solution.creation.factory.PieceType.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PieceFactoryTest {

    @Test
    public void shouldCreatePiece() {
        Piece tower = PieceFactory.create(TOWER);
        Piece queen = PieceFactory.create(QUEEN);
        Piece king = PieceFactory.create(KING);
        assertTrue(tower instanceof Tower);
        assertTrue(queen instanceof Queen);
        assertTrue(king instanceof King);
    }
}
