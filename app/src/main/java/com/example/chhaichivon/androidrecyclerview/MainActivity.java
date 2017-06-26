package com.example.chhaichivon.androidrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	private RecyclerView mRecyclerView;
	private ProductAdapter  mProductAdapter;
	private RecyclerView.LayoutManager  mLayoutManager;
	private List<Product> productList;
	private Product product;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
		mRecyclerView.setHasFixedSize(true);

		productData();

		mLayoutManager = new LinearLayoutManager(this);
		mRecyclerView.setLayoutManager(mLayoutManager);

		mProductAdapter = new ProductAdapter(productList);
		mRecyclerView.setAdapter(mProductAdapter);

	}
	public void productData(){
		productList = new ArrayList<>();

		product = new Product(1,"Product Name1 ", (float) 2.0d, "Description ");
		productList.add(product);
		product = new Product(1,"Product Name2 ", (float) 2.0d, "Description ");
		productList.add(product);
		product = new Product(1,"Product Name3 ", (float) 2.0d, "Description ");
		productList.add(product);
		product = new Product(1,"Product Name4 ", (float) 2.0d, "Description ");
		productList.add(product);
		product = new Product(1,"Product Name5 ", (float) 2.0d, "Description ");
		productList.add(product);
	}
}
