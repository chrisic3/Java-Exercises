package com.billsburgers;

public class DeluxeBurger extends Burger {
    public DeluxeBurger() {
        super("white", "beef", 6.99);
        super.addAdditional1("chips", 1.00);
        super.addAdditional2("drink", 1.00);
    }

    @Override
    public void addAdditional1(String addition1, double addition1Price) {
        System.out.println("Cannot add items to delux burger.");
    }

    @Override
    public void addAdditional2(String addition2, double addition2Price) {
        System.out.println("Cannot add items to delux burger.");
    }

    @Override
    public void addAdditional3(String addition3, double addition3Price) {
        System.out.println("Cannot add items to delux burger.");
    }

    @Override
    public void addAdditional4(String addition4, double addition4Price) {
        System.out.println("Cannot add items to delux burger.");
    }
}
