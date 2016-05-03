package com.infinite.coltoolbardemo;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        initializeViewsAdapter();
        loadData();
    }

    private void initializeViewsAdapter() {
        setSupportActionBar(toolbar);
        collapsingToolbarLayout.setTitle("这是collapsingToolbarLayout标题");
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        adapter = new RecyclerViewAdapter(getApplicationContext());
        recyclerView.setAdapter(adapter);
    }

    private void loadData() {
        Radio radio = new Radio("RecyclerView标题", R.mipmap.temp, "RecyclerView描述");
        List<Radio> radioList = new ArrayList<>();

        for (int i = 0; i < 20; i++)
            radioList.add(radio);

        adapter.setRadioList(radioList);
    }
}
