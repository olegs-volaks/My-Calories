package com.g1a6iator.mycalories.ui.product;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.g1a6iator.mycalories.R;
import com.g1a6iator.mycalories.model.EatenFood;
import com.g1a6iator.mycalories.model.Product;
import com.google.gson.Gson;

import java.math.BigDecimal;
import java.util.Date;

public class AddProductToEatenFoodActivity extends AppCompatActivity {

    public static final String EATEN_FOOD = "com.g1a6iator.mycalories.ui.product.EATEN_FOOD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product_to_eaten_food);
        Gson gson = new Gson();
        Product product = gson.fromJson(getIntent().getStringExtra(AddProductToEatenFoodActivityContract.PRODUCT), Product.class);
        EditText editCount = findViewById(R.id.edit_eaten_food_count);
        TextView productName = findViewById(R.id.edit_eaten_food_product_name);
        TextView caloriesCount = findViewById(R.id.edit_eaten_food_caloric_content);
        productName.setText(product.getName());
        caloriesCount.setText(String.valueOf(product.getCalories()));

        final Button saveButton = findViewById(R.id.eaten_food_button_save);
        saveButton.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(editCount.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                double count = Double.parseDouble(editCount.getText().toString());
                EatenFood eatenFood = new EatenFood();
                eatenFood.setProductName(product.getName());
                eatenFood.setCount(count);
                eatenFood.setDate(new Date());
                BigDecimal totalCaloriesCount = BigDecimal.valueOf(product.getCalories()).multiply(BigDecimal.valueOf(count));
                eatenFood.setTotalCalories(totalCaloriesCount.doubleValue());
                String eatenFoodGson = gson.toJson(eatenFood);
                replyIntent.putExtra(EATEN_FOOD, eatenFoodGson);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }
}