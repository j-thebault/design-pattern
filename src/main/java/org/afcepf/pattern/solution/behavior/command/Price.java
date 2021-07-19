package org.afcepf.pattern.solution.behavior.command;

public class Price {
    private final int price;

    public Price(int price) {
        if(price <= 0){
            throw new IllegalArgumentException("A price cannot be null or negative");
        }
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
