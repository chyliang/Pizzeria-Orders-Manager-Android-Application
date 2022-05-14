package com.example.projectfive;

/**
 * The class implements the Deluxe flavour under pizza.
 *
 * @author Chengyu Liang, Xinyu Meng
 */
public class Deluxe extends Pizza {

    final double small = 12.99, medium = 14.99, large = 16.99, topprice = 1.49;
    final int top = 5;

    /**
     * The method calculate the price of the deluxe pizza based on the size and number of toppings.
     *
     * @return A double of the price of the deluxe pizza.
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
