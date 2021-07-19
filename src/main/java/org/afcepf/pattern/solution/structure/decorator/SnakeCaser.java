package org.afcepf.pattern.solution.structure.decorator;

public class SnakeCaser extends StringLoaderDecorator implements StringTransformer {

    public SnakeCaser(StringTransformer stringTransformer) {
        super(stringTransformer);
    }

    @Override
    public String transform() {
        String previous = decorated.transform();
        return previous.replace(' ', '-');
    }
}
