package com.example.k.uas_coba.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.k.uas_coba.Detail.DetailMerchandise;
import com.example.k.uas_coba.Models.MerchandiseModel;
import com.example.k.uas_coba.R;
import com.example.k.uas_coba.Rest.ApiClient;
import com.squareup.picasso.Picasso;

import java.util.List;

public class merchandise_adapter extends RecyclerView.Adapter<merchandise_adapter.ViewHolder>
{
    private List<MerchandiseModel> mMerchandise;
    private Context mContext;

    public merchandise_adapter(List<MerchandiseModel> mMerchandise, Context mContext) {
        this.mMerchandise = mMerchandise;
        this.mContext = mContext;
    }

    @Override
    public merchandise_adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_merchandise, parent, false);
        merchandise_adapter.ViewHolder mViewHolder = new merchandise_adapter.ViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Picasso.with(mContext).load(ApiClient.BASE_IMG+mMerchandise.get(position).getFoto_merchandise()).into(holder.img);

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext, DetailMerchandise.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("nama_merchandise", mMerchandise.get(position).getNama_merchandise());
                i.putExtra("deskripsi_merchandise", mMerchandise.get(position).getDeskripsi_merchandise());
                i.putExtra("foto_merchandise", mMerchandise.get(position).getFoto_merchandise());
                i.putExtra("poin_merchandise", mMerchandise.get(position).getPoin_merchandise());
                i.putExtra("harga_merchandise", mMerchandise.get(position).getHarga_merchandise());
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMerchandise.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_itemMerchandise);
        }
    }
}