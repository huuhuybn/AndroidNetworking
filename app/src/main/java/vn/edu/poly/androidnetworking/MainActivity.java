package vn.edu.poly.androidnetworking;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView tvCount;
    private TextView tvName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCount = findViewById(R.id.tvCount);
        tvName = findViewById(R.id.tvName);




        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute();

        tvName.setText("Huy Nguyen");

    }


    class MyAsyncTask extends AsyncTask<String,Long,Integer> {


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
        protected Integer doInBackground(String... arrays) {

            for (int i = 0; i < 1000; i++) {
                Log.e("AA", i + "");
            }
            return null;
        }


        // thao tac vs cac than phan trong UI
        @Override
        protected void onPostExecute(Integer s) {
            super.onPostExecute(s);

        }


    }



}
