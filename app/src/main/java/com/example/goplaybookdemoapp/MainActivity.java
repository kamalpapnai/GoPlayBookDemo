package com.example.goplaybookdemoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView parentRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ModelClass> modelClasses = new ArrayList<>();

        modelClasses.add(new ModelClass(0,R.drawable.footballpic,getResources().getString(R.string.match_name2),getResources().getString(R.string.match_date)
                ,getResources().getString(R.string.match_time),getResources().getString(R.string.match_place),
                R.mipmap.chennai,R.drawable.mumbailogo,"260/4","265/4","Chennai Super Kings","Mumbai Indians"));

        modelClasses.add(new ModelClass(1,R.drawable.footballpic,getResources().getString(R.string.match_name),"2 hrs ago"
                       ,getResources().getString(R.string.demo_description), R.raw.sports,"495","925K Views","98"));
       modelClasses.add(new ModelClass(0,R.drawable.footballpic,getResources().getString(R.string.match_name2),getResources().getString(R.string.match_date)
               ,getResources().getString(R.string.match_time),getResources().getString(R.string.match_place),
               R.mipmap.chennai,R.drawable.mumbailogo,"260/4","265/4","Chennai Super Kings","Mumbai Indians"));
        modelClasses.add(new ModelClass(1,R.drawable.footballpic,getResources().getString(R.string.match_name2),"1 hrs ago"
                ,getResources().getString(R.string.demo_description), R.raw.sports,"2495","48K Views","498"));

        parentRecyclerView = (RecyclerView)findViewById(R.id.main_recycler_view);
        MainAdapter videoAdapter = new MainAdapter(this, modelClasses);
        parentRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        parentRecyclerView.setAdapter(videoAdapter);


    }
}
