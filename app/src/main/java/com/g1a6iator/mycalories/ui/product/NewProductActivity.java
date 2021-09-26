package com.g1a6iator.mycalories.ui.product;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.g1a6iator.mycalories.R;

public class NewProductActivity extends AppCompatActivity {

    public static final String PRODUCT_NAME = "com.g1a6iator.mycalories.ui.product.PRODUCT_NAME";
    public static final String PRODUCT_DESCRIPTION = "com.g1a6iator.mycalories.ui.product.PRODUCT_DESCRIPTION";
    public static final String PRODUCT_CALORIES = "com.g1a6iator.mycalories.ui.product.PRODUCT_CALORIES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product);
        EditText editName = findViewById(R.id.edit_product_name);
        EditText editDescription = findViewById(R.id.edit_product_description);
        EditText editCalories = findViewById(R.id.edit_product_calories_number);

        final Button saveButton = findViewById(R.id.product_button_save);
        saveButton.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(editName.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String name = editName.getText().toString();
                String description = editDescription.getText().toString();
                String calories = editCalories.getText().toString();
                replyIntent.putExtra(PRODUCT_NAME, name);
                replyIntent.putExtra(PRODUCT_DESCRIPTION, description);
                replyIntent.putExtra(PRODUCT_CALORIES, Double.parseDouble(calories));
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }


}