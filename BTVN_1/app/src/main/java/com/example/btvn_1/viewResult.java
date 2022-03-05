package com.example.btvn_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class viewResult extends AppCompatActivity {

    private TextView tvResult;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_result);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        tvResult = findViewById(R.id.tvKQ);
        btnBack = findViewById(R.id.btnback);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Intent it2 = getIntent();
        Bundle bl2 = it2.getExtras();

        if (bl2 != null) {
            String name = bl2.getString("Name");
            String phone = bl2.getString("Phone");
            String mail = bl2.getString("Mail");
            String address = bl2.getString("Address");

            String gender = bl2.getString("Gender");

            String source = bl2.getString("Source");

            tvResult.setText("Name: " + name + "\nPhone:" + phone + "\nMail:" + mail + "\nAddress:" + address + "\nGender: " + gender + "\nSource: " + source);

        }
    }
}