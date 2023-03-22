package com.qbra.landmarkbook;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qbra.landmarkbook.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodHolder>
{
    ArrayList<Landmark> foodArrayList;

    public FoodAdapter(ArrayList<Landmark> foodArrayList) {
        this.foodArrayList = foodArrayList;
    }

    @NonNull
    @Override
    public FoodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new FoodHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodHolder holder, int position) {
        int myPosition = holder.getAdapterPosition();
        holder.binding.recyclerViewText.setText(foodArrayList.get(myPosition).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailsActivity.class);
                intent.putExtra("foodInfo", foodArrayList.get(myPosition));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodArrayList.size();
    }

    public class FoodHolder extends RecyclerView.ViewHolder
    {
        private RecyclerRowBinding binding;

        public FoodHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
