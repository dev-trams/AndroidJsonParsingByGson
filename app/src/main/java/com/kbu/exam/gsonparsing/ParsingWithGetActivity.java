package com.kbu.exam.gsonparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ParsingWithGetActivity extends AppCompatActivity {
    Users users = new Users();
    String baseUrl = "https://reqres.in/api/users?page=2";
    ArrayList<Users> usersArrayList;
    String json = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parsing_with_get);
        util util = new util();
        Button pwg_btn = (Button) findViewById(R.id.pwg_btn1);
        ListView pwg_list = (ListView) findViewById(R.id.pwg_list);

        pwg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GsonGetParsingAsyncTask asyncTask = new GsonGetParsingAsyncTask();
                try {
                    json = asyncTask.execute(baseUrl).get();
                    ParsingJson parsingJson = new ParsingJson();
                    usersArrayList = parsingJson.parsingJson(json);
//                    Gson gson = new Gson();
//                    Type type = new TypeToken<ArrayList<Users>>(){}.getType();
//                    usersArrayList = gson.fromJson(json, type);
                } catch (ExecutionException | InterruptedException | JSONException e) {
                    Log.e("TRAMS_ERROR_PWG", util.getLogInfo() + e.getMessage());
                }
                CustomAdapter customAdapter = new CustomAdapter(ParsingWithGetActivity.this, usersArrayList);
                pwg_list.setAdapter(customAdapter);
            }
        });
    }
}