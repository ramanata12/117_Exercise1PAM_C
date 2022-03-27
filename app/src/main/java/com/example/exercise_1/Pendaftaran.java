package com.example.exercise_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Pendaftaran extends AppCompatActivity {

    //Deklarasi Variabel
    EditText rNama, rEmail, rPass, rRepas;
    String nama, email, password, repassword;
    Button btRegis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran);

        rNama = findViewById(R.id.rgNama);
        rEmail = findViewById(R.id.rgEmail);
        rPass = findViewById(R.id.rgPass);
        rRepas = findViewById(R.id.rgRepass);
        btRegis = findViewById(R.id.btnRegis);

        btRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = rNama.getText().toString();
                email = rEmail.getText().toString();
                password = rPass.getText().toString();
                repassword = rRepas.getText().toString();

                if (TextUtils.isEmpty(nama) && TextUtils.isEmpty(email)
                        && TextUtils.isEmpty(password) && TextUtils.isEmpty(repassword)){
                    Toast t = Toast.makeText(getApplicationContext(),"Harap isi semua kolom diatas",Toast.LENGTH_LONG);
                    t.show();

                    rNama.setError("Nama harus diisi !!!");
                    rEmail.setError("Email harus diisi !!!");
                }
                else if(TextUtils.isEmpty(nama) || TextUtils.isEmpty(email)
                        || TextUtils.isEmpty(password) || TextUtils.isEmpty(repassword)){
                    Toast t = Toast.makeText(getApplicationContext(),"Harap isi semua data!",Toast.LENGTH_LONG);
                    t.show();
                }
                else {
                    if (!password.equals(repassword)){
                        Toast t = Toast.makeText(getApplicationContext(),"Password harus sama!",Toast.LENGTH_LONG);
                        t.show();

                        rRepas.setError("Password tidak cocok !!!");
                    }
                    else {
                        Bundle b = new Bundle();

                        b.putString("name", nama.trim());
                        Toast t = Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_LONG);
                        t.show();

                        Intent i = new Intent(getApplicationContext(), Todo.class);
                        i.putExtras(b);
                        startActivity(i);
                    }
                }
            }
        });
    }
}