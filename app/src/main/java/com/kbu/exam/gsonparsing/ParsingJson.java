package com.kbu.exam.gsonparsing;


import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ParsingJson {
    public ParsingJson() {
    }

    public ArrayList<Users> parsingJson(String json) throws JSONException {
        ArrayList<Users> _users = new ArrayList<>();
        JSONObject rootObject = new JSONObject(json);
        JSONArray subArray = rootObject.getJSONArray("data");
        for (int i = 0; i < subArray.length(); i++) {
            Users users = new Users();
            JSONObject jsonObject = (JSONObject) subArray.getJSONObject(i);
            String imageUrl = jsonObject.getString((String) jsonObject.names().get(4));
            String id = jsonObject.getString((String) jsonObject.names().get(0));
            String name = jsonObject.getString((String) jsonObject.names().get(2))
                    .concat(" "+jsonObject.getString((String) jsonObject.names().get(3)));
            String email = jsonObject.getString((String) jsonObject.names().get(1));

            users.setImageUrl(imageUrl);
            users.setId(id);
            users.setName(name);
            users.setEmail(email);
            _users.add(users);
        }
        return _users;
    }

}
