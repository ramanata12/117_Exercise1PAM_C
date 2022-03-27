package com.example.exercise_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Todo extends AppCompatActivity {

    //Deklarasi Variabel
    TextView tNama;
    EditText tTask, tTime, tJenis;
    FloatingActionButton submit;
    String nama, task, waktu, jenis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        tNama = findViewById(R.id.tdNama);
        tTask = findViewById(R.id.tdTask);
        tJenis = findViewById(R.id.tdJenis);
        tTime = findViewById(R.id.tdWaktu);
        submit = findViewById(R.id.tdSubmit);

        Bundle bundle = getIntent().getExtras();

        nama = bundle.getString("name");

        tNama.setText(nama);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task = tTask.getText().toString();
                jenis = tJenis.getText().toString();
                waktu = tTime.getText().toString();

                if (TextUtils.isEmpty(task) && TextUtils.isEmpty(jenis) && TextUtils.isEmpty(waktu)){
                    Toast t = Toast.makeText(getApplicationContext(), "Wajib Isi Semua Data!", Toast.LENGTH_LONG);
                    t.show();
                }
                else if (TextUtils.isEmpty(task) && !TextUtils.isEmpty(jenis) && !TextUtils.isEmpty(waktu)){
                    tTask.setError("Masukan Task!");
                }
                else if (!TextUtils.isEmpty(task) && TextUtils.isEmpty(jenis) && !TextUtils.isEmpty(waktu)){
                    tJenis.setError("Masukan Jenis Task!");
                }
                else if (!TextUtils.isEmpty(task) && !TextUtils.isEmpty(jenis) && TextUtils.isEmpty(waktu)){
                    tTime.setError("Masukan Lama Task!");
                }
                else if (!TextUtils.isEmpty(task) && TextUtils.isEmpty(jenis) && TextUtils.isEmpty(waktu)){
                    tJenis.setError("Masukan Jenis Task!");
                    tTime.setError("Masukan Lama Task!");
                }
                else if (TextUtils.isEmpty(task) && !TextUtils.isEmpty(jenis) && TextUtils.isEmpty(waktu)){
                    tTask.setError("Masukan Task!");
                    tTime.setError("Masukan Lama Task!");
                }
                else if (TextUtils.isEmpty(task) && TextUtils.isEmpty(jenis) && !TextUtils.isEmpty(waktu)){
                    tTask.setError("Masukan Task!");
                    tJenis.setError("Masukan Jenis Task!");
                }
                else {

                    Toast t = Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT);
                    t.show();
                    Bundle b = new Bundle();

                    b.putString("task", task.trim());
                    b.putString("jenis", jenis.trim());
                    b.putString("time", waktu.trim());

                    Intent i = new Intent(getApplicationContext(), Result.class );
                    i.putExtras(b);
                    startActivity(i);
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnLogout) {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}

