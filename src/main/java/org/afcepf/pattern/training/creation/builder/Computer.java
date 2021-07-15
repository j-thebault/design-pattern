package org.afcepf.pattern.training.creation.builder;

/*
 * Objectif :
 * - Apprendre le pattern Builder Fluent
 * - Sortir de l'anti pattern Anemic Domain avec des ValueObjects
 * - Savoir où placer son code et ses controles métiers sur un exemple simple (Expert en information du GRASP)
 * 
 * Exercice :
 * - Refactorer la creation d'instance de classe Computer au moyen d'un pattern Builder Fluent
 * - Implementer le métier suivant
 * - 	La propriété CPU ne peut prendre que trois valeurs possibles "Intel i7", "Apple M1", "AMD-3700X" et ne peut pas être nulle
 * - 	La propriété RAM ne peut prendre que des valeurs de puissance de 2 de 1Go à 1024Go (1,2,4,8...1024) et ne peut pas être nulle
 * -    La propriété OS ne peut prendre que 3 valeurs : "Windows", "Debian", "MacOS" et ne peut pas être nulle
 * -    La propriété OS ne peut prendre la valeur "MacOS" que si le processeur est de type "Apple M1"
 * -    La propriété OS ne peut prendre la valeur "Windows" ou "Debian" que si le processeur est de type "Intel i7" ou "AMD-3700X"
 * -    La propriété OS ne peut prendre la valeur "Windows" si la ram est de moins de 4 Go
 * 
 * - Les propriétés cpu, ram et os sont immutables et ne peuvent être modifiées après instanciation d'un objet de classe Computer (ie pas de setter)
 * 
 * Indices :
 * - Prendre 5-10 minutes pour un faire un "boitogramme" afin de trouver vos principales classes. Je conseille le papier/crayon, interdit de toucher à l'IDE ^^
 * - Commencez par le domaine métier lui même avant de faire le builder. Ca vous évitera de coller des règles métier dans le builder (Single Responsibility Principle)
 * - Spec précises -> TESTS UNITAIRES ! Il va falloir que vous écriviez les tests qui vont avec les règles métier ou que vous garantissiez par "construction" que votre domaine de valeur est respecté
 * - Jeter des exceptions si une règle métier est violée. Même un simple IllegalArgumentException avec un message explicite est préférable à l'instanciation d'un objet métier invalide.
 * - Pour chaque règle, essayer de trouver la bonne classe où vérifier la règle. Pour les règles simples c'est assez évident. Pour les règles complexes il n'y a pas toujours de solution unique...
 * - Ne pas permettre d'instancier un objet métier dans un état invalide.
 */
public class Computer {
	private String cpu;
	private int ram;
	private String os;

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

}
