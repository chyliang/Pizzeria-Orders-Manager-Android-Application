package com.example.projectfive;

import java.util.ArrayList;

/**
 * A method implements the order object that contains a
 * list of pizzas, the phone number, and check if it was placed or not.
 *
 * @author Chengyu Liang, Xinyu Meng
 */
public class Order {

    final double rate = 0.06625;
    final int firstcase = 1, zerocase = 0;
    private String phonenumber;
    private ArrayList<Pizza> pizzalist;
    private boolean placed;

    /**
     * The constructor of order that sets the phone number of the object.
     *
     * @param phonenumber The phone number for this order.
     */
    public Order(String phonenumber) {
        this.pizzalist = new ArrayList<>();
        this.phonenumber = phonenumber;
        this.placed = false;
    }

    /**
     * The getter method for the phone number of this order.
     *
     * @return Returns the phone number of this order.
     */
    public String getphonenumber() {
        return this.phonenumber;
    }

    /**
     * A method add a pizza to the pizza list.
     *
     * @param pizza The pizza to be added.
     */
    public void add(Pizza pizza) {
        pizzalist.add(pizza);
    }

    /**
     * The getter method for the pizza list of this order.
     *
     * @return Return the pizza list of this order.
     */
    public ArrayList<Pizza> getPizzalist() {
        return this.pizzalist;
    }

    /**
     * A setter method that sets the placed status to the order.
     *
     * @param ifplaced A boolean value to be setted to the placed status.
     */
    public void setplaced(boolean ifplaced) {
        this.placed = ifplaced;
    }

    /**
     * A getter method for getting the subtotal of pizzas in the order.
     *
     * @return
     */
    public double gettotal() {
        double price = zerocase;
        for (int i = zerocase; i < this.pizzalist.size(); i++) {
            price += this.pizzalist.get(i).price();
        }
        price *= firstcase + rate;
        return price;
    }

    /**
     * The getter method for the placed status of this order.
     *
     * @return Return the placed status of this order.
     */
    public boolean getplaced() {
        return this.placed;
    }
}
