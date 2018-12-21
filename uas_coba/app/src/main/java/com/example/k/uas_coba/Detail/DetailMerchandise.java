package com.example.k.uas_coba.Detail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.k.uas_coba.Map.Map;
import com.example.k.uas_coba.R;
import com.example.k.uas_coba.Rest.ApiClient;
import com.squareup.picasso.Picasso;

public class DetailMerchandise extends AppCompatActivity {
    ImageView img_Merchandise;
    TextView txt_Nama, txt_Deskripsi, txt_Harga, txt_Poin;
    Button btn_Map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_merchandise);

        Intent i = getIntent();

        img_Merchandise = findViewById(R.id.detailmerchandise_imgMerchandise);
        txt_Nama = findViewById(R.id.detailmerchandise_txtNama);
        txt_Deskripsi = findViewById(R.id.detailmerchandise_txtDeskripsi);
        txt_Harga = findViewById(R.id.detailmerchandise_txtHarga);
        txt_Poin = findViewById(R.id.detailmerchandise_txtPoin);

        Picasso.with(getApplicationContext()).load(ApiClient.BASE_IMG+i.getStringExtra("foto_merchandise")).into(img_Merchandise);
        txt_Nama.setText(i.getStringExtra("nama_merchandise"));
        txt_Deskripsi.setText(i.getStringExtra("deskripsi_merchandise"));
        txt_Poin.setText(i.getStringExtra("poin_merchandise"));
        txt_Harga.setText(i.getStringExtra("harga_merchandise"));

//        btn_Map.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view)
//            {
//                Intent i = new Intent(getApplicationContext(), Map.class);
//                startActivity(i);
//            }
//        });
    }
}