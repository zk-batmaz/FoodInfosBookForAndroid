package com.qbra.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.qbra.landmarkbook.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        //Casting
        Landmark selectedFood = (Landmark) intent.getSerializableExtra("foodInfo");
        binding.nameText.setText(selectedFood.name);
        binding.countryText.setText((selectedFood.recipe));
        binding.imageView.setImageResource(selectedFood.img);

    }
}