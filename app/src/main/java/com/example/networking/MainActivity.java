package com.example.networking;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
    private final String JSON_FILE = "mountains.json";
    private final String TAG = "==>";

    private RecyclerView recyclerView;
    private ArrayList<Mountain> listOfMountain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //new JsonFile(this, this).execute(JSON_FILE);
        // läser in en textfil, startar execute när färdig
        new JsonTask(this).execute(JSON_URL);

        recyclerView = findViewById(R.id.my_recycler);

    }

    @Override
    public void onPostExecute(String json) {
        Log.d(TAG, json);
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Mountain>>() {}.getType();
        listOfMountain = gson.fromJson(json, type);

        Log.d(TAG, "Numbers of elements "+listOfMountain.size());
        Log.d(TAG, "Element 0 "+listOfMountain.get(0).toString());
    }

}
