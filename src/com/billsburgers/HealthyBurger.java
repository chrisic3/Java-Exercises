package com.billsburgers;

public class HealthyBurger extends Burger{
    private String addition5;
    private double addition5Price;

    private String addition6;
    private double addition6Price;

    public HealthyBurger(String meat, double basePrice) {
        super("Brown Rye", meat, basePrice);
    }

    public void addAdditional5(String addition5, double addition5Price) {
        this.addition5 = addition5;
        this.addition5Price = addition5Price;
    }

    public void addAdditional6(String addition6, double addition6Price) {
        this.addition6 = addition6;
        this.addition6Price = addition6Price;
    }

    @Override
    public double getTotal() {
        double total = super.getTotal();

        if (addition5 != null) {
            total += addition5Price;
            System.out.println(addition5 + " is $" + addition5Price);
        }

        if (addition6 != null) {
            total += addition6Price;
            System.out.println(addition6 + " is $" + addition6Price);
        }

        return total;
    }
}
