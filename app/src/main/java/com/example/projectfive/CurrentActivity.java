package com.example.projectfive;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * The class implements current order activity that shows the added pizza and prices.
 *
 * @author Chengyu Liang, Xinyu Meng
 */
public class CurrentActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private int zerocase = 0;
    private double rate = 0.06625;
    private TextView number_c, subtotal_c, total_c, tax_c;
    private ArrayList<String> pizzalist = new ArrayList<String>();
    private ListView list_c;
    private Button removepizza, add_c;
    private int index = 0;

    /**
     * OnCreate method that set up all the elements when the activity is poped by the main activity.
     *
     * @param savedInstanceState A parameter required for the onCreate method for an activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_view);
        number_c = findViewById(R.id.number_c);
        subtotal_c = findViewById(R.id.subtotal_c);
        total_c = findViewById(R.id.total_c);
        tax_c = findViewById(R.id.tax_c);
        list_c = findViewById(R.id.list_c);
        Intent intent = getIntent();
        String number = intent.getStringExtra("Number");
        number_c.setText(number);

        double price = zerocase;
        for (int i = zerocase; i < MainActivity.getstoreorders().getpizzalist(number).size(); i++) {
            price += MainActivity.getstoreorders().getpizzalist(number).get(i).price();
            pizzalist.add(MainActivity.getstoreorders().getpizzalist(number).get(i).toString());
        }
        display(pizzalist, price);

        list_c.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                index = position;
            }
        });

        add_c = findViewById(R.id.add_c);
        add_c.setOnClickListener(new View.OnClickListener() {
            /**
             * Onclick event for the add button.
             * @param v The view containing the button.
             */
            @Override
            public void onClick(View v) {
                if (MainActivity.getstoreorders().getplaced(number)) {
                    showtoast("Order has been placed already.");
                    return;
                }
                MainActivity.getstoreorders().setplaced(number, true);
                showtoast("Order placed.");
                display(new ArrayList<String>(), 0);
                number_c.setText("");
            }
        });
        removepizza = findViewById(R.id.removepizza);
        removepizza.setOnClickListener(new View.OnClickListener() {
            /**
             * Onclick event for the remove button.
             * @param v The view containing the button.
             */
            @Override
            public void onClick(View v) {
                double price = 0;
                ArrayList<String> pizzalisttwo = new ArrayList<String>();
                MainActivity.getstoreorders().getpizzalist(MainActivity.getnumber()).remove(index);
                for (int i = zerocase; i < MainActivity.getstoreorders().getpizzalist(number).size(); i++) {
                    price += MainActivity.getstoreorders().getpizzalist(number).get(i).price();
                    pizzalisttwo.add(MainActivity.getstoreorders().getpizzalist(number).get(i).toString());
                }
                display(pizzalisttwo, price);
                showtoast("pizza removed.");
            }
        });

    }

    /**
     * \
     * The method that display the elements of a pizza.
     *
     * @param list  An arraylist of string for the adapter of listview.
     * @param price The price of the pizza in the order.
     */
    void display(ArrayList<String> list, double price) {
        subtotal_c.setText(CusActivity.formating(price));
        tax_c.setText(CusActivity.formating(price * rate));
        total_c.setText(CusActivity.formating(price + price * rate));
        ArrayAdapter<String> thelist = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        list_c.setAdapter(thelist);
    }

    /**
     * The method for onItemClick event for the list view.
     *
     * @param parent   Variable for onClick event method.
     * @param view     The view containing the event.
     * @param position The position of the clicked item.
     * @param id       The id of the clicked item.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    /**
     * A method for showing a taast message.
     *
     * @param content The content to be showed.
     */
    public void showtoast(String content) {
        Toast.makeText(CurrentActivity.this, content, Toast.LENGTH_SHORT).show();
    }


}