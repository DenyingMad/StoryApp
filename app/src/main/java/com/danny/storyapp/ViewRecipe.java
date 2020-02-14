package com.danny.storyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ViewRecipe extends AppCompatActivity {
    private TextView recipe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veiw_recipe);
        recipe = findViewById(R.id.Recipe);
    }
}
