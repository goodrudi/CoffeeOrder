package space.goodrudi.coffeeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextName = findViewById(R.id.editTextUserName);
        editTextPass = findViewById(R.id.editTextUserPass);
    }

    public void onClickCreateOrder(View view) {
        String name = editTextName.getText().toString().trim();
        String pass = editTextPass.getText().toString().trim();
        if (!name.isEmpty() && !pass.isEmpty()) {
            Intent intent = new Intent(this, CreateOrderActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("pass", pass);
            startActivity(intent);
        } else Toast.makeText(this, R.string.pull_fields_warning, Toast.LENGTH_SHORT).show();

    }
}