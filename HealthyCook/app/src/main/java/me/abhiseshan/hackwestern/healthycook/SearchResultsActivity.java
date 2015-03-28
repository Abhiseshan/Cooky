package me.abhiseshan.hackwestern.healthycook;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class SearchResultsActivity extends ActionBarActivity {

    public static String query;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchresults);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            query = extras.getString("query");
        }

        Log.d("Query", "" + query);

        ScrollView sv = (ScrollView) findViewById(R.id.scroll_view);
        LinearLayout ly = (LinearLayout) findViewById(R.id.linear_layout);
        try {
            new AsyncParseJson(getApplicationContext(), ly).execute();

            //TextView tv = new TextView(this);
            //tv.setText(uri[i]);
            //sv.addView(tv);

        } catch (Exception e) {
            Log.d("exception", "exception");
        }

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
}