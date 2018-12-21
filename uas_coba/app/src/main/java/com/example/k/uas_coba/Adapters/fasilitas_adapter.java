package com.example.k.uas_coba.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.k.uas_coba.Detail.DetailFasilitas;
import com.example.k.uas_coba.Models.FasilitasModel;
import com.example.k.uas_coba.R;
import com.example.k.uas_coba.Rest.ApiClient;
import com.squareup.picasso.Picasso;

import java.util.List;

public class fasilitas_adapter extends RecyclerView.Adapter<fasilitas_adapter.ViewHolder>
{
    private  List<FasilitasModel> mFasilitasModel;
    private Context mContext;

    public fasilitas_adapter(List<FasilitasModel> mFasilitasModel, Context mContext)
    {
        this.mFasilitasModel = mFasilitasModel;
        this.mContext = mContext;
    }

    @Override
    public fasilitas_adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fasilitas, parent, false);
        fasilitas_adapter.ViewHolder mViewHolder = new fasilitas_adapter.ViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(fasilitas_adapter.ViewHolder holder, final int position)
    {
        Picasso.with(mContext).load(ApiClient.BASE_IMG+ mFasilitasModel.get(position).getFoto_fasilitas()).into(holder.img);

        holder.img.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(mContext, DetailFasilitas.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("nama_fasilitas", mFasilitasModel.get(position).getNama_fasilitas());
                i.putExtra("deskripsi_fasilitas", mFasilitasModel.get(position).getDeskripsi_fasilitas());
                i.putExtra("latitude_fasilitas", mFasilitasModel.get(position).getLatitude_fasilitas());
                i.putExtra("longitude_fasilitas", mFasilitasModel.get(position).getLongitude_fasilitas());
                i.putExtra("foto_fasilitas", mFasilitasModel.get(position).getFoto_fasilitas());
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mFasilitasModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img;

        public ViewHolder(View itemView)
        {
            super(itemView);
            img = itemView.findViewById(R.id.img_itemFasilitas);
        }
    }
}