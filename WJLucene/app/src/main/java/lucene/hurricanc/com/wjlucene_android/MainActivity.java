package lucene.hurricanc.com.wjlucene_android;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private Bitmap bitmap = null;

    static final String SERVER_URL = new String ("http://192.168.1.4:8000");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final boolean isConnected = checkInternetConenction();

        final EditText textField1 = (EditText) findViewById(R.id.editText0);
        final EditText textField2 = (EditText) findViewById(R.id.editText1);
        final EditText textField3 = (EditText) findViewById(R.id.editText2);
        final EditText textField4 = (EditText) findViewById(R.id.editText3);
        final EditText textField5 = (EditText) findViewById(R.id.editText4);
        final EditText textField6 = (EditText) findViewById(R.id.editText5);
        final EditText textField7 = (EditText) findViewById(R.id.editText6);
        final EditText textField8 = (EditText) findViewById(R.id.editText7);
        final EditText textField9 = (EditText) findViewById(R.id.editText8);
        final EditText textField10 = (EditText) findViewById(R.id.editText9);
        final EditText textField11 = (EditText) findViewById(R.id.editText10);
        final EditText textField12 = (EditText) findViewById(R.id.editText11);
        final EditText textField13 = (EditText) findViewById(R.id.editText12);
        final EditText textField14 = (EditText) findViewById(R.id.editText13);
        final EditText textField15 = (EditText) findViewById(R.id.editText14);
        final EditText textField16 = (EditText) findViewById(R.id.editText15);
        final EditText textField17 = (EditText) findViewById(R.id.editText16);
        final EditText textField18 = (EditText) findViewById(R.id.editText17);

        Button searchButton = (Button) findViewById(R.id.searchButton);
        Button clearButton = (Button) findViewById(R.id.clearButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String stringQuery = new String("");

                try {
                    if (textField1.getText() != null && textField1.getText().length() != 0)
                        stringQuery = stringQuery + textField1.getTag().toString() + "=" + URLEncoder.encode(textField1.getText().toString(), "utf-8") + "&";
                    if (textField2.getText() != null && textField2.getText().length() != 0)
                        stringQuery = stringQuery + textField2.getTag().toString() + "=" + URLEncoder.encode(textField2.getText().toString(), "utf-8") + "&";
                    if (textField3.getText() != null && textField3.getText().length() != 0)
                        stringQuery = stringQuery + textField3.getTag().toString() + "=" + URLEncoder.encode(textField3.getText().toString(), "utf-8") + "&";
                    if (textField4.getText() != null && textField4.getText().length() != 0)
                        stringQuery = stringQuery + textField4.getTag().toString() + "=" + URLEncoder.encode(textField4.getText().toString(), "utf-8") + "&";
                    if (textField5.getText() != null && textField5.getText().length() != 0)
                        stringQuery = stringQuery + textField5.getTag().toString() + "=" + URLEncoder.encode(textField5.getText().toString(), "utf-8") + "&";
                    if (textField6.getText() != null && textField6.getText().length() != 0)
                        stringQuery = stringQuery + textField6.getTag().toString() + "=" + URLEncoder.encode(textField6.getText().toString(), "utf-8") + "&";
                    if (textField7.getText() != null && textField7.getText().length() != 0)
                        stringQuery = stringQuery + textField7.getTag().toString() + "=" + URLEncoder.encode(textField7.getText().toString(), "utf-8") + "&";
                    if (textField8.getText() != null && textField8.getText().length() != 0)
                        stringQuery = stringQuery + textField8.getTag().toString() + "=" + URLEncoder.encode(textField8.getText().toString(), "utf-8") + "&";
                    if (textField9.getText() != null && textField9.getText().length() != 0)
                        stringQuery = stringQuery + textField9.getTag().toString() + "=" + URLEncoder.encode(textField9.getText().toString(), "utf-8") + "&";
                    if (textField10.getText() != null && textField10.getText().length() != 0)
                        stringQuery = stringQuery + textField10.getTag().toString() + "=" + URLEncoder.encode(textField10.getText().toString(), "utf-8") + "&";
                    if (textField11.getText() != null && textField11.getText().length() != 0)
                        stringQuery = stringQuery + textField11.getTag().toString() + "=" + URLEncoder.encode(textField11.getText().toString(), "utf-8") + "&";
                    if (textField12.getText() != null && textField12.getText().length() != 0)
                        stringQuery = stringQuery + textField12.getTag().toString() + "=" + URLEncoder.encode(textField12.getText().toString(), "utf-8") + "&";
                    if (textField13.getText() != null && textField13.getText().length() != 0)
                        stringQuery = stringQuery + textField13.getTag().toString() + "=" + URLEncoder.encode(textField13.getText().toString(), "utf-8") + "&";
                    if (textField14.getText() != null && textField14.getText().length() != 0)
                        stringQuery = stringQuery + textField14.getTag().toString() + "=" + URLEncoder.encode(textField14.getText().toString(), "utf-8") + "&";
                    if (textField15.getText() != null && textField15.getText().length() != 0)
                        stringQuery = stringQuery + textField15.getTag().toString() + "=" + URLEncoder.encode(textField15.getText().toString(), "utf-8") + "&";
                    if (textField16.getText() != null && textField16.getText().length() != 0)
                        stringQuery = stringQuery + textField16.getTag().toString() + "=" + URLEncoder.encode(textField16.getText().toString(), "utf-8") + "&";
                    if (textField17.getText() != null && textField17.getText().length() != 0)
                        stringQuery = stringQuery + textField17.getTag().toString() + "=" + URLEncoder.encode(textField17.getText().toString(), "utf-8") + "&";
                    if (textField18.getText() != null && textField18.getText().length() != 0)
                        stringQuery = stringQuery + textField18.getTag().toString() + "=" + URLEncoder.encode(textField18.getText().toString(), "utf-8") + "&";

                    String newString = new String("");
                    if (stringQuery.length() > 0)
                        newString = stringQuery.substring(0, stringQuery.length() - 1);

                    String completeURL = new String(SERVER_URL+"/search?" + newString);
                    Log.v("WOOJRL", completeURL);

                    if (isConnected) {
                        Toast.makeText(MainActivity.this," FETCHING DATA FROM SERVER ",Toast.LENGTH_LONG).show();
                        downloadData(completeURL);
                    } else
                        Toast.makeText(MainActivity.this," NO INTERNET CONNECTIVITY ",Toast.LENGTH_LONG).show();

                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
                textField6.setText("");
                textField7.setText("");
                textField8.setText("");
                textField9.setText("");
                textField10.setText("");
                textField11.setText("");
                textField12.setText("");
                textField13.setText("");
                textField14.setText("");
                textField15.setText("");
                textField16.setText("");
                textField17.setText("");
                textField18.setText("");
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


    private void downloadData(final String urlStr) {
        final String url = urlStr;

        new Thread() {
            public void run() {
                InputStream in = null;

                try {

                    in = openHttpConnection(url);

                    int ch;
                    StringBuffer sb = new StringBuffer();
                    while ((ch = in.read()) != -1) {
                        sb.append((char) ch);
                    }
                    Log.v("WOOJIN", sb.toString());

                    String json = sb.toString();

                    try {

                        JSONObject obj = new JSONObject(json);
                        Log.d("WOOJSON", obj.toString());

                        if (obj.getString("Status").equalsIgnoreCase("successful")) {

                            JSONArray newsArray = new JSONArray();
                            newsArray = obj.getJSONArray("News");

                            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                            intent.putExtra("key", obj.toString());
                            startActivity(intent);
                        }
                        else {

                            Toast.makeText(MainActivity.this," NO RESULT ",Toast.LENGTH_LONG).show();
                        }


                    } catch (Throwable t) {
                        Log.e("WOOJSON", "Could not parse malformed JSON: \"" + json + "\"");
                    }

                    in.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }.start();
    }

    private InputStream openHttpConnection(String urlStr) {
        InputStream in = null;
        int resCode = -1;

        try {
            URL url = new URL(urlStr);
            URLConnection urlConn = url.openConnection();

            if (!(urlConn instanceof HttpURLConnection)) {
                throw new IOException("URL is not an Http URL");
            }
            HttpURLConnection httpConn = (HttpURLConnection) urlConn;
            httpConn.setAllowUserInteraction(false);
            httpConn.setInstanceFollowRedirects(true);
            httpConn.setRequestMethod("GET");
            httpConn.connect();
            resCode = httpConn.getResponseCode();

            if (resCode == HttpURLConnection.HTTP_OK) {
                in = httpConn.getInputStream();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return in;
    }

    private boolean checkInternetConenction() {
        // get Connectivity Manager object to check connection
        ConnectivityManager connec = (ConnectivityManager) getSystemService(getBaseContext().CONNECTIVITY_SERVICE);

        // Check for network connections
        if (connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTED || connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTING || connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTING || connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED) {

            Toast.makeText(this, " Connected ", Toast.LENGTH_LONG).show();
            return true;

        } else if (connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.DISCONNECTED || connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.DISCONNECTED) {

            Toast.makeText(this, " Not Connected ", Toast.LENGTH_LONG).show();
            return false;
        }

        return false;
    }

}
