package org.afcepf.pattern.solution.structure.decorator;

public class Trimer extends StringLoaderDecorator implements StringTransformer {

    public Trimer(StringTransformer stringTransformer) {
        super(stringTransformer);
    }

    @Override
    public String transform() {
        String previous = decorated.transform();
        return previous.trim();
    }
}
