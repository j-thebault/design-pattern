package org.afcepf.pattern.training.creation.factory;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    @Test
    void getPoints() {
        Piece queen = new Piece("queen");
        Piece tower = new Piece("tower");
        assertEquals(15, queen.getPoints() + tower.getPoints());
    }

//    @Test
//    void getCardinality() {
//        Piece queen = new Piece("queen");
//        Piece tower = new Piece("tower");
//        Piece king = new Piece("king");
//        assertEquals(1, queen.getCardinality());
//        assertEquals(2, tower.getCardinality());
//        assertEquals(1, king.getCardinality());
//    }

    @Test
    void looseGameIfKingTake() {
        Piece king = new Piece("king");
        assertTrue(king.looseGameIfTake());
    }

    @Test
    void dontLooseGameIfNonKingPieceTake() {
        Piece queen = new Piece("queen");
        assertFalse(queen.looseGameIfTake());
    }
}
