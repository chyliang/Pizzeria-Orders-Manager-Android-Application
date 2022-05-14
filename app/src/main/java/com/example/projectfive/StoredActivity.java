package com.example.projectfive;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * A class implements the stored orders activity popped from the main activity.
 *
 * @author Chengyu Liang, Xinyu Meng
 */
public class StoredActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    final int zerocase = 0;
    private ArrayList<String> orders = new ArrayList<String>();
    private TextView total_s;
    private Spinner spinnertwo;
    private ListView list_s;
    private Button cancel_s;

    /**
     * The onCreate method for the activity.
     *
     * @param savedInstanceState A parameter required for the onCreate method for an activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stored_view);
        total_s = findViewById(R.id.total_s);
        cancel_s = findViewById(R.id.cancel_s);
        if (MainActivity.getstoreorders().getOrderlist().size() == zerocase) {
            Toast.makeText(StoredActivity.this, "There are no order yet.", Toast.LENGTH_SHORT);
            return;
        }
        for (int i = zerocase; i < MainActivity.getstoreorders().getOrderlist().size(); i++) {
            if (MainActivity.getstoreorders().getOrderlist().get(i).getplaced()) {
                orders.add(MainActivity.getstoreorders().getOrderlist().get(i).getphonenumber());
            } else {
                MainActivity.getstoreorders().getOrderlist().remove(i);
            }
        }
        list_s = findViewById(R.id.list_s);
        spinnertwo = findViewById(R.id.spinnertwo);
        ArrayAdapter<String> spinnerlist = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, orders);
        spinnertwo.setAdapter(spinnerlist);
        spinnertwo.setOnItemSelectedListener(this);
        cancel_s.setOnClickListener(new View.OnClickListener() {
            /**
             * The onClick method for onclick listener.
             * @param v parameter for onclick method.
             */
            @Override
            public void onClick(View v) {
                cancelorder(spinnerlist);
            }
        });
    }

    /**
     * A method that cancels an order.
     *
     * @param The spinner object in the activity.
     */
    public void cancelorder(ArrayAdapter<String> spinnerlist) {
        Toast.makeText(StoredActivity.this, "Order canceled.", Toast.LENGTH_SHORT);
        for (int i = zerocase; i < MainActivity.getstoreorders().getOrderlist().size(); i++) {
            if (MainActivity.getstoreorders().getOrderlist().get(i).getphonenumber().equals(spinnertwo.getSelectedItem())) {
                spinnerlist.remove(MainActivity.getstoreorders().getOrderlist().get(i).getphonenumber());
                spinnertwo.setAdapter(spinnerlist);
                list_s.setAdapter(null);
                MainActivity.getstoreorders().getOrderlist().remove(i);
                if (spinnerlist.isEmpty()) {
                    total_s.setText("");
                }
                break;
            }
        }

    }

    /**
     * The event handler method for selection event of the spinner.
     *
     * @param parent   Parent of the selected item.
     * @param view     View of the selected item.
     * @param position Position of the selected item.
     * @param id       Id of the selected item.
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ArrayList<String> items = new ArrayList<String>();
        for (int i = zerocase; i < MainActivity.getstoreorders().getOrderlist().get(position).getPizzalist().size(); i++) {
            items.add(MainActivity.getstoreorders().getOrderlist().get(position).getPizzalist().get(i).toString());
        }
        ArrayAdapter<String> thelist = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        list_s.setAdapter(thelist);
        total_s.setText(CusActivity.formating(MainActivity.getstoreorders().getOrderlist().get(position).gettotal()));
    }

    /**
     * The selection method for event when nothing is selected.
     *
     * @param parent Parent parameter of the spinner.
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}