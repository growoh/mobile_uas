package com.example.k.uas_coba.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.k.uas_coba.Adapters.kedai_adapter;
import com.example.k.uas_coba.Models.KedaiModel;
import com.example.k.uas_coba.Models.KedaiRespon;
import com.example.k.uas_coba.R;
import com.example.k.uas_coba.Rest.ApiClient;
import com.example.k.uas_coba.Rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class Kedai extends AppCompatActivity
{
    private List<KedaiModel> mKedaiModel = new ArrayList<>();
    private RecyclerView.LayoutManager laymanager;

    ImageView img_Kedai, img_Beranda;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kedai);

        initRecyclerview();

        img_Kedai = (ImageView) findViewById(R.id.img_itemKedai);

        img_Beranda = findViewById(R.id.beranda_kedai);

        img_Beranda.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(getApplicationContext(), Beranda.class);
                startActivity(i);
            }
        });
    }

    private void  initRecyclerview()
    {
        laymanager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        final RecyclerView mRecyclerView = findViewById(R.id.kedai_recyclerview);
        mRecyclerView.setLayoutManager(laymanager);

        mRecyclerView.setHasFixedSize(true);

        ApiInterface apiService=ApiClient.getClient().create(ApiInterface.class);
        retrofit2.Call<KedaiRespon> call = apiService.getKedai();

        call.enqueue(new Callback<KedaiRespon>()
        {
            @Override
            public void onResponse(retrofit2.Call<KedaiRespon> call, Response<KedaiRespon> response)
            {
                mKedaiModel = response.body().getKedaiModelList();

                Log.e("Pesan",response.body().getStatus());

                mRecyclerView.setAdapter(new kedai_adapter(mKedaiModel,getApplicationContext()));
            }

            @Override
            public void onFailure(retrofit2.Call<KedaiRespon> call, Throwable t)
            {
                Log.e("Error",t.toString());
            }
        });
    }
}