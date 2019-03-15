package vn.edu.poly.androidnetworking;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    private TextView tvCount;
    private TextView tvName;


    private String url = "http://www.tapetee.com/api.php?latest";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCount = findViewById(R.id.tvCount);
        tvName = findViewById(R.id.tvName);


        ConnectivityManager connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo =
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);


        if (networkInfo.isConnected()){
            MyAsyncTask myAsyncTask = new MyAsyncTask();
            myAsyncTask.execute(url);
        }else Toast.makeText(this,"No Internet!",Toast.LENGTH_LONG).show();


        tvName.setText("Huy Nguyen");

    }


    class MyAsyncTask extends AsyncTask<String, Long, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();


        }

        @Override
        protected void onProgressUpdate(Long... values) {
            super.onProgressUpdate(values);


        }


        // ko thao tac vs cac thanh phan trong UI (Giao dien)
        @Override
        protected String doInBackground(String... arrays) {

            try {

                // doi tuong URL, dung de khoi tao dia chi request
                URL url = new URL(arrays[0]);

                // mo ket noi toi dia chi url
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


                // doc du lieu thong qua InputStream
                InputStream inputStream = httpURLConnection.getInputStream();

                // doc du lieu
                BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));

                StringBuilder total = new StringBuilder();

                for (String line; (line = r.readLine()) != null; ) {
                    total.append(line).append('\n');

                }

                return total.toString();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }


        // thao tac vs cac than phan trong UI
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if (s != null)
                tvName.setText(s);

        }


    }


}
