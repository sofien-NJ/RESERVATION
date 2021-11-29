package com.example.isetsl.reservation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText ed1, ed2, ed3, ed4, ed5, ed6;
    Button btn;
    List<reponse> reponseListe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText) findViewById(R.id.n1);
        ed2 = (EditText) findViewById(R.id.n2);
        ed3 = (EditText) findViewById(R.id.n3);
        ed4 = (EditText) findViewById(R.id.n4);
        ed5 = (EditText) findViewById(R.id.n5);
        ed6 = (EditText) findViewById(R.id.n6);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Setcontact.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Setcontact setContact = retrofit.create(Setcontact.class);
        Call<List<reponse>> call = setContact.setinfo(Long.parseLong(ed1.getText().toString()), ed2.getText().toString(), ed3.getText().toString(), Long.parseLong(ed4.getText().toString()), Long.parseLong(ed5.getText().toString()), Long.parseLong(ed6.getText().toString()));
        call.enqueue(new Callback<List<reponse>>() {

            public void onresponse(Call<List<reponse>> call, Response<List<reponse>> response) {
                Toast.makeText(getApplicationContext(), "Bien ajouté", Toast.LENGTH_LONG).show();
            }


            @Override
            public void onResponse(Call<List<reponse>> call, Response<List<reponse>> response) {

            }

            @Override
            public void onFailure(Call<List<reponse>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Erreur", Toast.LENGTH_LONG).show();

            }
        });
    }
}