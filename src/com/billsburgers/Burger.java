package com.billsburgers;

public class Burger {
    private String rollType;
    private String meat;
    private double basePrice;
    private String addition1;
    private double addition1Price;
    private String addition2;
    private double addition2Price;
    private String addition3;
    private double addition3Price;
    private String addition4;
    private double addition4Price;

    public Burger(String rollType, String meat, double basePrice) {
        this.rollType = rollType;
        this.meat = meat;
        this.basePrice = basePrice;
    }

    public void addAdditional1(String addition1, double addition1Price) {
        this.addition1 = addition1;
        this.addition1Price = addition1Price;
    }

    public void addAdditional2(String addition2, double addition2Price) {
        this.addition2 = addition2;
        this.addition2Price = addition2Price;
    }

    public void addAdditional3(String addition3, double addition3Price) {
        this.addition3 = addition3;
        this.addition3Price = addition3Price;
    }

    public void addAdditional4(String addition4, double addition4Price) {
        this.addition4 = addition4;
        this.addition4Price = addition4Price;
    }

    public double getTotal() {
        double total = basePrice;

        System.out.println("Base burger is $" + basePrice);

        if (addition1 != null) {
            total += addition1Price;
            System.out.println(addition1 + " is $" + addition1Price);
        }

        if (addition2 != null) {
            total += addition2Price;
            System.out.println(addition2 + " is $" + addition2Price);
        }

        if (addition3 != null) {
            total += addition3Price;
            System.out.println(addition3 + " is $" + addition3Price);
        }

        if (addition4 != null) {
            total += addition4Price;
            System.out.println(addition4 + " is $" + addition4Price);
        }

        return total;
    }
}
