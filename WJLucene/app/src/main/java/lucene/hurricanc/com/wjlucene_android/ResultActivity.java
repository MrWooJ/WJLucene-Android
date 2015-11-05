package lucene.hurricanc.com.wjlucene_android;

/**
 * Created by Hurricanc on 11/4/15.
 */

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ResultActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_main);

        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Intent intent = getIntent();
        String value = intent.getExtras().getString("key");

        JSONObject obj = null;
        try {
            obj = new JSONObject(value);
            JSONArray newsArray = new JSONArray();
            newsArray = obj.getJSONArray("News");


            for (int i = 0; i < newsArray.length(); i++) {

                JSONObject News = newsArray.getJSONObject(i);
                String title = News.getString("Title");
                String number = News.getString("Number");
                String URL = News.getString("URL");

                Log.v("WOOJNUM", number);

                this.setFirstBlock(number, URL);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void setFirstBlock(String number, final String url) {
        TableLayout tableView = (TableLayout) findViewById(R.id.tableLayout1);
        Button btn = new Button(this);
        btn.setText("NEWS NUMBER: " + number);
        btn.setBackgroundColor(0xE6FAFF);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);
            }
        });
        //TableLayout.LayoutParams lp = new TableLayout.LayoutParams(tableView.getLayoutParams());
        tableView.addView(btn);
    }

    private View tableChild(String number, final String URL) {

        TableRow tr = new TableRow(this);
        View v = LayoutInflater.from(this).inflate(R.layout.custom_tablerow, tr, true);
        TextView tv = (TextView) v.findViewById(R.id.title);
        tv.setText("NEWS NUMBER: " + number);
        Button btn = (Button) v.findViewById(R.id.openURL);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
                startActivity(browserIntent);
            }
        });
        return v;
    }

}