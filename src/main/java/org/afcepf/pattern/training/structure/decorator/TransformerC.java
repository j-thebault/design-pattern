package org.afcepf.pattern.training.structure.decorator;

import java.util.Locale;

public class TransformerC implements StringTransformer {
    @Override
    public String transform(String str) {
        String result = str.toUpperCase(Locale.ROOT);
        result = result.replace(' ', '-');
        result = " " + result + " ";
        return result;
    }
}
