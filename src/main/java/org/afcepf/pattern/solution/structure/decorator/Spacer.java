package org.afcepf.pattern.solution.structure.decorator;

public class Spacer extends StringLoaderDecorator implements StringTransformer {

    public Spacer(StringTransformer stringTransformer) {
        super(stringTransformer);
    }

    @Override
    public String transform() {
        String previous = decorated.transform();
        previous = " " + previous + " ";
        return previous;
    }
}
