package com.example.k.uas_coba;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by k on 11/11/2018.
 */

public class event_adapter extends RecyclerView.Adapter<event_adapter.ViewHolder>
{
    public static final String TAG="RecyclerViewAdapter";

    private ArrayList<Integer> mImagesUrl = new ArrayList<>();
    private Context mContext;

    public event_adapter(ArrayList<Integer> mImagesUrl, Context mContext)
    {
        this.mImagesUrl = mImagesUrl;
        this.mContext = mContext;
    }

    @Override
    public event_adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        Log.d(TAG, "onCreateViewHolder: called");

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event,parent,false);

        return new event_adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(event_adapter.ViewHolder holder, final int position)
    {
        Log.d(TAG, "onBindViewHolder: called");

        holder.mImages.setImageResource(mImagesUrl.get(position));
    }


    @Override
    public int getItemCount()
    {
        return mImagesUrl.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView mImages;
        TextView mTextNama;

        public ViewHolder(View itemView)
        {
            super(itemView);
            mImages = itemView.findViewById(R.id.img_itemEvent);
        }
    }
}
