package org.afcepf.pattern.solution.structure.decorator;

public abstract class StringLoaderDecorator implements StringTransformer {

    protected final StringTransformer decorated;

    public StringLoaderDecorator(StringTransformer decorated) {
        this.decorated = decorated;
    }

}
