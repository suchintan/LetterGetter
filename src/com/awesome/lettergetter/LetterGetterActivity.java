package com.awesome.lettergetter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class LetterGetterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter_getter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.letter_getter, menu);
        return true;
    }
    
}
