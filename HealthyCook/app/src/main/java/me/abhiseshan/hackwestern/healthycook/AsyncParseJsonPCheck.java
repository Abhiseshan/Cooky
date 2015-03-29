package me.abhiseshan.hackwestern.healthycook;

/**
 * Created by hp on 28-Mar-15.
 */

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Size;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toolbar;
import android.widget.RelativeLayout.LayoutParams;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hp on 02-Jan-15.
 */

public class AsyncParseJsonPCheck extends AsyncTask<String, String, String> {

    private Context mContext;
    private LinearLayout rootView;
    private int length;

    public AsyncParseJsonPCheck(Context context, LinearLayout rootView){
        this.mContext = context;
        this.rootView = rootView;
    }

    final String TAG = "AsyncTaskParseJson.java";

    static String uri;
    static String imageURL;
    static String price;

    // set your json string urhere
    String UrlP = "http://api.walmartlabs.com/v1/items?apiKey=2jby37devkvebwgrxzrzqzyj&upc="+ SimpleScannerActivity.UPCA;
    //String UrlP = "http://api.walmartlabs.com/v1/items?apiKey=2jby37devkvebwgrxzrzqzyj&upc=10001137891";
    // contacts JSONArray
    JSONArray dataJsonArr = null;

    @Override
    protected void onPreExecute() {
        Log.d("URLP", UrlP);
    }

    @Override
    protected String doInBackground(String... arg0) {

        try {

            // instantiate our json parser
            JsonParser jParser = new JsonParser();

            // get json string from url
            JSONObject json = jParser.getJSONFromUrl(UrlP);

            // get the array of users
            dataJsonArr = json.getJSONArray("items");
            Log.d("length: ", "length: " + dataJsonArr.length());

            length = dataJsonArr.length();

            // loop through all elements
            for (int i = 0; i < dataJsonArr.length(); i++) {

                JSONObject c = dataJsonArr.getJSONObject(i);

                uri = c.getString("name");
                imageURL = c.getString("largeImage");
                price = c.getString("salePrice");

                // show the values in our logcat
                Log.e("uri", uri);
                Log.e("Image URL", imageURL);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String strFromDoInBg) {

        if (length == 0){
            ImageView img = new ImageView(mContext);
            img.setLayoutParams(new Toolbar.LayoutParams(Toolbar.LayoutParams.FILL_PARENT, Toolbar.LayoutParams.FILL_PARENT));
            img.setImageDrawable(mContext.getResources().getDrawable(R.drawable.barcode_not_found));
            rootView.addView(img);
        } else {
                ImageView img = new ImageView(mContext);
                img.setLayoutParams(new Toolbar.LayoutParams(Toolbar.LayoutParams.FILL_PARENT, Toolbar.LayoutParams.WRAP_CONTENT));
                img.setScaleType(ImageView.ScaleType.CENTER);
                Picasso.with(mContext).load(imageURL).into(img);
                img.setId(R.id.layout1);
                rootView.addView(img);
                TextView tv = new TextView(mContext);
                tv.setText(uri);
                tv.setGravity(Gravity.CENTER | Gravity.BOTTOM);
                tv.setTextSize(20);
                tv.setTextColor(Color.BLACK);
                tv.setLayoutParams(new Toolbar.LayoutParams(Toolbar.LayoutParams.FILL_PARENT, Toolbar.LayoutParams.WRAP_CONTENT));
                TextView price_view = new TextView(mContext);
                price_view.setText("Price: " + price);
                price_view.setTextColor(Color.BLACK);
                price_view.setTextSize(30);
                rootView.addView(price_view);
                rootView.addView(tv);
        }
    }
}