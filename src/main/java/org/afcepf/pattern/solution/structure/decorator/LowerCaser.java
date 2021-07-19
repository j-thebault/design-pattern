package org.afcepf.pattern.solution.structure.decorator;

public class LowerCaser extends StringLoaderDecorator implements StringTransformer {

    public LowerCaser(StringTransformer stringTransformer) {
        super(stringTransformer);
    }

    @Override
    public String transform() {
        String previous = decorated.transform();
        return previous.toLowerCase();
    }
}
