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

import com.awesome.lettergetter.dto.Item;
import com.awesome.lettergetter.enums.LETTER;
import com.awesome.lettergetter.factory.GameState;


public class TrayActivity extends Activity {
	GridView gridView;
	ArrayList<Item> gridArray = new ArrayList<Item>();
	CustomGridViewAdapter customGridAdapter;
	GameState state;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tray);
		
		state = GameState.getInstance(this);
		
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

		
		gridArray.add(new Item(aIcon, state.getLetterQuantityFromTray(LETTER.A), LETTER.A.getScore()));
		gridArray.add(new Item(bIcon, state.getLetterQuantityFromTray(LETTER.B), LETTER.B.getScore()));
		gridArray.add(new Item(cIcon, state.getLetterQuantityFromTray(LETTER.C), LETTER.C.getScore()));
		gridArray.add(new Item(dIcon, state.getLetterQuantityFromTray(LETTER.D), LETTER.D.getScore()));
		gridArray.add(new Item(eIcon, state.getLetterQuantityFromTray(LETTER.E), LETTER.E.getScore()));
		gridArray.add(new Item(fIcon, state.getLetterQuantityFromTray(LETTER.F), LETTER.F.getScore()));
		gridArray.add(new Item(gIcon, state.getLetterQuantityFromTray(LETTER.G), LETTER.G.getScore()));
		gridArray.add(new Item(hIcon, state.getLetterQuantityFromTray(LETTER.H), LETTER.H.getScore()));
		gridArray.add(new Item(iIcon, state.getLetterQuantityFromTray(LETTER.I), LETTER.I.getScore()));
		gridArray.add(new Item(jIcon, state.getLetterQuantityFromTray(LETTER.J), LETTER.J.getScore()));
		gridArray.add(new Item(kIcon, state.getLetterQuantityFromTray(LETTER.K), LETTER.K.getScore()));
		gridArray.add(new Item(lIcon, state.getLetterQuantityFromTray(LETTER.L), LETTER.L.getScore()));
		gridArray.add(new Item(mIcon, state.getLetterQuantityFromTray(LETTER.M), LETTER.M.getScore()));
		gridArray.add(new Item(nIcon, state.getLetterQuantityFromTray(LETTER.N), LETTER.N.getScore()));
		gridArray.add(new Item(oIcon, state.getLetterQuantityFromTray(LETTER.O), LETTER.O.getScore()));
		gridArray.add(new Item(pIcon, state.getLetterQuantityFromTray(LETTER.P), LETTER.P.getScore()));
		gridArray.add(new Item(qIcon, state.getLetterQuantityFromTray(LETTER.Q), LETTER.Q.getScore()));
		gridArray.add(new Item(rIcon, state.getLetterQuantityFromTray(LETTER.R), LETTER.R.getScore()));
		gridArray.add(new Item(sIcon, state.getLetterQuantityFromTray(LETTER.S), LETTER.S.getScore()));
		gridArray.add(new Item(tIcon, state.getLetterQuantityFromTray(LETTER.T), LETTER.T.getScore()));
		gridArray.add(new Item(uIcon, state.getLetterQuantityFromTray(LETTER.U), LETTER.U.getScore()));
		gridArray.add(new Item(vIcon, state.getLetterQuantityFromTray(LETTER.V), LETTER.V.getScore()));
		gridArray.add(new Item(wIcon, state.getLetterQuantityFromTray(LETTER.W), LETTER.W.getScore()));
		gridArray.add(new Item(xIcon, state.getLetterQuantityFromTray(LETTER.X), LETTER.X.getScore()));
		gridArray.add(new Item(yIcon, state.getLetterQuantityFromTray(LETTER.Y), LETTER.Y.getScore()));
		gridArray.add(new Item(zIcon, state.getLetterQuantityFromTray(LETTER.Z), LETTER.Z.getScore()));

	
		

		
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
