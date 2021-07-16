package org.afcepf.pattern.solution.behavior.strategy;

import static org.afcepf.pattern.solution.behavior.strategy.Animal.MoveModes.RUN;

// Toute la complexité des if imbriqués est passé dans le polymorphisme.
// Notez que de façon générale les Design Pattern du GOF cherchent à :
//  - Découpler les classes avec des interfaces entre elles
//  - Minimiser la complexité cyclomatique (Aka nombre de if/switch)
//  - Limiter la taille et le role de chaque objet. Ce qui permet de tester plus facilement et unitairement, de limiter les effets de bords...
//
// Au niveau micro, un programme bien conçu dans un language orienté objet a tendance :
//  - à avoir énormément de petites classes bien testées et spécialisées
//  - à avoir beaucoup de petits packages et à jouer avec les visibilités des méthodes si besoin (visibilité des constructeurs...)
//  - à avoir une complexité architecturalle apparente mais une grande simplicité/lisibilité du code concret...
public class Animal {

    private MoveMode mode = RUN;

    private int distance = 0;

    void move() {
        mode.move(this);
    }

    public void changeMoveMode(MoveMode moveMode) {
        this.mode = moveMode;
    }

    public int getDistance() {
        return distance;
    }


    // Ici j'ai choisi d'utiliser une enum pour mes strategies, ce qui n'est pas le pattern "canon"
    // Mais java permet ce genre de chose et c'est pratique surtout pour des strategies simples. Ca evite d'instancier des petits objets en pagaille.
    // Par ailleurs, utiliser des classes internes pour des strategies qui doivent modifier l'état de l'objet permet de ne pas rompre l'encapsulation
    // Ce n'est pas un pattern strategy "canon" mais c'est intéressant à voir.
    public enum MoveModes implements MoveMode {
        RUN() {
            @Override
            public void move(Animal animal) {
                animal.distance += 10;
            }
        },
        SWIM() {
            @Override
            public void move(Animal animal) {
                animal.distance += 2;
            }
        },
        FLY() {
            @Override
            public void move(Animal animal) {
                animal.distance += 20;
            }
        },
        WALK() {
            @Override
            public void move(Animal animal) {
                animal.distance += 5;
            }
        },
        STAND() {
            @Override
            public void move(Animal animal) {
                // NOOP
            }
        },

    }
}
