package com.kbu.exam.gsonparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ParsingWithPostActivity extends AppCompatActivity {

    String name = "";
    String address = "";
    final String baseUrl = "https://reqres.in/api/users";
    String networkJson = "";
    ArrayList<Infos> inJson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parsing_with_post);
        util util = new util();

        Button btn1 = (Button) findViewById(R.id.pwp_btn1);
        EditText getNameText = (EditText) findViewById(R.id.pwp_edit1);
        EditText getAddressText = (EditText) findViewById(R.id.pwp_edit2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = getNameText.getText().toString();
                address = getAddressText.getText().toString();
                Gson gson = new Gson();
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("name", name);
                jsonObject.addProperty("address", address);
                String json = gson.toJson(jsonObject);
                TextView textView = (TextView) findViewById(R.id.pwp_view);
                GsonPostParsingAsyncTask asyncTask = new GsonPostParsingAsyncTask();
                try {
                    networkJson = asyncTask.execute(baseUrl).get();
                    MergerJson mergerJson = new MergerJson();
                    inJson = mergerJson.inJson(networkJson, json);
                    Log.d("TRAMS_INFO_PWP", util.getLogInfo().concat("[id]").concat(inJson.get(0).id).concat("[createdAt]").concat(inJson.get(0).createAt).concat("[name]").concat(inJson.get(0).name).concat("[address]").concat(inJson.get(0).address));
                } catch (ExecutionException | InterruptedException e) {
                    Log.e("TRAMS_ERROR_PWP", e.getMessage());
                }
                Gson gson1 = new Gson();

                textView.setText(gson1.toJson(inJson));
            }
        });
    }
}