package com.example.k.uas_coba.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.k.uas_coba.Models.LoginRespon;
import com.example.k.uas_coba.Models.User;
import com.example.k.uas_coba.R;
import com.example.k.uas_coba.Rest.ApiClient;
import com.example.k.uas_coba.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity
{
    Button btn_Login, btn_Register;
    EditText edit_Password, edit_Username;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_Login = findViewById(R.id.masuk_btnMasuk);
        btn_Register = findViewById(R.id.masuk_btnDaftar);
        edit_Username = (EditText) findViewById(R.id.masuk_edtUsername);
        edit_Password = (EditText) findViewById(R.id.masuk_edtPassword);

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mApiInterface= ApiClient.getClient().create(ApiInterface.class);
                Call<LoginRespon> getLogin = mApiInterface.getLogin(edit_Username.getText().toString(), edit_Password.getText().toString());
                getLogin.enqueue(new Callback<LoginRespon>() {
                    @Override
                    public void onResponse(retrofit2.Call<LoginRespon> call, Response<LoginRespon> response) {
                        String status = response.body().getStatus();
                        if (status.equals("success")){
                            User user = response.body().getUser();
                            Intent i = new Intent(getApplicationContext(), Beranda.class);
                            Toast.makeText(getApplicationContext(), "User : "+user.getUsername(), Toast.LENGTH_LONG).show();
                            startActivity(i);
                        }
                    }

                    @Override
                    public void onFailure(retrofit2.Call<LoginRespon> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Server Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Register.class);
                startActivity(i);
            }
        });
    }
}