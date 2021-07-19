package org.afcepf.pattern.training.structure.decorator;

/**
 * Observer le code des 4 transformers et refactorer à l'aide d'un pattern decorator. Assembler les combinaisons directement dans le test.
 *
 * NB: Le code est volontairement très simple et ne constituerait pas un cadre valide pour implémenter un pattern décorateur, les méthodes de la classe String suffisant amplement.
 * Mais ça permet de faire l'exercice avec du code simple, le pattern n'étant pas forcément évident à saisir la première fois...
 * Si vous êtes sur la bonne voie, votre code d'instanciation d'objet (dans le test du coup) va prendre une forme de poupée russe très caractéristique.
 */
public interface StringTransformer {
    String transform(String str);
}
