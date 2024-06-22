package com.sophysophanna.my_project.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sophysophanna.my_project.Adapter.FoodListAdapter;
import com.sophysophanna.my_project.Domain.FoodDomain;
import com.sophysophanna.my_project.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterFoodList;
    private RecyclerView recyclerViewFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

    initRecyclerview();
    bottomNavigation();


    }

    private void bottomNavigation() {
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout cartBtn=findViewById(R.id.cartBtn);

        homeBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, MainActivity.class)));

        cartBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,CartActivity.class)));
    }

    private void initRecyclerview() {
        ArrayList<FoodDomain> items=new ArrayList<>();
        items.add(new FoodDomain("Cheese Burger","Satisfy your cravings with our juicy Cheese Burger. Made with 100% Angus beef patty and topped with melted cheddar cheese, fresh lettuce, tomato, and our secret sauce, this classic burger will leave you wanting more. Served with crispy fries and a drink it's the perfect meal for any occasion. ",
                "fast_1",15 ,20,120,4));
        items.add(new FoodDomain("Pizza Peperoni","Satisfy your cravings with our juicy Cheese Burger. Made with 100% Angus beef patty and topped with melted cheddar cheese, fresh lettuce, tomato, and our secret sauce, this classic burger will leave you wanting more. Served with crispy fries and a drink it's the perfect meal for any occasion. ",
                "fast_2",10 ,25,200,5));
        items.add(new FoodDomain("Vegetable Pizza","Satisfy your cravings with our juicy Cheese Burger. Made with 100% Angus beef patty and topped with melted cheddar cheese, fresh lettuce, tomato, and our secret sauce, this classic burger will leave you wanting more. Served with crispy fries and a drink it's the perfect meal for any occasion. ",
                "fast_3",13 ,30,100,4.5));

        recyclerViewFood=findViewById(R.id.view1);
        recyclerViewFood.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        adapterFoodList=new FoodListAdapter(items);
        recyclerViewFood.setAdapter(adapterFoodList);

    }
}