package com.example.lesson3_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private Button btnOnFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        if (getIntent() != null) {
            String result = getIntent().getStringExtra("value");
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        }

        btnOnFragment = findViewById(R.id.btn_open_fragment);
        btnOnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fragment_container, new FirstFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}