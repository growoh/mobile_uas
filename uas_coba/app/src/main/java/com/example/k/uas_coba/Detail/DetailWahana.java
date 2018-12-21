package com.example.k.uas_coba.Detail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.k.uas_coba.Map.Map;
import com.example.k.uas_coba.Models.WahanaModel;
import com.example.k.uas_coba.R;
import com.example.k.uas_coba.Rest.ApiClient;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailWahana extends AppCompatActivity {
    ImageView img_Wahana;
    TextView txt_Nama, txt_Deskripsi, txt_Jadwal, txt_Poin;
    Button btn_Map, btn_Poin;
    private List<WahanaModel> mWahanaModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wahana);

        final Intent i = getIntent();

        img_Wahana = findViewById(R.id.detailwahana_imgWahana);
        txt_Nama = findViewById(R.id.detailwahana_txtNama);
        txt_Deskripsi = findViewById(R.id.detailwahana_txtDeskripsi);
        txt_Jadwal = findViewById(R.id.detailwahana_txtJadwal);
        txt_Poin = findViewById(R.id.detailwahana_txtPoin);
        btn_Map = findViewById(R.id.detailwahana_btnViewmap);

        Picasso.with(getApplicationContext()).load(ApiClient.BASE_IMG+i.getStringExtra("foto_wahana")).into(img_Wahana);
        txt_Nama.setText(i.getStringExtra("nama_wahana"));
        txt_Deskripsi.setText(i.getStringExtra("deskripsi_wahana"));
        txt_Jadwal.setText(i.getStringExtra("jadwal_wahana"));
        txt_Poin.setText(i.getStringExtra("poin_wahana"));

        btn_Map.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent in = new Intent(getApplicationContext(), Map.class);

                in.putExtra("latitude", i.getDoubleExtra("latitude_wahana",0));
                in.putExtra("longitude", i.getDoubleExtra("longitude_wahana",0));

                startActivity(in);
            }
        });
    }
}