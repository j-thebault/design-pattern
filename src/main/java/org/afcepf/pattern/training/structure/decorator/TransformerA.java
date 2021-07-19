package org.afcepf.pattern.training.structure.decorator;

import java.util.Locale;

public class TransformerA implements StringTransformer {
    @Override
    public String transform(String str) {
        String result = str.toUpperCase(Locale.ROOT);
        result = result.trim();
        result = result.replace(' ', '-');
        return result;
    }
}
