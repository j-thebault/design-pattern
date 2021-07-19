package org.afcepf.pattern.solution.structure.decorator;

public class UnderCaser extends StringLoaderDecorator implements StringTransformer {

    public UnderCaser(StringTransformer stringTransformer) {
        super(stringTransformer);
    }

    @Override
    public String transform() {
        String previous = decorated.transform();
        return previous.replace(' ', '_');
    }
}
