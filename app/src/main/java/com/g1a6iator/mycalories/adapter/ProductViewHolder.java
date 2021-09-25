package com.g1a6iator.mycalories.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.g1a6iator.mycalories.R;

class ProductViewHolder extends RecyclerView.ViewHolder {

    private final TextView nameView;
    private final TextView descriptionView;
    private final TextView caloriesNumberView;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);
        nameView = itemView.findViewById(R.id.product_item_name);
        descriptionView = itemView.findViewById(R.id.product_item_description);
        caloriesNumberView = itemView.findViewById(R.id.product_item_calories_number);
    }

    @SuppressLint("SetTextI18n")
    public void bind(String name, String description, double caloriesNumber) {
        nameView.setText(name);
        descriptionView.setText(description);
        caloriesNumberView.setText(Double.toString(caloriesNumber));
    }

    static ProductViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_recyclerview_item, parent, false);
        return new ProductViewHolder(view);
    }
}
