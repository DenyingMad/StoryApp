package com.danny.storyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;

public class NewRecipe extends AppCompatActivity {
    private EditText name, description, module_name, ingredient, count, step;
    private Button addModule;
    private ArrayList<String> steps = new ArrayList<>();
    private HashMap<String, String> ingredient_count = new HashMap<>();
    private ArrayList<Module> modules = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_recipe);
        name = findViewById(R.id.edit_name);
        description = findViewById(R.id.edit_description);
        addModule = findViewById(R.id.add_module_button);
        addModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                module_name = findViewById(R.id.edit_module_name);
                ingredient = findViewById(R.id.edit_ingredient);
                count = findViewById(R.id.edit_count);
                step = findViewById(R.id.edit_step);
                steps.add(step.getText().toString());
                ingredient_count.put(ingredient.getText().toString(), count.getText().toString());
                Module module = new Module(module_name.getText().toString(), ingredient_count, steps);
                modules.add(module);
                module.clear();
            }
        });

    }

    public void createRecipe(View v){

        //TODO Добавить проверку на то, что поля не пустые и есть хотя бы один модуль

        Recipe recipe = new Recipe(name.getText().toString(), description.getText().toString(), modules);
        Intent i = new Intent(NewRecipe.this, ViewRecipe.class);
        
        startActivity(i);
    }
}
