package com.awesome.lettergetter;

import java.util.ArrayList;


import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.AdapterView;
import android.widget.GridView;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;


public class TrayActivity extends Activity {
	GridView gridView;
	ArrayList<Item> gridArray = new ArrayList<Item>();
	 CustomGridViewAdapter customGridAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tray);
		
		//set grid view item
		Bitmap aIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.a);
		Bitmap bIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.b);
		Bitmap cIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.c);
		Bitmap dIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.d);
		Bitmap eIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.e);
		Bitmap fIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.f);
		Bitmap gIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.g);
		Bitmap hIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.h);
		Bitmap iIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.i);
		Bitmap jIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.j);
		Bitmap kIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.k);
		Bitmap lIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.l);
		Bitmap mIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.m);
		Bitmap nIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.n);
		Bitmap oIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.o);
		Bitmap pIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.p);
		Bitmap qIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.q);
		Bitmap rIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.r);
		Bitmap sIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.s);
		Bitmap tIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.t);
		Bitmap uIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.u);
		Bitmap vIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.v);
		Bitmap wIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.w);
		Bitmap xIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.x);
		Bitmap yIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.y);
		Bitmap zIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.z);

		
	gridArray.add(new Item(aIcon,"9"));
	gridArray.add(new Item(bIcon,"2"));
	gridArray.add(new Item(cIcon,"2"));
	gridArray.add(new Item(dIcon,"4"));
	gridArray.add(new Item(eIcon,"12"));
	gridArray.add(new Item(fIcon,"2"));
	gridArray.add(new Item(gIcon,"3"));
	gridArray.add(new Item(hIcon,"2"));
	gridArray.add(new Item(iIcon,"9"));
	gridArray.add(new Item(jIcon,"1"));
	gridArray.add(new Item(kIcon,"1"));
	gridArray.add(new Item(lIcon,"4"));
	gridArray.add(new Item(mIcon,"2"));
	gridArray.add(new Item(nIcon,"6"));
	gridArray.add(new Item(oIcon,"8"));
	gridArray.add(new Item(pIcon,"2"));
	gridArray.add(new Item(qIcon,"1"));
	gridArray.add(new Item(rIcon,"6"));
	gridArray.add(new Item(sIcon,"4"));
	gridArray.add(new Item(tIcon,"6"));
	gridArray.add(new Item(uIcon,"4"));
	gridArray.add(new Item(vIcon,"2"));
	gridArray.add(new Item(wIcon,"2"));
	gridArray.add(new Item(xIcon,"1"));
	gridArray.add(new Item(yIcon,"2"));
	gridArray.add(new Item(zIcon,"1"));

	
		

		
		gridView = (GridView) findViewById(R.id.gridView1);
		customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid, gridArray);
		gridView.setAdapter(customGridAdapter);
	
	
		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
				int position, long id) {
				
				
			
		}
	});
		
		
	
	}

}
