package com.example.projectfive;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The class to let the customer use the customization page to order pizza.
 *
 * @author Chengyu Liang, Xinyu Meng
 */
public class CusActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
    private int deluxe = 1, hawaiian = 2, pepperoni = 3, firstcase = 1, secondcase = 2, thirdcase = 3, fivecase = 5, sevencase = 7;
    private ListView listview, listviewtwo;
    private TextView pizzaname, price;
    private Spinner spinner;
    private int getCategory;
    private Button addtoorder;
    private String number;
    private ImageView imageView;
    private double toppingprice = 1.49, originalprice = 8.99;

    private ArrayList<String> itemlist =
            new ArrayList<String>(Arrays.asList("Cheese", "Sausage", "GreenPepper", "Onion", "Pepperoni", "Mushroom", "Chicken", "Beef", "Ham", "Pinneapple", "BlackOlives"));
    private ArrayList<String> itemlisttwo =
            new ArrayList<String>();

    /**
     * The oncreate method for building the customization page for customers to choose the pizzas.
     *
     * @param savedInstanceState a parameter that oncreate method requires.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_view);
        Intent intent = getIntent();
        int Category = intent.getIntExtra("Category", 0);
        number = intent.getStringExtra("number");
        imageView = findViewById(R.id.imageView);
        getCategory = Category;
        if (Category == deluxe) {
            ifdeluxe();
        } else if (Category == hawaiian) {
            ifhawaiian();
        } else if (Category == pepperoni) {
            ifpepperoni();
        }
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * The click listener for the listview items.
             * @param parent a parameter that listview click listener need to use.
             * @param view a parameter that listview click listener need to use.
             * @param position The position of the selected item in the item list.
             * @param id a parameter that listview click listener need to use.
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int check = Category;
                add(position, check);
            }
        });
        listviewtwo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * The click listener for the listview items.
             * @param parent a parameter that listview click listener need to use.
             * @param view a parameter that listview click listener need to use.
             * @param position The position of the selected item in the item list.
             * @param id a parameter that listview click listener need to use.
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                remove(position, Category);
            }
        });
        ArrayList<String> spinneritem = new ArrayList<String>(Arrays.asList("small", "medium", "large"));
        spinner = findViewById(R.id.spinnerone);
        ArrayAdapter<String> spinnerlist = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, spinneritem);
        spinner.setAdapter(spinnerlist);
        spinner.setOnItemSelectedListener(this);
        addtoorder = findViewById(R.id.addtoorder);
        addtoorder.setOnClickListener(new View.OnClickListener() {
            /**
             * The onclick method for setting the click listener for addtoorder button.
             * @param v a parameter that onclick method need to use.
             */
            @Override
            public void onClick(View v) {
                toorder();
                Toast.makeText(CusActivity.this, "Pizza Added.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * To initialize the page if the customer is choosing the deluxe pizza.
     */
    public void ifdeluxe() {
        imageView.setImageResource(R.drawable.deluxeimage);
        listview = findViewById(R.id.additionaltoppings);
        listviewtwo = findViewById(R.id.selectedtoppings);
        listview.setOnItemClickListener(this);
        listviewtwo.setOnItemClickListener(this);
        ArrayList<String> toberemoved = new ArrayList<String>(Arrays.asList("Cheese", "Sausage", "GreenPepper", "Onion", "Pepperoni"));
        itemlist.removeAll(toberemoved);
        itemlisttwo.addAll(toberemoved);
        ArrayAdapter<String> list = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemlist);
        ArrayAdapter<String> listtwo = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemlisttwo);
        listview.setAdapter(list);
        listviewtwo.setAdapter(listtwo);
        pizzaname = findViewById(R.id.pizzaname);
        pizzaname.setText("Deluxe");
        price = findViewById(R.id.price);
        price.setText("12.99");
    }

    /**
     * To initialize the page if the customer is choosing the hawaiian pizza.
     */
    public void ifhawaiian() {
        imageView.setImageResource(R.drawable.hawaiianimage);
        listview = findViewById(R.id.additionaltoppings);
        listviewtwo = findViewById(R.id.selectedtoppings);
        listview.setOnItemClickListener(this);
        listviewtwo.setOnItemClickListener(this);
        ArrayList<String> toberemoved = new ArrayList<String>(Arrays.asList("Cheese", "Sausage"));
        itemlist.removeAll(toberemoved);
        itemlisttwo.addAll(toberemoved);
        ArrayAdapter<String> list = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemlist);
        ArrayAdapter<String> listtwo = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemlisttwo);
        listview.setAdapter(list);
        listviewtwo.setAdapter(listtwo);
        pizzaname = findViewById(R.id.pizzaname);
        pizzaname.setText("Hawaiian");
        price = findViewById(R.id.price);
        price.setText("10.99");
    }

    /**
     * To initialize the page if the customer is choosing the pepperoni pizza.
     */
    public void ifpepperoni() {
        imageView.setImageResource(R.drawable.pepperoniimage);
        listview = findViewById(R.id.additionaltoppings);
        listviewtwo = findViewById(R.id.selectedtoppings);
        listview.setOnItemClickListener(this);
        listviewtwo.setOnItemClickListener(this);
        ArrayList<String> toberemoved = new ArrayList<String>(Arrays.asList("Cheese"));
        itemlist.removeAll(toberemoved);
        itemlisttwo.addAll(toberemoved);
        ArrayAdapter<String> list = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemlist);
        ArrayAdapter<String> listtwo = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemlisttwo);
        listview.setAdapter(list);
        listviewtwo.setAdapter(listtwo);
        pizzaname = findViewById(R.id.pizzaname);
        pizzaname.setText("Pepperoni");
        price = findViewById(R.id.price);
        price.setText("8.99");
    }

    /**
     * To make the chosen pizza into the order that the customer want.
     */
    public void toorder() {
        Pizza pizza;
        switch (getCategory) {
            case 1:
                pizza = new Deluxe();
                break;
            case 2:
                pizza = new Hawaiian();
                break;
            case 3:
                pizza = new Pepperoni();
                break;
            default:
                pizza = new Deluxe();
        }

        for (int i = 0; i < itemlisttwo.size(); i++) {
            pizza.toppings.add(Topping.valueOf(itemlisttwo.get(i)));
        }
        pizza.size = Size.valueOf(spinner.getSelectedItem().toString());
        MainActivity.getstoreorders().addpizza(number, pizza);
    }

    /**
     * To add the toppings into selected toppings.
     *
     * @param position the position of the selected topping.
     * @param Category the flavor of this pizza.
     */
    public void add(int position, int Category) {
        if (itemlisttwo.size() >= sevencase) {
            Toast.makeText(CusActivity.this, "Toppings should not be selected more than 7.", Toast.LENGTH_LONG).show();
            return;
        }
        itemlisttwo.add(itemlist.get(position));
        itemlist.remove(position);
        ArrayAdapter<String> list = new ArrayAdapter<String>(CusActivity.this, android.R.layout.simple_list_item_1, itemlist);
        ArrayAdapter<String> listtwo = new ArrayAdapter<String>(CusActivity.this, android.R.layout.simple_list_item_1, itemlisttwo);
        listview.setAdapter(list);
        listviewtwo.setAdapter(listtwo);
        if ((itemlisttwo.size() <= fivecase && Category == firstcase) || (itemlisttwo.size() <= secondcase && Category == secondcase) || (itemlisttwo.size() <= firstcase && Category == thirdcase)) {
            return;
        }
        price.setText(formating(Double.parseDouble((String) price.getText()) + toppingprice));
    }

    /**
     * To remove the toppings into additional toppings listview.
     *
     * @param position the position of the selected topping.
     * @param Category the flavor of this pizza.
     */
    public void remove(int position, int Category) {
        itemlist.add(itemlisttwo.get(position));
        itemlisttwo.remove(position);
        ArrayAdapter<String> list = new ArrayAdapter<String>(CusActivity.this, android.R.layout.simple_list_item_1, itemlist);
        ArrayAdapter<String> listtwo = new ArrayAdapter<String>(CusActivity.this, android.R.layout.simple_list_item_1, itemlisttwo);
        listview.setAdapter(list);
        listviewtwo.setAdapter(listtwo);
        if ((itemlisttwo.size() < fivecase && Category == firstcase) || (itemlisttwo.size() < secondcase && Category == secondcase) || (itemlisttwo.size() < firstcase && Category == thirdcase)) {
            return;
        }
        price.setText(formating(Double.parseDouble((String) price.getText()) - toppingprice));
    }

    /**
     * The onevent method for selecting item in a spinner.
     *
     * @param parent   a variable required in this onevent method.
     * @param view     a variable required in this onevent method.
     * @param position The position of the selected item in this spinner.
     * @param id       a variable required in this onevent method.
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int origin = 0; // to check the default number of toppings.
        switch (getCategory) {
            case 1:
                origin = 5;
                break;
            case 2:
                origin = 2;
                break;
            case 3:
                origin = 1;
                break;
        }
        if (itemlisttwo.size() <= origin) {
            price.setText(formating(originalprice + secondcase * (thirdcase - getCategory) + secondcase * position));
        } else {
            price.setText(formating((itemlisttwo.size() - origin) * toppingprice + originalprice + secondcase * (thirdcase - getCategory) + secondcase * position));
        }
    }

    /**
     * The onevent method if the spinner current has nothing on selected status.
     *
     * @param parent
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    } //can leave it empty

    public static String formating(double value) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        String result = df.format(value);
        return result;
    }

    /**
     * The onevent method if the item is clicked.
     *
     * @param parent   a parameter required by this onevent method.
     * @param view     a parameter required by this onevent method.
     * @param position the position of the selected item.
     * @param id       a parameter required by this onevent method.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}