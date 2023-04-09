package com.kbu.exam.gsonparsing;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GsonGetParsingAsyncTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... strings) {
        String result = "";
        util util = new util();
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
//                stringBuilder.append(line);
                result += line;
            }
            bufferedReader.close();
            inputStream.close();
        } catch (Exception e) {
            Log.e("TRAMS_GGPAT_ERROR", util.getLogInfo()+e.getMessage());
        }
        return result;
    }
}
