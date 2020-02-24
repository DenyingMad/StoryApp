package com.danny.storyapp.FirstScreenSlider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.danny.storyapp.NewRecipe.NewRecipe;
import com.danny.storyapp.OnSwipeListener;
import com.danny.storyapp.R;
import com.danny.storyapp.RecipesBook;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Adapter adapter;
    private ViewPager viewPager;
    private List<Item> items;
    private int position_loc;
    private TextView title_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPagerCards();
        getWindow().setAllowEnterTransitionOverlap(false);
        title_name = findViewById(R.id.title_name);

        LinearLayout main_parent = findViewById(R.id.main_parent);
        viewPager.setOnTouchListener(new OnSwipeListener(this){
            @Override
            public void onSwipeUp() {
                Intent intent;
                if(position_loc == 0) {
                    Transition transition_up = TransitionInflater.from(MainActivity.this).inflateTransition(R.transition.slide_up_out);
                    getWindow().setExitTransition(transition_up);
                    intent = new Intent(MainActivity.this, RecipesBook.class);
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                    startActivity(intent, options.toBundle());
                }
                else if (position_loc == 1){
                    Transition transition_up = TransitionInflater.from(MainActivity.this).inflateTransition(R.transition.slide_up_out);
                    getWindow().setExitTransition(transition_up);
                    intent = new Intent(MainActivity.this, NewRecipe.class);
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                    startActivity(intent, options.toBundle());
                }

            }
        });
        main_parent.setOnTouchListener(new OnSwipeListener(this){
            @Override
            public void onSwipeUp() {
                Intent intent;
                if(position_loc == 0) {
                    Transition transition_up = TransitionInflater.from(MainActivity.this).inflateTransition(R.transition.slide_up_out);
                    getWindow().setExitTransition(transition_up);
                    intent = new Intent(MainActivity.this, RecipesBook.class);
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                    startActivity(intent, options.toBundle());
                }
                else if (position_loc == 1){
                    Transition transition_up = TransitionInflater.from(MainActivity.this).inflateTransition(R.transition.slide_up_out);
                    getWindow().setExitTransition(transition_up);
                    intent = new Intent(MainActivity.this, NewRecipe.class);
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                    startActivity(intent, options.toBundle());
                }

            }
        });

    }

    private void initPagerCards(){
        items = new ArrayList<>();
        items.add(new Item(R.drawable.recipes_book_image));
        items.add(new Item(R.drawable.new_recipe_image));

        adapter = new Adapter(items, this);

        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(100, 0, 100, 0);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                position_loc = position;
                if (position == 0)
                    title_name.setText("Recipes Book");
                else if (position == 1)
                    title_name.setText("New Recipe");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}

