package me.abhiseshan.hackwestern.healthycook;

/**
 * Created by hp on 28-Mar-15.
 */

        import android.content.Context;
        import android.content.Intent;
        import android.os.AsyncTask;
        import android.util.Log;
        import android.view.Gravity;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.RelativeLayout;
        import android.widget.ScrollView;
        import android.widget.TextView;
        import android.widget.Toolbar;

        import com.squareup.picasso.Picasso;

        import java.lang.String;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;
        import org.w3c.dom.Text;

/**
 * Created by hp on 02-Jan-15.
 */

public class AsyncParseJson extends AsyncTask<String, String, String> {

    private Context mContext;
    private LinearLayout rootView;

    public AsyncParseJson(Context context, LinearLayout rootView){
        this.mContext = context;
        this.rootView = rootView;
    }

    final String TAG = "AsyncTaskParseJson.java";

    static String[] uri = new String[30];
    static String[] imageURL = new String[50];

    // set your json string url here
    String Url = "https://api.edamam.com/search?q="+ SearchResultsActivity.query +"&app_id=bf82eb80&app_key=dca27d31f73acda5c232a602b0c832a0";

    // contacts JSONArray
    JSONArray dataJsonArr = null;

    @Override
    protected void onPreExecute() {
        Log.d("URL", Url + SearchResultsActivity.query);
    }

    @Override
    protected String doInBackground(String... arg0) {

        try {

            // instantiate our json parser
            JsonParser jParser = new JsonParser();

            // get json string from url
            JSONObject json = jParser.getJSONFromUrl(Url);

            // get the array of users
            dataJsonArr = json.getJSONArray("hits");
            Log.d("length: ", "length: " + dataJsonArr.length());

            // loop through all elements
            for (int i = 0; i < dataJsonArr.length(); i++) {

                JSONObject c = dataJsonArr.getJSONObject(i);

                uri[i] = c.getJSONObject("recipe").getString("label");
                imageURL[i] = c.getJSONObject("recipe").getString("image");

                // show the values in our logcat
                Log.e("uri", uri[i]);
                Log.e("Image URL", imageURL[i]);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String strFromDoInBg) {
         for (int i=0; i< 10; i++){
             RelativeLayout rl = new RelativeLayout(mContext);
             rl.setPadding(0,0,0,10);
             ImageView img = new ImageView(mContext);
             img.setLayoutParams(new Toolbar.LayoutParams(Toolbar.LayoutParams.FILL_PARENT, Toolbar.LayoutParams.FILL_PARENT));
             img.setScaleType(ImageView.ScaleType.CENTER_CROP);
             //img.setMaxHeight(300);
             Picasso.with(mContext).load(imageURL[i]).into(img);
             rl.addView(img);
             TextView tv = new TextView(mContext);
             tv.setText(uri[i]);
             tv.setGravity(Gravity.CENTER | Gravity.BOTTOM);
             tv.setTextSize(20);
             tv.setLayoutParams(new Toolbar.LayoutParams(Toolbar.LayoutParams.FILL_PARENT, Toolbar.LayoutParams.WRAP_CONTENT));
             rl.addView(tv);
             rootView.addView(rl);
         }
    }
}