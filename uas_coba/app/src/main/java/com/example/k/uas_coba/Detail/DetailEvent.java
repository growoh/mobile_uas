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

public class DetailEvent extends AppCompatActivity {
    ImageView img_Event;
    TextView txt_Nama, txt_Deskripsi, txt_Jadwal, txt_Poin;
    Button btn_Map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_event);

        Intent i = getIntent();

        img_Event = findViewById(R.id.detailevent_imgEvent);
        txt_Nama = findViewById(R.id.detailevent_txtNama);
        txt_Deskripsi = findViewById(R.id.detailevent_txtDeskripsi);
        txt_Jadwal = findViewById(R.id.detailevent_txtJadwal);
        txt_Poin = findViewById(R.id.detailevent_txtPoin);

        Picasso.with(getApplicationContext()).load(ApiClient.BASE_IMG+i.getStringExtra("foto_event")).into(img_Event);
        txt_Nama.setText(i.getStringExtra("nama_event"));
        txt_Deskripsi.setText(i.getStringExtra("deskripsi_event"));
        txt_Poin.setText(i.getStringExtra("poin_event"));
        txt_Jadwal.setText(i.getStringExtra("jadwal_event"));

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