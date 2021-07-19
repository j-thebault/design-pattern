package org.afcepf.pattern.solution.behavior.command;

// LEs cooks occupent le statut de receveur des commandes puisqu'elles font la boulot effectif
public interface Cook {
    void prepareEntree();
    void prepareSoup();
}
