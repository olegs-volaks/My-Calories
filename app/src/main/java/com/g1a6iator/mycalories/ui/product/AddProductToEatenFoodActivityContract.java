package com.g1a6iator.mycalories.ui.product;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.g1a6iator.mycalories.model.EatenFood;
import com.g1a6iator.mycalories.model.Product;
import com.google.gson.Gson;

public class AddProductToEatenFoodActivityContract extends ActivityResultContract<Product, EatenFood> {

    public static final String PRODUCT = "com.g1a6iator.mycalories.ui.product.PRODUCT";

    @NonNull
    @Override
    public Intent createIntent(@NonNull Context context, Product input) {
        Intent intent = new Intent(context, AddProductToEatenFoodActivity.class);
        Gson gson = new Gson();
        String productGson = gson.toJson(input);
        intent.putExtra(PRODUCT, productGson);
        return intent;
    }

    @Override
    public EatenFood parseResult(int resultCode, @Nullable Intent intent) {
        if (resultCode == Activity.RESULT_OK && intent != null) {
            Gson gson = new Gson();
            EatenFood result = gson.fromJson(intent.getStringExtra(AddProductToEatenFoodActivity.EATEN_FOOD), EatenFood.class);
            return result;
        }
        return null;
    }
}
