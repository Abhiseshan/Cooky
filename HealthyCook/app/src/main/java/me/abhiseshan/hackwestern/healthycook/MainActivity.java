package me.abhiseshan.hackwestern.healthycook;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelSlideListener;
import com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState;
import com.viewpagerindicator.LinePageIndicator;

public class MainActivity extends ActionBarActivity{

    public static String query ="";
    private static final String TAG = "DemoActivity";
    private SlidingUpPanelLayout mLayout;
    AppSectionsPagerAdapter mAppSectionsPagerAdapter;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAppSectionsPagerAdapter = new AppSectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mAppSectionsPagerAdapter);

        LinePageIndicator titleIndicator = (LinePageIndicator)findViewById(R.id.titles);
        titleIndicator.setViewPager(mViewPager);

        mLayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        mLayout.setPanelState(PanelState.HIDDEN);
        mLayout.setPanelSlideListener(new PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                Log.i(TAG, "onPanelSlide, offset " + slideOffset);
            }

            @Override
            public void onPanelExpanded(View panel) {
                Log.i(TAG, "onPanelExpanded");
                ActionBar actionBar = getSupportActionBar();
                actionBar.hide();

                ImageView img = (ImageView)findViewById(R.id.veg);
                img.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onPanelCollapsed(View panel) {
                Log.i(TAG, "onPanelCollapsed");
                ActionBar actionBar = getSupportActionBar();
                actionBar.show();
                ImageView img = (ImageView)findViewById(R.id.veg);
                img.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPanelAnchored(View panel) {
                Log.i(TAG, "onPanelAnchored");
            }

            @Override
            public void onPanelHidden(View panel) {
                Log.i(TAG, "onPanelHidden");
            }
        });

        final CheckBox cb_potato = (CheckBox) findViewById(R.id.potato);
        final CheckBox cb_carrot = (CheckBox) findViewById(R.id.carrot);
        final CheckBox cb_rice = (CheckBox) findViewById(R.id.rice);
        final CheckBox cb_pumpkin = (CheckBox) findViewById(R.id.pumpkin);
        final CheckBox cb_peas = (CheckBox) findViewById(R.id.peas);
        final CheckBox cb_spinach = (CheckBox) findViewById(R.id.spinach);
        final CheckBox cb_ladies_finger = (CheckBox) findViewById(R.id.ladies_finger);
        final CheckBox cb_apple = (CheckBox) findViewById(R.id.apple);
        final CheckBox cb_banana = (CheckBox) findViewById(R.id.banana);
        final CheckBox cb_mango = (CheckBox) findViewById(R.id.mango);
        final CheckBox cb_grape = (CheckBox) findViewById(R.id.grapes);
        final CheckBox cb_garlic = (CheckBox) findViewById(R.id.garlic);
        final CheckBox cb_ginger = (CheckBox) findViewById(R.id.ginger);
        final CheckBox cb_cashew = (CheckBox) findViewById(R.id.cahsew_nuts);
        final CheckBox cb_artichoke = (CheckBox) findViewById(R.id.artichoke);
        final CheckBox cb_avacado = (CheckBox) findViewById(R.id.avacado);
        final CheckBox cb_olives = (CheckBox) findViewById(R.id.olive);
        final CheckBox cb_watermelon = (CheckBox) findViewById(R.id.watermelon);
        final CheckBox cb_onion = (CheckBox) findViewById(R.id.onion);
        final CheckBox cb_tomato = (CheckBox) findViewById(R.id.tomato);
        final CheckBox cb_cucumber = (CheckBox) findViewById(R.id.cucumber);
        final CheckBox cb_radish = (CheckBox) findViewById(R.id.radish);
        final CheckBox cb_turnip = (CheckBox) findViewById(R.id.turnip);
        final CheckBox cb_beetroot = (CheckBox) findViewById(R.id.beetroot);
        final CheckBox cb_lettuce = (CheckBox) findViewById(R.id.lettuce);
        final CheckBox cb_beans = (CheckBox) findViewById(R.id.beans);
        final CheckBox cb_capsicum = (CheckBox) findViewById(R.id.capsicum);
        final CheckBox cb_eggplant = (CheckBox) findViewById(R.id.eggplant);
        final CheckBox cb_corn = (CheckBox) findViewById(R.id.corn);

        final Button button = (Button) findViewById(R.id.search);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (cb_carrot.isChecked()) query += "+carrot";
                if (cb_potato.isChecked()) query += "+potato";
                if (cb_rice.isChecked()) query += "+rice";
                if (cb_grape.isChecked()) query += "+grape";
                if (cb_pumpkin.isChecked()) query += "+pumpkin";
                if (cb_peas.isChecked()) query += "+peas";
                if (cb_spinach.isChecked()) query += "+spinach";
                if (cb_ladies_finger.isChecked()) query += "+Ladies+finger";
                if (cb_apple.isChecked()) query += "+apple";
                if (cb_banana.isChecked()) query += "+banana";
                if (cb_mango.isChecked()) query += "+mango";
                if (cb_garlic.isChecked()) query += "+garlic";
                if (cb_ginger.isChecked()) query += "+ginger";
                if (cb_cashew.isChecked()) query += "+cashew+nuts";
                if (cb_artichoke.isChecked()) query += "+artichoke";
                if (cb_avacado.isChecked()) query += "+avacado";
                if (cb_olives.isChecked()) query += "+olive";
                if (cb_watermelon.isChecked()) query += "+watermelon";
                if (cb_onion.isChecked()) query += "+onion";
                if (cb_tomato.isChecked()) query += "+tomato";
                if (cb_cucumber.isChecked()) query += "+cucumber";
                if (cb_radish.isChecked()) query += "+radish";
                if (cb_turnip.isChecked()) query += "+turnip";
                if (cb_beetroot.isChecked()) query += "+beetroot";
                if (cb_lettuce.isChecked()) query += "+lettuce";
                if (cb_beans.isChecked()) query += "+beans";
                if (cb_capsicum.isChecked()) query += "+capsicum";
                if (cb_eggplant.isChecked()) query += "+eggplant";
                if (cb_corn.isChecked()) query += "+corn";

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

        if (id == R.id.action_about) {
            Intent myIntent = new Intent(MainActivity.this, AboutActivity.class);
            MainActivity.this.startActivity(myIntent);
        }

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume(){
        query = "";
        super.onResume();
    }

    public static class AppSectionsPagerAdapter extends FragmentPagerAdapter {

        public AppSectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    // The first section of the app is the most interesting -- it offers
                    // a launchpad into the other demonstrations in this example application.
                    return new LaunchpadSectionFragment();

                default:
                    // The other sections of the app are dummy placeholders.
                    return new DummySectionFragment();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Section " + (position + 1);
        }
    }

    /**
     * A fragment that launches other parts of the demo application.
     */
    public static class LaunchpadSectionFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            Log.d("view inflated", "view inflated1");
            return rootView;
        }
    }


    /**
     * A dummy fragment representing a section of the app, but that simply displays dummy text.
     */
    public static class DummySectionFragment extends Fragment {

        public static final String ARG_SECTION_NUMBER = "section_number";

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_save, container, false);
            Log.d("view inflated", "view inflated2");

            final ImageButton button = (ImageButton) rootView.findViewById(R.id.butt);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent myIntent = new Intent(getActivity(), SimpleScannerActivity.class);
                    myIntent.putExtra("query", query);
                    getActivity().startActivity(myIntent);
                }
            });
            return rootView;
        }
    }

    @Override
    public void onBackPressed() {
        if (mLayout != null &&
                (mLayout.getPanelState() == PanelState.EXPANDED || mLayout.getPanelState() == PanelState.ANCHORED)) {
            mLayout.setPanelState(PanelState.COLLAPSED);
        } else {
            super.onBackPressed();
        }
    }
}
