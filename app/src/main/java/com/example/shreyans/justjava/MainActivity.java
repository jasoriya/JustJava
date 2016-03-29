package com.example.shreyans.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);

    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if (quantity > 0) {
            quantity = quantity - 1;
            displayQuantity(quantity);
        }
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText name = (EditText) findViewById(R.id.album_description_view);
        CheckBox whipped_cream_checkbox = (CheckBox) findViewById(R.id.checkbox_whipped_cream);
        CheckBox chocolate_checkbox = (CheckBox) findViewById(R.id.checkbox_chocolate);
        String namePerson = name.getText().toString();
        boolean hasWhippedCream = whipped_cream_checkbox.isChecked();
        boolean hasChocolate = chocolate_checkbox.isChecked();
        int price = calculatePrice(hasWhippedCream, hasChocolate);
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate, namePerson);
        displayMessage(priceMessage);
    }

    /**
     * Creates the summary of order
     *
     * @param price of the order
     */
    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate, String name) {
        String priceMessage = "Name: " + name;
        if (addWhippedCream)
            priceMessage = priceMessage + "\nAdded Whipped Cream! :) ";
        if (addChocolate)
            priceMessage = priceMessage + "\nAdded Chocolate! ;) ";
        priceMessage = priceMessage + "\nQuantity: " + quantity;
        priceMessage = priceMessage + "\nAmount Due: $" + price;
        priceMessage = priceMessage + "\n\nThank you!";
        return priceMessage;
    }

    /**
     * Calculates the price of the order.
     *
     * @param addWhippedCream checks if user wants whipped cream or not
     * @param addChocolate    checks if  user want chocolate or not
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        int basePrice = 10;

        if (addWhippedCream) {
            basePrice = basePrice + 1;
        }

        if (addChocolate) {
            basePrice = basePrice + 2;
        }
        return quantity * basePrice;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }


    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);

    }

    public void submitOrder() {
        display(1);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }
}