package com.g1a6iator.mycalories.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.g1a6iator.mycalories.R;
import com.g1a6iator.mycalories.model.Product;

class ProductViewHolder extends RecyclerView.ViewHolder {

    private final TextView nameView;
    private final TextView descriptionView;
    private final TextView caloriesNumberView;
    private final ImageButton deleteButtonView;
    private final ProductListAdapter.ProductOnClickListener onClickListener;
    private final View itemView;

    public ProductViewHolder(@NonNull View itemView, ProductListAdapter.ProductOnClickListener onClickListener) {
        super(itemView);
        nameView = itemView.findViewById(R.id.product_item_name);
        descriptionView = itemView.findViewById(R.id.product_item_description);
        caloriesNumberView = itemView.findViewById(R.id.product_item_calories_number);
        deleteButtonView = itemView.findViewById(R.id.product_item_delete);
        this.onClickListener = onClickListener;
        this.itemView = itemView;
    }

    public void bind(Product product) {
        nameView.setText(product.getName());
        descriptionView.setText(product.getDescription());
        caloriesNumberView.setText(String.valueOf(product.getCalories()));
        deleteButtonView.setOnClickListener(view -> {
            onClickListener.onDelete(product);
        });
        itemView.setOnClickListener(view -> {
            onClickListener.onItemClick(product);
        });
    }

    static ProductViewHolder create(ViewGroup parent, ProductListAdapter.ProductOnClickListener onClickListener) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_recyclerview_item, parent, false);
        return new ProductViewHolder(view, onClickListener);
    }
}
