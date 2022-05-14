package com.example.projectfive;

import java.util.ArrayList;

/**
 * A class implements the store orders that has contains a list of orders.
 *
 * @author Chengyu Liang, Xinyu Meng
 */
public class StoreOrders {
    final int zerocase = 0, negativecase = -1;
    private ArrayList<Order> orderlist;

    /**
     * The constructor method that creates a new Array list for the order list.
     */
    public StoreOrders() {
        this.orderlist = new ArrayList<>();

    }

    /**
     * A method that finds an order based on the given phone number.
     *
     * @param phonenumber The phone number of the order to be found.
     * @return The index of the order in the order list, -1 if not found.
     */
    private int find(String phonenumber) {
        for (int i = zerocase; i < orderlist.size(); i++) {
            if (this.orderlist.get(i).getphonenumber().equals(phonenumber)) {
                return i;
            }
        }
        return negativecase;
    }

    /**
     * A method adding a order to the order list.
     *
     * @param order The order to be added.
     */
    public void add(Order order) {
        if (find(order.getphonenumber()) == negativecase) {
            orderlist.add(order);
        }
    }

    /**
     * A method adding a pizza to the order based on the given phone number.
     *
     * @param number The number of the order to be added.
     * @param pizza  The pizza to be added to the order.
     */
    public void addpizza(String number, Pizza pizza) {
        orderlist.get(find(number)).add(pizza);
    }

    /**
     * A getter method for the pizza list of the order with given phone number.
     *
     * @param number The phone number of the order.
     * @return The pizza list of the order.
     */
    public ArrayList<Pizza> getpizzalist(String number) {
        return this.orderlist.get(this.find(number)).getPizzalist();
    }

    /**
     * The setter method for setting the placed status based on the given phone number.
     *
     * @param number The number of the order to be setted.
     * @param placed The status to be setted.
     */
    public void setplaced(String number, boolean placed) {
        this.orderlist.get(this.find(number)).setplaced(placed);
    }

    /**
     * A getter method for the order list of this store order.
     *
     * @return Return the order list of this store order.
     */
    public ArrayList<Order> getOrderlist() {
        return this.orderlist;
    }

    /**
     * The getter method for the placed status of the order with the given phone number.
     *
     * @param number The phone number of the order.
     * @return Return the placed status of the order.
     */
    public boolean getplaced(String number) {
        return this.orderlist.get(find(number)).getplaced();
    }

}
