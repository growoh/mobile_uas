package com.example.k.uas_coba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class Beranda extends AppCompatActivity
{
    private ArrayList<Integer> mImagesUrl = new ArrayList<>();
    private ArrayList<Event> mUser = new ArrayList<>();

    private RecyclerView.Adapter madapter;
    private RecyclerView.LayoutManager laymanager;

    ImageView img_event;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

        getImages();
        initRecyclerview();

        img_event = (ImageView) findViewById(R.id.img_itemEvent);
    }

    private void getImages()
    {
        mImagesUrl.add(R.drawable.ev_1);
        mImagesUrl.add(R.drawable.ev_1);
        mImagesUrl.add(R.drawable.ev_1);
    }

    private void  initRecyclerview()
    {
        laymanager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerViewww = findViewById(R.id.beranda_rcyEvent);
        recyclerViewww.setLayoutManager(laymanager);

        madapter = new event_adapter(mImagesUrl,this);
        recyclerViewww.setAdapter(madapter);

        recyclerViewww.setHasFixedSize(true);

    }
}
