package com.example.k.uas_coba.Detail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.k.uas_coba.Map.Map;
import com.example.k.uas_coba.Models.FasilitasModel;
import com.example.k.uas_coba.R;
import com.example.k.uas_coba.Rest.ApiClient;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailFasilitas extends AppCompatActivity {
    ImageView img_Fasilitas;
    TextView txt_Nama, txt_Deskripsi;
    Button btn_Map, btn_Poin;
    private List<FasilitasModel> mFasilitasModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_fasilitas);

        final Intent i = getIntent();

        img_Fasilitas = findViewById(R.id.detailfasilitas_imgFasilitas);
        txt_Nama = findViewById(R.id.detailfasilitas_txtNama);
        txt_Deskripsi = findViewById(R.id.detailfasilitas_txtDeskripsi);
        btn_Map = findViewById(R.id.detailfasilitas_btnViewmap);

        Picasso.with(getApplicationContext()).load(ApiClient.BASE_IMG+i.getStringExtra("foto_fasilitas")).into(img_Fasilitas);
        txt_Nama.setText(i.getStringExtra("nama_fasilitas"));
        txt_Deskripsi.setText(i.getStringExtra("deskripsi_fasilitas"));

        btn_Map.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent in = new Intent(getApplicationContext(), Map.class);

                in.putExtra("latitude", i.getDoubleExtra("latitude_fasilitas",0));
                in.putExtra("longitude", i.getDoubleExtra("longitude_fasilitas",0));

                startActivity(in);
            }
        });
    }
}