package com.danny.storyapp.NewRecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;

import com.danny.storyapp.R;

public class AddRecipeCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe_category);

        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.slide_up_in);
        getWindow().setEnterTransition(transition);
    }
}
