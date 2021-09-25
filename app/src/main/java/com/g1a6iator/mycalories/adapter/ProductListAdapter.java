package com.g1a6iator.mycalories.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.g1a6iator.mycalories.model.Product;

public class ProductListAdapter extends ListAdapter<Product, ProductViewHolder> {

    public interface ProductOnClickListener {
        void onDelete(Product product);
    }

    private final ProductOnClickListener onClickListener;

    public ProductListAdapter(@NonNull DiffUtil.ItemCallback<Product> diffCallback, ProductOnClickListener onClickListener) {
        super(diffCallback);
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ProductViewHolder.create(parent, onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product current = getItem(position);
        holder.bind(current);
    }

    public static class ProductDiff extends DiffUtil.ItemCallback<Product> {

        @Override
        public boolean areItemsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return oldItem.getName().equals(newItem.getName())
                    && oldItem.getDescription().equals(newItem.getDescription())
                    && oldItem.getCalories() == newItem.getCalories();
        }
    }
}
