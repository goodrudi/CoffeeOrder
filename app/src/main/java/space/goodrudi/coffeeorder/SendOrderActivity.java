package space.goodrudi.coffeeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SendOrderActivity extends AppCompatActivity {
    TextView textViewOrderContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_order);

        textViewOrderContent = findViewById(R.id.textViewOrderContent);

        Intent intent = getIntent();
        if (intent.hasExtra("order")) {
            String extra = intent.getStringExtra("order");
            textViewOrderContent.setText(extra);
        }
    }
}