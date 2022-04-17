package space.goodrudi.coffeeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class CreateOrderActivity extends AppCompatActivity {

    private TextView textViewHelloGuest;
    private TextView textViewAdditions;
    private CheckBox checkBoxSugar;
    private CheckBox checkBoxMilk;
    private CheckBox checkBoxLemon;
    private Spinner spinnerTea;
    private Spinner spinnerCoffee;

    private String name;
    private String pass;
    private String drink;
    private String kind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);

        Intent intent = getIntent();
        if (intent.hasExtra("name") && intent.hasExtra("pass")) {
            name = intent.getStringExtra("name");
            pass = intent.getStringExtra("pass");
        } else {
            name = getString(R.string.default_name);
            pass = getString(R.string.default_pass);
        }

        textViewHelloGuest = findViewById(R.id.textViewHelloGuest);
        String hello = String.format(getString(R.string.hello_guest), name);
        textViewHelloGuest.setText(hello);

        drink = getString(R.string.tea);
        textViewAdditions = findViewById(R.id.textViewAdditions);
        String drinkText = String.format(getString(R.string.about_additions), drink);
        textViewAdditions.setText(drinkText);

        checkBoxSugar = findViewById(R.id.checkBoxSugar);
        checkBoxMilk = findViewById(R.id.checkBoxMilk);
        checkBoxLemon = findViewById(R.id.checkBoxLemon);
        spinnerTea = findViewById(R.id.spinnerTea);
        spinnerCoffee = findViewById(R.id.spinnerCoffee);
    }

    public void onClickChangeDrink(View view) {
        RadioButton button = (RadioButton) view;
        int id = button.getId();
        if (id == R.id.radioButtonTea) {
                drink = getString(R.string.tea);
                spinnerTea.setVisibility(View.VISIBLE);
                spinnerCoffee.setVisibility(View.INVISIBLE);
                checkBoxLemon.setVisibility(View.VISIBLE);
        } else if (id == R.id.radioButtonCoffee) {
                drink = getString(R.string.coffee);
                spinnerTea.setVisibility(View.INVISIBLE);
                spinnerCoffee.setVisibility(View.VISIBLE);
                checkBoxLemon.setVisibility(View.INVISIBLE);
        }
        String drinkText = String.format(getString(R.string.about_additions), drink);
        textViewAdditions.setText(drinkText);
    }

    public void onClickSendOrder(View view) {
        if (drink.equals(getString(R.string.coffee))) {
            kind = spinnerCoffee.getSelectedItem().toString();
        } else if (drink.equals(getString(R.string.tea))) {
            kind = spinnerTea.getSelectedItem().toString();
        }
        String menuText = String.format(getString(R.string.text_menu), name, pass, drink, kind);
        StringBuilder orderText = new StringBuilder(menuText);
        String additionsText = getString(R.string.text_additions);
        orderText.append(additionsText);
        if (checkBoxSugar.isChecked()) {
            orderText.append(getString(R.string.sugar)).append(" ");
        }
        if (checkBoxMilk.isChecked()) {
            orderText.append(getString(R.string.milk)).append(" ");
        }
        if (checkBoxLemon.isChecked()) {
            orderText.append(getString(R.string.lemon)).append(" ");
        }
        Intent intent = new Intent(this, SendOrderActivity.class);
        intent.putExtra("order", orderText.toString());
        startActivity(intent);
    }
}