package com.example.android.jokes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.jokeslibrary.JokeActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.JokeCallbackInterface {

    ProgressBar mProgressBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initProgressBar();
        showAdmobAds();
    }

    private void initProgressBar(){
        mProgressBar=(ProgressBar)findViewById(R.id.joke_loading_progress_bar);
        hideProgressBar();
    }

    private void showProgressBar(){
        mProgressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar(){
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){
        try {
            showProgressBar();
            new EndpointsAsyncTask(this).execute();
            textView=(TextView)findViewById(R.id.loading_text_view);
            textView.setText(R.string.loading_joke_message);
        }catch (Exception exception){
            hideProgressBar();
            textView.setText("");
            Toast.makeText(getApplicationContext(), R.string.joke_error_message,Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void done(String joke) {
        hideProgressBar();
        textView.setText("");
        Intent intent=new Intent(MainActivity.this, JokeActivity.class);
        intent.putExtra("KEY_JOKE",joke);
        startActivity(intent);
    }

    private void showAdmobAds(){
        AdView adView=(AdView)findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        adView.loadAd(adRequest);
    }

}
