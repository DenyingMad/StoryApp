package com.danny.storyapp.NewRecipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Module {
    public String name;
    private HashMap<String, String> ingredients;
    private ArrayList<String> steps;

    public Module(String name, HashMap<String, String> ingredients, ArrayList<String> steps){
        this.name = name;
        this.ingredients = ingredients;
        this.steps = steps;
    }
    public void clear(){
        ingredients.clear();
        steps.clear();
    }

    public String getModuleName() {
        return name;
    }

    public HashMap<String, String> getIngredients() {
        return ingredients;
    }

    public ArrayList<String> getSteps() {
        return steps;
    }
}
