package com.g1a6iator.mycalories.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.g1a6iator.mycalories.R;
import com.g1a6iator.mycalories.model.EatenFood;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class EatenFoodViewHolder extends RecyclerView.ViewHolder {

    private final TextView nameView;
    private final TextView dateView;
    private final TextView caloriesNumberView;
    private final ImageButton deleteButtonView;
    private final EatenFoodListAdapter.EatenFoodOnClickListener onClickListener;

    public EatenFoodViewHolder(@NonNull View itemView, EatenFoodListAdapter.EatenFoodOnClickListener onClickListener) {
        super(itemView);
        nameView = itemView.findViewById(R.id.eaten_food_item_name);
        dateView = itemView.findViewById(R.id.eaten_food_item_date);
        caloriesNumberView = itemView.findViewById(R.id.eaten_food_item_calories_number);
        deleteButtonView = itemView.findViewById(R.id.eaten_food_item_delete);
        this.onClickListener = onClickListener;
    }

    public void bind(EatenFood eatenFood) {
        nameView.setText(eatenFood.getProductName());
        DateFormat dateFormat = SimpleDateFormat.getDateTimeInstance();
        dateView.setText(dateFormat.format(eatenFood.getDate()));
        caloriesNumberView.setText(String.valueOf(eatenFood.getTotalCalories()));
        deleteButtonView.setOnClickListener(view -> {
            onClickListener.onDelete(eatenFood);
        });
    }

    static EatenFoodViewHolder create(ViewGroup parent, EatenFoodListAdapter.EatenFoodOnClickListener onClickListener) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.eaten_food_recycleview_item, parent, false);
        return new EatenFoodViewHolder(view, onClickListener);
    }
}
