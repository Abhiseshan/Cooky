package me.abhiseshan.hackwestern.healthycook;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class SearchResultsActivity extends Activity {

    String query;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchresults);

        Bundle extras = getIntent().getExtras();
        if(extras !=null)
        {
           query = extras.getString("query");
        }

        Log.d("Query", ""+query);

        ScrollView sv = (ScrollView) findViewById(R.id.scroll_view);
        LinearLayout ly = (LinearLayout) findViewById(R.id.linear_layout);
        try {
            new AsyncParseJson(getApplicationContext(), ly, query).execute();

            //TextView tv = new TextView(this);
            //tv.setText(uri[i]);
            //sv.addView(tv);

        } catch (Exception e) {
            Log.d("exception", "exception");
        }
    }
}