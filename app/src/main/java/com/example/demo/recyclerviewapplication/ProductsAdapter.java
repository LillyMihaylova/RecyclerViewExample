package com.example.demo.recyclerviewapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder> {

    private ArrayList<Product> productsList;

    public ProductsAdapter() {
        this.productsList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_product, parent, false);

        return new ProductsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
        holder.txtProductName.setText(productsList.get(position).getProductName());
        holder.txtProductPrice.setText(String.valueOf(productsList.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public void addItems(ArrayList<Product> products) {
        this.productsList = products;
        notifyDataSetChanged();
    }

    public class ProductsViewHolder extends RecyclerView.ViewHolder {

        private TextView txtProductName;
        private TextView txtProductPrice;

        public ProductsViewHolder(View itemView) {
            super(itemView);

            txtProductName = itemView.findViewById(R.id.txt_product_name);
            txtProductPrice = itemView.findViewById(R.id.txt_price);
        }
    }
}
