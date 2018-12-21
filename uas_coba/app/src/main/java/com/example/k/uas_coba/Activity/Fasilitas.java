package com.example.k.uas_coba.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.k.uas_coba.Adapters.fasilitas_adapter;
import com.example.k.uas_coba.Models.FasilitasModel;
import com.example.k.uas_coba.Models.FasilitasRespon;
import com.example.k.uas_coba.R;
import com.example.k.uas_coba.Rest.ApiClient;
import com.example.k.uas_coba.Rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class Fasilitas extends AppCompatActivity
{
    private List<FasilitasModel> mFasilitasModel = new ArrayList<>();
    private RecyclerView.LayoutManager laymanager;

    ImageView img_Fasilitas, img_Beranda;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fasilitas);

        initRecyclerview();

        img_Fasilitas = (ImageView) findViewById(R.id.img_itemFasilitas);

        img_Beranda = findViewById(R.id.beranda_fasilitas);

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
        final RecyclerView mRecyclerView = findViewById(R.id.fasilitas_recyclerview);
        mRecyclerView.setLayoutManager(laymanager);

        mRecyclerView.setHasFixedSize(true);

        ApiInterface apiService=ApiClient.getClient().create(ApiInterface.class);
        retrofit2.Call<FasilitasRespon> call = apiService.getFasilitas();

        call.enqueue(new Callback<FasilitasRespon>()
        {
            @Override
            public void onResponse(retrofit2.Call<FasilitasRespon> call, Response<FasilitasRespon> response)
            {
                mFasilitasModel = response.body().getFasilitasModelList();

                Log.e("Pesan",response.body().getStatus());

                mRecyclerView.setAdapter(new fasilitas_adapter(mFasilitasModel,getApplicationContext()));
            }

            @Override
            public void onFailure(retrofit2.Call<FasilitasRespon> call, Throwable t)
            {
                Log.e("Error",t.toString());
            }
        });
    }
}