package me.abhiseshan.hackwestern.healthycook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

/**
 * Created by hp on 28-Mar-15.
 */
public class SearchActivity extends Activity {

    String query = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        final CheckBox cb_potato = (CheckBox) findViewById(R.id.potato);
        final CheckBox cb_chicken = (CheckBox) findViewById(R.id.chicken);
        final CheckBox cb_carrot = (CheckBox) findViewById(R.id.carrot);
        final CheckBox cb_rice = (CheckBox) findViewById(R.id.rice);


        final Button button = (Button) findViewById(R.id.search);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (cb_carrot.isChecked()) query += "carrot";
                if (cb_potato.isChecked()) query += "+potato";
                if (cb_chicken.isChecked()) query += "+chicken";
                if (cb_rice.isChecked()) query += "+rice";

                Intent myIntent = new Intent(SearchActivity.this, SearchResultsActivity.class);
                myIntent.putExtra("query", query);
                SearchActivity.this.startActivity(myIntent);

            }
        });
    }

    @Override
    protected  void onResume(){
        query = "";
        super.onResume();
    }
}
