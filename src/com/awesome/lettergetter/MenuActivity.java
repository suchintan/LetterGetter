package com.awesome.lettergetter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MenuActivity extends Activity {
	public static GameState gameState = new GameState();
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.letter_getter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	//Changes between menu items
    	switch(item.getItemId())
    	{
    	case R.id.main:
    		startActivity(new Intent(this, LetterGetterActivity.class));
		return true;
    	case R.id.shop:
    		startActivity(new Intent(this, ShopActivity.class));
    	return true;
    	
    	case R.id.leaderboard:
    		startActivity(new Intent(this, LeaderboardActivity.class));
		return true;
		
		default:
			return super.onOptionsItemSelected(item);
    		
    	}
    }
}
