package com.example.chhaichivon.androidrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {


	private RecyclerView mRecyclerView;
	private ProductAdapter  mProductAdapter;
	private RecyclerView.LayoutManager  mLayoutManager;
	private List<Product> productList = new ArrayList<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		mRecyclerView = (RecyclerView) findViewById(R.id.product_recycler_view);
		mRecyclerView.setHasFixedSize(true);



		mLayoutManager = new LinearLayoutManager(getApplicationContext());
		mRecyclerView.setLayoutManager(mLayoutManager);
		mProductAdapter = new ProductAdapter(productList);
		mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
		mRecyclerView.setItemAnimator(new DefaultItemAnimator());
		mRecyclerView.setAdapter(mProductAdapter);

		mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), mRecyclerView, new RecyclerTouchListener.ClickListener() {
			@Override
			public void onClick(View view, int position) {
				Product product= productList.get(position);
				Toast.makeText(getApplicationContext(), product.getName() + " is selected!", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onLongClick(View view, int position) {

			}
		}));

		productData();
	}

	public void productData(){
		Product product = new Product("Product Name1 ", "1200", "Description ");
		productList.add(product);
		product = new Product("Product Name2 ","1200", "Description ");
		productList.add(product);
		product = new Product("Product Name3 ", "1200", "Description ");
		productList.add(product);
		product = new Product("Product Name4 ", "1200", "Description ");
		productList.add(product);
		product = new Product("Product Name5 ", "1200", "Description ");
		productList.add(product);

		mProductAdapter.notifyDataSetChanged();
	}
}
