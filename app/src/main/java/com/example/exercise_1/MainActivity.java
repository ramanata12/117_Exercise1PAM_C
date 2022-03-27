package com.example.exercise_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //Deklarasi variabel untuk button
    Button btnLogin;

    //Deklarasi Variabel untuk EditText
    EditText edEmail, edPassword;

    //Deklarasi variabel untuk menyimpan email dan password
    String nama, password;

    //Deklarasi variabel untuk TextView
    TextView edRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Mehubungkan variabel btnLogin dengan componen button pada layout
        btnLogin = findViewById(R.id.btSignin);

        //Menghubungkan variabel edemail dengan componen button pada layout
        edEmail = findViewById(R.id.edEmail);

        //menghubungkan variabel edPassword dengan componen button pada layout
        edPassword = findViewById(R.id.edPassword);

        //menghubungkan variabel edRegister dengan componen button pada layout
        edRegister = findViewById(R.id.edRegister);

        //membuat fungsi onclick pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nama = edEmail.getText().toString();
                password = edPassword.getText().toString();

                String email = "Nata";
                String pass = "121212";

                if (nama.isEmpty() || password.isEmpty()) {
                    Toast t = Toast.makeText(getApplicationContext(), "Email dan Password wajib diisi!!!",
                            Toast.LENGTH_LONG);

                    t.show();
                } else {
                    if (nama.equals(email) && password.equals(pass)) {
                        Toast t = Toast.makeText(getApplicationContext(), "Login Sukses",
                                Toast.LENGTH_LONG);

                        t.show();

                        Bundle b = new Bundle();

                        b.putString("a", nama.trim());
                        b.putString("b", password.trim());

                        Intent i = new Intent(getApplicationContext(), Todo.class);

                        i.putExtras(b);
                        startActivity(i);
                    } else {
                        Toast t = Toast.makeText(getApplicationContext(), "Login Gagal",
                                Toast.LENGTH_LONG);

                        t.show();
                    }
                }
            }
        });

        edRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Pendaftaran.class);
                startActivity(i);
            }
        });
    }
}

