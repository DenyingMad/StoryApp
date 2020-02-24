package com.danny.storyapp.NewRecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.danny.storyapp.R;
import com.danny.storyapp.Recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NewRecipe extends AppCompatActivity {
    private EditText name, description, module_name, ingredient, count, step;
    private ArrayList<Module> modules = new ArrayList<>();
    private TextView viewing_recipe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_recipe);
        viewing_recipe = findViewById(R.id.viewing_recipe);
        name = findViewById(R.id.edit_name);
        description = findViewById(R.id.edit_description);
        Button addModule = findViewById(R.id.add_module_button);
        addModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                module_name = findViewById(R.id.edit_module_name);
                ingredient = findViewById(R.id.edit_ingredient);
                count = findViewById(R.id.edit_count);
                step = findViewById(R.id.edit_step);
                ArrayList<String> steps = new ArrayList<>();
                steps.add(step.getText().toString());
                HashMap<String, String> ingredient_count = new HashMap<>();
                ingredient_count.put(ingredient.getText().toString(), count.getText().toString());
                Module module = new Module(module_name.getText().toString(), ingredient_count, steps);
                modules.add(module);
            }
        });

    }

    public void createRecipe(View v){

        //TODO Добавить проверку на то, что поля не пустые и есть хотя бы один модуль

        Recipe recipe = new Recipe(name.getText().toString(), description.getText().toString(), modules);
        viewing_recipe.setText(recipe.getName());
        viewing_recipe.append("\n\n" + recipe.getDescription());
        for (int i = 0; i < recipe.getModules().size(); i++){
            viewing_recipe.append(recipe.getModules().get(i).getModuleName() + "\n");
            HashMap<String, String> ingredient = recipe.getModules().get(i).getIngredients();
            for (Map.Entry<String, String> entry : ingredient.entrySet()){
                viewing_recipe.append(entry.getKey() + " \t | \t " + entry.getValue() + "\n");
            }
            ingredient.clear();
        }
    }

    public void addNewIngredientField(View view) {
        LinearLayout linearLayout = findViewById(R.id.ingredients_field);
        LinearLayout linearLayout2 = findViewById(R.id.ingredient);

        LinearLayout linearLayout1 = new LinearLayout(NewRecipe.this);

        LinearLayout.LayoutParams layoutViewLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        linearLayout1.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout1.setLayoutParams(layoutViewLayoutParams);
        linearLayout.addView(linearLayout1);

        LinearLayout.LayoutParams textViewLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        textViewLayoutParams.weight = 1;
        EditText ed1 = new EditText(NewRecipe.this);
        EditText ed2 = new EditText(NewRecipe.this);
        ed1.setLayoutParams(textViewLayoutParams);
        ed2.setLayoutParams(textViewLayoutParams);
        ed1.setText("Ingrediend 2");
        ed2.setText("count 2");
        ed1.setId(View.generateViewId());
        linearLayout1.addView(ed1);
        linearLayout1.addView(ed2);
        linearLayout2.removeView(findViewById(R.id.add_new_ingredient));
        Button btn = new Button(NewRecipe.this);
        btn.setLayoutParams(textViewLayoutParams);
        btn.setText("Add");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewIngredientField(v);
            }
        });
    }
}
