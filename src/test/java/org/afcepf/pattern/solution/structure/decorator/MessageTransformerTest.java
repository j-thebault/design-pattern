package org.afcepf.pattern.solution.structure.decorator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Le pattern decorator permet de créer des objects qui enchainent les operations les unes derrière les autres.
 * En cela il ressemble un peu au pattern chaine de responsabilité avec néanmoins des différences majeures :
 *  - Dans le Décorateur l'enchaînement des opérations ne peut être stoppé, alors que chaine de responsabilité peut interrompre l'enchaînement, sans même jeter d'exception.
 *  - Le décorateur étend les opérations de l'objet de base (et peut en ajouter), alors que la chaine de responsabilité peut lancer des operations arbitraires qui n'ont pas grand chose à voir avec les méthodes du message de base.
 *
 *  Cas typique d'utilisation de l'un ou l'autre :
 *  - Décorateur : Transformation de flux...
 *  - ChainOfResponsibility : contrôles successifs (Voir les RequestFilters/ Interceptors de SpringMVC par exemple), traitement d'évenement sur des composants imbriqués (GUI)
 */
class MessageTransformerTest {

    @Test
    void upperCaseAndTrimAndSnake() {
        // Constructeurs imbriqués en poupées russes
        StringTransformer transformer =
                new SnakeCaser(
                        new Trimer(
                                new UpperCaser(
                                        // Le StringLoader est un initiateur, qui permet d'initier la chaine de decorateur
                                        new StringLoader(" Hello world "))));
        String result = transformer.transform();
        Assertions.assertEquals("HELLO-WORLD", result);
    }

    @Test
    void lowerCaseAndTrimAndSnake() {
        StringTransformer transformer =
                new SnakeCaser(
                        new Trimer(
                                new LowerCaser(
                                        new StringLoader(" Hello world "))));
        String result = transformer.transform();
        Assertions.assertEquals("hello-world", result);
    }

    @Test
    void upperCaseAndAddSpaceAndSnake() {
        StringTransformer transformer =
                new Spacer(
                        new SnakeCaser(
                                new UpperCaser(
                                        new StringLoader(" Hello world "))));
        String result = transformer.transform();
        Assertions.assertEquals("  HELLO-WORLD  ", result);
    }

    @Test
    void lowerCaseAndTrimAndUnderscore() {
        StringTransformer transformer =
                new UnderCaser(
                        new Trimer(
                                new LowerCaser(
                                        new StringLoader(" Hello world "))));
        String result = transformer.transform();
        Assertions.assertEquals("hello_world", result);
    }
}
