package com.example.exercise_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView rsTask, rsJenis, rsTime;
    String task, jenis, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        rsTask = findViewById(R.id.rstTask);
        rsJenis = findViewById(R.id.rstJenis);
        rsTime = findViewById(R.id.rstTime);

        // Penggunaan Bundle
        Bundle bundle = getIntent().getExtras();

        task = bundle.getString("task");
        jenis = bundle.getString("jenis");
        time = bundle.getString("time");

        rsTask.setText(task);
        rsJenis.setText(jenis);
        rsTime.setText(time);

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