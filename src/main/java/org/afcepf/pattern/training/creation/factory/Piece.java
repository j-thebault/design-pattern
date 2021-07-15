package org.afcepf.pattern.training.creation.factory;

/*
 * Refactorer ce code avec
 *  - Du polymorphisme
 *  - Un pattern factory
 */
class Piece {

    private final String type;

    Piece(String type) {
        this.type = type;
    }

    int getPoints(){
        switch (type){
            case "tower":
                return 5;
            case "queen":
                return 10;
            default:
                throw new IllegalArgumentException("unknown type");
        }
    }

    boolean looseGameIfTake(){
        return type.equals("king");
    }
}
