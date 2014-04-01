package com.awesome.lettergetter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ShopActivity extends MenuActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shop);
		
		populateShopView();
	}
	
	private void populateShopView(){
		ArrayAdapter<LetterItem> adapter = new ShopAdapter();
		ListView list = (ListView) findViewById(R.id.shop_listview);
		
		list.setAdapter(adapter);
	}
	
	private class ShopAdapter extends ArrayAdapter<LetterItem>{

		public ShopAdapter() {
			super(ShopActivity.this, R.layout.shop_view, gameState.getShopData());
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View shopeItemView = convertView;
			if (shopeItemView == null){
				shopeItemView = getLayoutInflater().inflate(R.layout.shop_view, parent, false);
			}
			//Find the leader
			LetterItem currentLetter = gameState.getShopData().get(position);
			
			//Fill the view
			//Letter:
			TextView letterText = (TextView) shopeItemView.findViewById(R.id.shop_letter);
			letterText.setText(currentLetter.getLetter());
			
			//Cost:
			TextView costText = (TextView) shopeItemView.findViewById(R.id.shop_cost);
			costText.setText("Cost: " + Integer.toString(currentLetter.getCost()));
			
			return shopeItemView;
		}
		
	}

}
