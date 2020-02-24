package com.danny.storyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;

public class RecipesBook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_book);

        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.slide_up_in);
        getWindow().setEnterTransition(transition);

    }
}
