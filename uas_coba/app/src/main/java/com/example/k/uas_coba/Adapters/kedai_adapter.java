package com.example.k.uas_coba.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.k.uas_coba.Detail.DetailKedai;
import com.example.k.uas_coba.Models.KedaiModel;
import com.example.k.uas_coba.R;
import com.example.k.uas_coba.Rest.ApiClient;
import com.squareup.picasso.Picasso;

import java.util.List;

public class kedai_adapter extends RecyclerView.Adapter<kedai_adapter.ViewHolder>
{
    private  List<KedaiModel> mKedaiModel;
    private Context mContext;

    public kedai_adapter(List<KedaiModel> mKedaiModel, Context mContext)
    {
        this.mKedaiModel = mKedaiModel;
        this.mContext = mContext;
    }

    @Override
    public kedai_adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kedai, parent, false);
        kedai_adapter.ViewHolder mViewHolder = new kedai_adapter.ViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(kedai_adapter.ViewHolder holder, final int position)
    {
        Picasso.with(mContext).load(ApiClient.BASE_IMG+ mKedaiModel.get(position).getFoto_kedai()).into(holder.img);

        holder.img.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(mContext, DetailKedai.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("nama_kedai", mKedaiModel.get(position).getNama_kedai());
                i.putExtra("deskripsi_kedai", mKedaiModel.get(position).getDeskripsi_kedai());
                i.putExtra("latitude_kedai", mKedaiModel.get(position).getLatitude_kedai());
                i.putExtra("longitude_kedai", mKedaiModel.get(position).getLongitude_kedai());
                i.putExtra("foto_kedai", mKedaiModel.get(position).getFoto_kedai());
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mKedaiModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img;

        public ViewHolder(View itemView)
        {
            super(itemView);
            img = itemView.findViewById(R.id.img_itemKedai);
        }
    }
}