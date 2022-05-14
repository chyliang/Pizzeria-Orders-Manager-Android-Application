package com.example.projectfive;

/**
 * The class implements the Hawaiian flavour under pizza.
 *
 * @author Chengyu Liang, Xinyu Meng
 */
public class Hawaiian extends Pizza {
    final double small = 10.99, medium = 12.99, large = 14.99, topprice = 1.49;
    final int top = 2;

    /**
     * The method calculate the price of the hawaiian pizza based on the size and number of toppings.
     *
     * @return A double of the price of the hawaiian pizza.
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
