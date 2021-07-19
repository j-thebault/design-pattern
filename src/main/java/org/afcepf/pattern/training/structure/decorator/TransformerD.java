package org.afcepf.pattern.training.structure.decorator;

import java.util.Locale;

public class TransformerD implements StringTransformer {
    @Override
    public String transform(String str) {
        String result = str.toLowerCase(Locale.ROOT);
        result = result.trim();
        result = result.replace(' ', '_');
        return result;
    }
}
