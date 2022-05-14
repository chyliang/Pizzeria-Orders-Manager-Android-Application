package com.example.projectfive;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

/**
 * The class to execute the ordering page and go to all other activities.
 *
 * @author Chengyu Liang, Xinyu Meng
 */
public class MainActivity extends AppCompatActivity {
    private Button deluxe_button, hawaiian_button, pepperoni_button, callcurrent, callstored;
    private int deluxe = 1, hawaiian = 2, pepperoni = 3;
    private static String number;
    private static StoreOrders list = new StoreOrders();

    private TextView phonenumber;

    /**
     * Oncreate method to set up the elements and the onclick methods.
     *
     * @param savedInstanceState a parameter required for the oncreate method.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_view);
        deluxe_button = findViewById(R.id.thedeluxe);
        phonenumber = findViewById(R.id.phonenumber);
        deluxe_button.setOnClickListener(new View.OnClickListener() {
            /**
             * click listener for pressing the deluxe button.
             * @param v a parameter required for the onclick method.
             */
            @Override
            public void onClick(View v) {
                if (checknumber()) {
                    number = phonenumber.getText().toString();
                    list.add(new Order(number));
                    deluxe();
                }
            }
        });
        hawaiian_button = findViewById(R.id.thehawaiian);
        hawaiian_button.setOnClickListener(new View.OnClickListener() {
            /**
             * click listener for pressing the hawaiian button.
             * @param v a parameter required for the onclick method.
             */
            @Override
            public void onClick(View v) {
                if (checknumber()) {
                    number = phonenumber.getText().toString();
                    list.add(new Order(number));
                    hawaiian();
                }
            }
        });
        pepperoni_button = findViewById(R.id.thepepperoni);
        pepperoni_button.setOnClickListener(new View.OnClickListener() {
            /**
             * click listener for pressing the pepperoni button.
             * @param v a parameter required for the onclick method.
             */
            @Override
            public void onClick(View v) {
                if (checknumber()) {
                    number = phonenumber.getText().toString();
                    list.add(new Order(number));
                    pepperoni();
                }
            }
        });
        callcurrent = findViewById(R.id.callcurrent);
        callcurrent.setOnClickListener(new View.OnClickListener() {
            /**
             * click listener for pressing the current order button to check the current orders and place orders.
             * @param v a parameter required for the onclick method.
             */
            @Override
            public void onClick(View v) {
                if (checknumber()) {
                    tocurrent();
                }
            }
        });
        callstored = findViewById(R.id.callstored);
        callstored.setOnClickListener(new View.OnClickListener() {
            /**
             * click listener for pressing the stored orders button.
             * @param v a parameter required for the onclick method.
             */
            @Override
            public void onClick(View v) {
                tostroed();
            }
        });
    }

    /**
     * The method to go to the stored orders page.
     */
    public void tostroed() {
        Intent intent = new Intent(this, StoredActivity.class);
        startActivity(intent);
    }

    /**
     * The method to go to the current orders page.
     */
    public void tocurrent() {
        try {
            list.getplaced(number);
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Order doesn't exist.", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, CurrentActivity.class);
        intent.putExtra("Number", phonenumber.getText().toString());
        startActivity(intent);
    }

    /**
     * The method to go to the deluxe customization page.
     */
    public void deluxe() {
        Intent intent = new Intent(this, CusActivity.class);
        intent.putExtra("Category", deluxe);
        intent.putExtra("number", number);
        startActivity(intent);
    }

    /**
     * The method to go to the hawaiian customization page.
     */
    public void hawaiian() {
        Intent intent = new Intent(this, CusActivity.class);
        intent.putExtra("Category", hawaiian);
        intent.putExtra("number", number);
        startActivity(intent);
    }

    /**
     * The method to go to the pepperoni customization page.
     */
    public void pepperoni() {
        Intent intent = new Intent(this, CusActivity.class);
        intent.putExtra("Category", pepperoni);
        intent.putExtra("number", number);
        startActivity(intent);
    }

    /**
     * The method to get the stored orders list.
     */
    public static StoreOrders getstoreorders() {
        return list;
    }

    /**
     * The method to check the input phone number.
     */
    public boolean checknumber() {
        try {
            Integer.parseInt(String.valueOf(phonenumber.getText()));
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "phone number has to be 10 digits.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (phonenumber.getText().length() != 10) {
            Toast.makeText(MainActivity.this, "phone number has to be 10 digits.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    /**
     * The getter method to get the input phone number.
     *
     * @return the phone number.
     */
    public static String getnumber() {
        return number;
    }


}