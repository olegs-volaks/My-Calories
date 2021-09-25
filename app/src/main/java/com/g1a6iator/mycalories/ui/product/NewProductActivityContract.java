package com.g1a6iator.mycalories.ui.product;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.g1a6iator.mycalories.model.Product;

public class NewProductActivityContract extends ActivityResultContract<Integer, Product> {

    @NonNull
    @Override
    public Intent createIntent(@NonNull Context context, Integer input) {
        return new Intent(context, NewProductActivity.class);
    }

    @Override
    public Product parseResult(int resultCode, @Nullable Intent intent) {
        if (resultCode == Activity.RESULT_OK) {
            Product product = new Product();
            product.setName(intent.getStringExtra(NewProductActivity.PRODUCT_NAME));
            product.setDescription(intent.getStringExtra(NewProductActivity.PRODUCT_DESCRIPTION));
            product.setCalories(intent.getDoubleExtra(NewProductActivity.PRODUCT_CALORIES, 0));
            return product;
        }
        return null;
    }
}
