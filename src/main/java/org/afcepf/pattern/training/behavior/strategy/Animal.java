package org.afcepf.pattern.training.behavior.strategy;

/*
 * Exercice :
 *  1 - Ajouter un quatrième mode "WALK" qui ajoute 5 à la distance et mettre le test à jour.
 *    - Que pensez vous du code obtenu ? Que va t il se passer si on veux modifier ou ajouter encore des modes de déplacement ?
 *
 * 2 - Refactorer en pattern Strategy, fusionner les methode transformXX grace au typage fort
 *   - Ajouter un cinquième mode STAND qui ne change pas la distance. Comment se passe cet ajout par rapport à WALK ?
 *
 * contraintes :
 *  - Interdit d'ajouter un setter sur distance ou de changer le modificateur de visibilité.
 *
 *  Conseils :
 *  - C'est une variation du pattern Strategy car vos strategies vont devoir modifier l'Animal (aka sa distance). Dans le pattern
 *    classique la stratégie n'agit pas sur l'objet lui même mais sur l'extérieur.
 *  - Vous devrez utiliser des classes internes pour modifier votre attribut distance private sans rompre l'encapsulation.
 */
public class Animal {

    private String mode = "RUN";

    private int distance = 0;

    void move(){
        if(mode.equals("RUN")){
            distance = distance + 10;
        } else {
            if(mode.equals("FLY")){
                distance = distance + 20;
            } else {
                // should be mode SWIM
                // ¯\_(ツ)_/¯
                distance = distance + 2;
            }
        }
    }

    void transformIntoRunner(){
        this.mode = "RUN";
    }

    void transformIntoFlyer(){
        this.mode = "FLY";
    }

    void transformIntoSwimmer(){
        this.mode = "SWIM";
    }

    public int getDistance() {
        return distance;
    }
}
