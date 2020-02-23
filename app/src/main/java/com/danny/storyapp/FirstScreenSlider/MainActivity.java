package com.danny.storyapp.FirstScreenSlider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;

import com.danny.storyapp.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Adapter adapter;
    ViewPager viewPager;
    List<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPagerCards();

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

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
