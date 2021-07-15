package org.afcepf.pattern.solution.creation.factory;

/*
 * Refactorer ce code avec
 *  - Du polymorphisme
 *  - Un pattern factory
 */
abstract class Piece {

    abstract int getPoints();

    boolean looseGameIfTake(){
        return false;
    }
}
