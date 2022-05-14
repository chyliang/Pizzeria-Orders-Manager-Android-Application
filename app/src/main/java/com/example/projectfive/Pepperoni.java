package com.example.projectfive;

/**
 * The class implements the Pepperoni flavour under pizza.
 *
 * @author Chengyu Liang, Xinyu Meng
 */
public class Pepperoni extends Pizza {
    final double small = 8.99, medium = 10.99, large = 12.99, topprice = 1.49;
    final int top = 1;

    /**
     * The method calculate the price of the pepperoni pizza based on the size and number of toppings.
     *
     * @return A double of the price of the pepperoni pizza.
     */
    @Override
    public double price() {
        double result;
        if (this.size == Size.small) {
            result = small;
        } else if (this.size == Size.medium) {
            result = medium;
        } else {
            result = large;
        }
        if (this.toppings.size() <= top) {
            return result;
        } else {
            result += (this.toppings.size() - top) * topprice;
            return Double.parseDouble(CusActivity.formating(result));
        }
    }
}
