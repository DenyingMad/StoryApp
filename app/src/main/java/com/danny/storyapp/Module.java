package com.danny.storyapp;

import java.util.ArrayList;
import java.util.HashMap;

public class Module {
    public String name;
    public HashMap<String, String> ingredients;
    public ArrayList<String> steps;

    public Module(String name, HashMap<String, String> ingredients, ArrayList<String> steps){
        this.name = name;
        this.ingredients = ingredients;
        this.steps = steps;
    }
    public void clear(){
        ingredients.clear();
        steps.clear();
    }
}
