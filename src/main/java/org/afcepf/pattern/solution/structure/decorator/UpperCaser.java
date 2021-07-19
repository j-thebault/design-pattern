package org.afcepf.pattern.solution.structure.decorator;

public class UpperCaser extends StringLoaderDecorator implements StringTransformer {

    public UpperCaser(StringTransformer stringTransformer) {
        super(stringTransformer);
    }

    @Override
    public String transform() {
        String previous = decorated.transform();
        return previous.toUpperCase();
    }
}
