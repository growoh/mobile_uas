package com.example.k.uas_coba.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.k.uas_coba.R;

public class Beranda extends AppCompatActivity
{
    ImageButton btn_Wahana, btn_Event, btn_Kedai, btn_Fasilitas, btn_Merchandise;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

        btn_Wahana=(ImageButton) findViewById(R.id.beranda_btnWahana);
        btn_Fasilitas=(ImageButton) findViewById(R.id.beranda_btnFasilitas);
        btn_Event = (ImageButton) findViewById(R.id.beranda_btnEvent);
        btn_Kedai = (ImageButton) findViewById(R.id.beranda_btnKedai);
        btn_Merchandise = (ImageButton) findViewById(R.id.beranda_btnMerchandise);

        btn_Wahana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Wahana.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Wahana", Toast.LENGTH_LONG).show();
            }
        });

        btn_Merchandise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Merchandise.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Merchandise", Toast.LENGTH_LONG).show();
            }
        });

        btn_Kedai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Kedai.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Kedai", Toast.LENGTH_LONG).show();
            }
        });

        btn_Event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Event.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Event", Toast.LENGTH_LONG).show();
            }
        });

        btn_Fasilitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Fasilitas.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Fasilitas", Toast.LENGTH_LONG).show();
            }
        });
    }
}
