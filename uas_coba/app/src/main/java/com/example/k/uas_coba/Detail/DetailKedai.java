package com.example.k.uas_coba.Detail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.k.uas_coba.Map.Map;
import com.example.k.uas_coba.Models.KedaiModel;
import com.example.k.uas_coba.R;
import com.example.k.uas_coba.Rest.ApiClient;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailKedai extends AppCompatActivity {
    ImageView img_Kedai;
    TextView txt_Nama, txt_Deskripsi;
    Button btn_Map, btn_Poin;
    private List<KedaiModel> mKedaiModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kedai);

        final Intent i = getIntent();

        img_Kedai = findViewById(R.id.detailkedai_imgKedai);
        txt_Nama = findViewById(R.id.detailkedai_txtNama);
        txt_Deskripsi = findViewById(R.id.detailkedai_txtDeskripsi);
        btn_Map = findViewById(R.id.detailkedai_btnViewmap);

        Picasso.with(getApplicationContext()).load(ApiClient.BASE_IMG+i.getStringExtra("foto_kedai")).into(img_Kedai);
        txt_Nama.setText(i.getStringExtra("nama_kedai"));
        txt_Deskripsi.setText(i.getStringExtra("deskripsi_kedai"));

        btn_Map.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent in = new Intent(getApplicationContext(), Map.class);

                in.putExtra("latitude", i.getDoubleExtra("latitude_kedai",0));
                in.putExtra("longitude", i.getDoubleExtra("longitude_kedai",0));

                startActivity(in);
            }
        });
    }
}