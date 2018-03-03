package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        Sandwich sandwich = new Sandwich();
        List<String> alsoKnownAsList = new ArrayList<>();
        List<String> ingredienceList = new ArrayList<>();

        try {

            JSONObject jsonObject = new JSONObject(json);

            JSONObject name = jsonObject.getJSONObject("name");

            //Get MainName
            String mainName = name.getString("mainName");

            //Get all KnownAs in the Array
            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
            for (int i = 0; i < alsoKnownAs.length(); i++) {
                if (alsoKnownAs.length() != 0) {
                    String knownAsName = alsoKnownAs.getString(i);
                    String knownAs = String.valueOf(knownAsName);
                    alsoKnownAsList.add(knownAs);
                }
            }
            String placeOfOrigin = "";

            if (jsonObject.has("placeOfOrigin")) {
                placeOfOrigin = jsonObject.getString("placeOfOrigin");
            }

            String description = jsonObject.getString("description");

            String image = jsonObject.getString("image");

            //Get all KnownAs in the Array
            JSONArray ingrediences = jsonObject.getJSONArray("ingredients");
            for (int i = 0; i < ingrediences.length(); i++) {
                if (ingrediences.length() != 0) {
                    String ingredientsName = ingrediences.getString(i);
                    String ingredients = String.valueOf(ingredientsName);
                    ingredienceList.add(ingredients);
                }
            }

            sandwich = new Sandwich(mainName, alsoKnownAsList, placeOfOrigin, description, image, ingredienceList);
            return sandwich;

        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        return sandwich;
    }

}
