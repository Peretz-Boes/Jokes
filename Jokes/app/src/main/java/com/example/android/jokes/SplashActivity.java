package com.example.android.jokes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Peretz on 2017-02-22.
 */

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Intent intent=new Intent(SplashActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

}
