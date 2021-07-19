package org.afcepf.pattern.solution.structure.decorator;

public class StringLoader implements StringTransformer {

    private final String str;

    public StringLoader(String str) {
        this.str = str;
    }

    @Override
    public String transform() {
        return str;
    }
}
