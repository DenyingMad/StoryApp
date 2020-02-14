package com.danny.storyapp;

import java.util.ArrayList;

public class Recipe {
    private String name, description;
    //private String[] categories;
    private ArrayList<Module> modules;
    public Recipe(String name, String description, ArrayList<Module> modules){
        this.name = name;
        this.description = description;
        this.modules = modules;
    }
}
