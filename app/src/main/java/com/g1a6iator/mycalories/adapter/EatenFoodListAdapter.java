package com.g1a6iator.mycalories.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.g1a6iator.mycalories.model.EatenFood;

public class EatenFoodListAdapter extends ListAdapter<EatenFood, EatenFoodViewHolder> {

    private final EatenFoodOnClickListener onClickListener;

    public EatenFoodListAdapter(@NonNull DiffUtil.ItemCallback<EatenFood> diffCallback, EatenFoodOnClickListener onClickListener) {
        super(diffCallback);
        this.onClickListener = onClickListener;
    }

    public interface EatenFoodOnClickListener {
        void onDelete(EatenFood eatenFood);
    }

    @NonNull
    @Override
    public EatenFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return EatenFoodViewHolder.create(parent, onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull EatenFoodViewHolder holder, int position) {
        EatenFood current = getItem(position);
        holder.bind(current);
    }

    public static class EatenFoodDiff extends DiffUtil.ItemCallback<EatenFood> {

        @Override
        public boolean areItemsTheSame(@NonNull EatenFood oldItem, @NonNull EatenFood newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull EatenFood oldItem, @NonNull EatenFood newItem) {
            return oldItem.getProductName().equals(newItem.getProductName())
                    && oldItem.getDate().equals(newItem.getDate())
                    && oldItem.getCount() == newItem.getCount()
                    && oldItem.getTotalCalories() == newItem.getTotalCalories()
                    && oldItem.getId().equals(newItem.getId());
        }
    }
}
