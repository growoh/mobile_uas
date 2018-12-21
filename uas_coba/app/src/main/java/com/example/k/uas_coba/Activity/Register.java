package com.example.k.uas_coba.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.k.uas_coba.Models.User;
import com.example.k.uas_coba.R;
import com.example.k.uas_coba.Rest.ApiClient;
import com.example.k.uas_coba.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

    Button btn_Login, btn_Register;
    EditText edit_Username, edit_Nama, edit_Password, edit_Email, edit_Handphone;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn_Login = findViewById(R.id.daftar_btnMasuk);
        btn_Register = findViewById(R.id.daftar_btnDaftar);

        edit_Username = findViewById(R.id.daftar_edtUsername);
        edit_Password = findViewById(R.id.daftar_edtPassword);
        edit_Nama = findViewById(R.id.daftar_edtNama);
        edit_Email = findViewById(R.id.daftar_edtEmail);
        edit_Handphone = findViewById(R.id.daftar_edtHandphone);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<User> newUser = mApiInterface.postUser(edit_Username.getText().toString(), edit_Password.getText().toString(), edit_Nama.getText().toString(), edit_Email.getText().toString(), edit_Handphone.getText().toString());
                if (edit_Password.getText().length() == 0 && edit_Username.getText().length() == 0 && edit_Nama.getText().length() == 0 && edit_Email.getText().equals(null) && edit_Handphone.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Tidak Boleh Ada Kolom Kosong, Harap Diisi", Toast.LENGTH_SHORT).show();
                } else {
                    newUser.enqueue(new Callback<User>() {
                        public void onResponse(Call<User> call, Response<User> response) {
                            Toast.makeText(getApplicationContext(), "Sukses", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(getApplicationContext(), Login.class);
                            startActivity(i);
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });

        btn_Login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Beranda.class);
                startActivity(i);
            }
        });
    }
}