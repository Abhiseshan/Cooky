package me.abhiseshan.hackwestern.healthycook;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;


public class MainActivity extends ActionBarActivity {

    public static String query ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CheckBox cb_potato = (CheckBox) findViewById(R.id.potato);
        final CheckBox cb_chicken = (CheckBox) findViewById(R.id.chicken);
        final CheckBox cb_carrot = (CheckBox) findViewById(R.id.carrot);
        final CheckBox cb_rice = (CheckBox) findViewById(R.id.rice);
        final CheckBox cb_potato2 = (CheckBox) findViewById(R.id.potato2);
        final CheckBox cb_chicken2 = (CheckBox) findViewById(R.id.chicken2);
        final CheckBox cb_carrot2 = (CheckBox) findViewById(R.id.carrot2);
        final CheckBox cb_rice2 = (CheckBox) findViewById(R.id.rice2);



        final Button button = (Button) findViewById(R.id.search);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (cb_carrot.isChecked()) query += "+carrot";
                if (cb_potato.isChecked()) query += "+potato";
                if (cb_chicken.isChecked()) query += "+chicken";
                if (cb_rice.isChecked()) query += "+rice";
                if (cb_carrot2.isChecked()) query += "+carrot";
                if (cb_potato2.isChecked()) query += "+potato";
                if (cb_chicken2.isChecked()) query += "+chicken";
                if (cb_rice2.isChecked()) query += "+rice";

                Intent myIntent = new Intent(MainActivity.this, SearchResultsActivity.class);
                myIntent.putExtra("query", query);
                MainActivity.this.startActivity(myIntent);

            }
        });
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

    @Override
    protected void onResume(){
        query = "";
        super.onResume();
    }
}
