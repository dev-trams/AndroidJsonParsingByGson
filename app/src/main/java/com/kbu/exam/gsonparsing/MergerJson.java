package com.kbu.exam.gsonparsing;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MergerJson {
    public ArrayList<Infos> inJson(String s1, String s2){
        util util = new util();
        ArrayList<Infos> _infos = new ArrayList<>();
        try {
            //인터넷에서 받아온 JSON Object 저장소
            JSONObject mergerRootObject1 = new JSONObject(s1);
            //로컬에서 받아온 JSON Object 저장소
            JSONObject mergerRootObject2 = new JSONObject(s2);

            Log.d("TRAMS_INFO_MJ", util.getLogInfo()+mergerRootObject1.getString("id"));
                Infos infos = new Infos();
                String id = mergerRootObject1.getString("id");
                String createAt = (String) mergerRootObject1.getString("createdAt");
                String name = mergerRootObject2.getString("name");
                String address = mergerRootObject2.getString("address");

                infos.setId(id);
                infos.setCreateAt(createAt);
                infos.setName(name);
                infos.setAddress(address);
                _infos.add(infos);

        } catch (JSONException e) {
            Log.e("TRAMS_ERROR_MJ", util.getLogInfo()+e.getMessage());
        }

        return _infos;
    }
}
