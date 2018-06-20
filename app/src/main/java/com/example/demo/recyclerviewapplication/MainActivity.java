package com.example.demo.recyclerviewapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Product> products;
    private Product product;
    private RecyclerView recyclerView;
    private ProductsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.my_recycler_view);

        buildProductsList();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProductsAdapter();
        recyclerView.setAdapter(adapter);
        adapter.addItems(products);
    }

    private void buildProductsList() {
        products = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            product = new Product("Патладжан" + i, 2 + i);
            products.add(product);
        }
    }
}
