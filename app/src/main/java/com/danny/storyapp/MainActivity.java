package com.danny.storyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView recipe_book_img = findViewById(R.id.recipe_Book_Img);
        ImageView add_recipe_img = findViewById(R.id.add_recipe_img);
        recipe_book_img.setClipToOutline(true);
        add_recipe_img.setClipToOutline(true);
        recipe_book_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, NewRecipe.class);
                startActivity(i);
            }
        });
//some fucking changes
    }
}
