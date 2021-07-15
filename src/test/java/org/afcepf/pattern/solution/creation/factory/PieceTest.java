package org.afcepf.pattern.solution.creation.factory;

import org.junit.jupiter.api.Test;

import static org.afcepf.pattern.solution.creation.factory.PieceType.*;
import static org.junit.jupiter.api.Assertions.*;

class PieceTest {
    @Test
    void getPoints() {
        Piece tower = PieceFactory.create(TOWER);
        Piece queen = PieceFactory.create(QUEEN);
        assertEquals(15, queen.getPoints() + tower.getPoints());
    }

//    @Test
//    void getCardinality() {
//        Piece tower = PieceFactory.create(TOWER);
//        Piece queen = PieceFactory.create(QUEEN);
//        Piece king = PieceFactory.create(KING);
//        assertEquals(1, queen.getCardinality());
//        assertEquals(2, tower.getCardinality());
//        assertEquals(1, king.getCardinality());
//    }

    @Test
    void looseGameIfKingTake() {
        Piece king = PieceFactory.create(KING);
        assertTrue(king.looseGameIfTake());
    }

    @Test
    void dontLooseGameIfNonKingPieceTake() {
        Piece queen = PieceFactory.create(QUEEN);
        assertFalse(queen.looseGameIfTake());
    }
}
