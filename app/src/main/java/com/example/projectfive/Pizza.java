package com.example.projectfive;

import java.util.ArrayList;

/**
 * The class that implements the pizza object with a list of toppings and size.
 *
 * @author Chengyu Liang, Xinyu Meng
 */
public abstract class Pizza {
    final int zerocase = 0;
    protected ArrayList<Topping> toppings = new ArrayList<Topping>();
    protected Size size;

    /**
     * An abstract method for calculating the price of the pizza.
     *
     * @return Return the prices based on the flavour in the subclasses.
     */
    public abstract double price();

    /**
     * A method to get the String form of this pizza.
     *
     * @return Return the string of this pizza containing all the toppings, size, and the price.
     */
    @Override
    public String toString() {
        String result = new String();
        for (int i = zerocase; i < this.toppings.size(); i++) {
            result += this.toppings.get(i) + ",";
        }
        result += this.size.toString() + "," + Double.toString(this.price());
        return result;
    }
}
