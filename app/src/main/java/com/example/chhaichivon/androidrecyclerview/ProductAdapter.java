package com.example.chhaichivon.androidrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

/**
 * Created by chhaichivon on 6/25/17.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> implements View.OnClickListener{

	private List<Product> productsList;

	public ProductAdapter(List<Product> productsList){
		this.productsList  = productsList;
	}

	@Override
	public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view  = LayoutInflater.from(parent.getContext())
					.inflate(R.layout.product_item_layout,parent,false);
		return new ProductViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ProductViewHolder holder, int position) {
		Product product = productsList.get(position);
		holder.mTextViewName.setText(product.getName());
		holder.mTextViewPrice.setText((int) product.getPrice());
		holder.mTextViewDescription.setText(product.getDescription());
	}

	@Override
	public int getItemCount() {
		return productsList.size();
	}

	@Override
	public void onClick(View v) {

	}

	public class ProductViewHolder extends RecyclerView.ViewHolder {
		private TextView mTextViewName;
		private TextView mTextViewPrice;
		private TextView mTextViewDescription;

		public ProductViewHolder(View itemView) {
			super(itemView);
			mTextViewName = (TextView) itemView.findViewById(R.id.txt_name);
			mTextViewPrice = (TextView) itemView.findViewById(R.id.txt_price);
			mTextViewDescription = (TextView) itemView.findViewById(R.id.txt_description);
		}
	}
}
