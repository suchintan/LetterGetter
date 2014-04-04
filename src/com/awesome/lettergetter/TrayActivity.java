package com.awesome.lettergetter;

import java.util.ArrayList;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.AdapterView;
import android.widget.GridView;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import com.awesome.lettergetter.Letters;
import com.awesome.lettergetter.GameState;


public class TrayActivity extends Activity {
	GridView gridView;
	ArrayList<Item> gridArray = new ArrayList<Item>();
	 CustomGridViewAdapter customGridAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tray);
		
		
		Intent intent = getIntent();
		final int button_id = intent.getIntExtra("id", 0);
		
		
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

		
	gridArray.add(new Item(aIcon, GameState.LetterNum.A.getQuantity(), Letters.A.getScore()));
	gridArray.add(new Item(bIcon, GameState.LetterNum.B.getQuantity(), Letters.B.getScore()));
	gridArray.add(new Item(cIcon, GameState.LetterNum.C.getQuantity(), Letters.C.getScore()));
	gridArray.add(new Item(dIcon, GameState.LetterNum.D.getQuantity(), Letters.D.getScore()));
	gridArray.add(new Item(eIcon, GameState.LetterNum.E.getQuantity(), Letters.E.getScore()));
	gridArray.add(new Item(fIcon, GameState.LetterNum.F.getQuantity(), Letters.F.getScore()));
	gridArray.add(new Item(gIcon, GameState.LetterNum.G.getQuantity(), Letters.G.getScore()));
	gridArray.add(new Item(hIcon, GameState.LetterNum.H.getQuantity(), Letters.H.getScore()));
	gridArray.add(new Item(iIcon, GameState.LetterNum.I.getQuantity(), Letters.I.getScore()));
	gridArray.add(new Item(jIcon, GameState.LetterNum.J.getQuantity(), Letters.J.getScore()));
	gridArray.add(new Item(kIcon, GameState.LetterNum.K.getQuantity(), Letters.K.getScore()));
	gridArray.add(new Item(lIcon, GameState.LetterNum.L.getQuantity(), Letters.L.getScore()));
	gridArray.add(new Item(mIcon, GameState.LetterNum.M.getQuantity(), Letters.M.getScore()));
	gridArray.add(new Item(nIcon, GameState.LetterNum.N.getQuantity(), Letters.N.getScore()));
	gridArray.add(new Item(oIcon, GameState.LetterNum.O.getQuantity(), Letters.O.getScore()));
	gridArray.add(new Item(pIcon, GameState.LetterNum.P.getQuantity(), Letters.P.getScore()));
	gridArray.add(new Item(qIcon, GameState.LetterNum.Q.getQuantity(), Letters.Q.getScore()));
	gridArray.add(new Item(rIcon, GameState.LetterNum.R.getQuantity(), Letters.R.getScore()));
	gridArray.add(new Item(sIcon, GameState.LetterNum.S.getQuantity(), Letters.S.getScore()));
	gridArray.add(new Item(tIcon, GameState.LetterNum.T.getQuantity(), Letters.T.getScore()));
	gridArray.add(new Item(uIcon, GameState.LetterNum.U.getQuantity(), Letters.U.getScore()));
	gridArray.add(new Item(vIcon, GameState.LetterNum.V.getQuantity(), Letters.V.getScore()));
	gridArray.add(new Item(wIcon, GameState.LetterNum.W.getQuantity(), Letters.W.getScore()));
	gridArray.add(new Item(xIcon, GameState.LetterNum.X.getQuantity(), Letters.X.getScore()));
	gridArray.add(new Item(yIcon, GameState.LetterNum.Y.getQuantity(), Letters.Y.getScore()));
	gridArray.add(new Item(zIcon, GameState.LetterNum.Z.getQuantity(), Letters.Z.getScore()));

	
		

		
		gridView = (GridView) findViewById(R.id.gridView1);
		customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid, gridArray);
		gridView.setAdapter(customGridAdapter);
	
	
		
		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
				int position, long id) {
				
				Intent intent = new Intent(TrayActivity.this, LetterGetterActivity.class);
				intent.putExtra("Ans", "A");
				intent.putExtra("id", button_id);
				
				startActivity(intent);
		
			
		}
	});
		
		
	
	}

}
