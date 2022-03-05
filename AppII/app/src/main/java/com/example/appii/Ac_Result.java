package com.example.appii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ac_Result extends AppCompatActivity {

    private TextView tvResult;
    private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_result);

        tvResult = findViewById(R.id.tvKQ);
        btnBack = findViewById(R.id.btnback);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Intent it2 = getIntent();
        Bundle bl2 = it2.getBundleExtra("Du lieu");
        int a = bl2.getInt("So a");
        int b = bl2.getInt("So b");
        int c = bl2.getInt("So c");

        giaiPT(a, b, c);
    }

    private void giaiPT(int a, int b, int c) {
        String kq = "";
        if (a == 0) {
            if (b == 0 && c == 0) {
                kq ="Phương trình vô số nghiệm!";
            } else if (b == 0 && c != 0) {
                kq ="Phương trình vô nghiệm!";
            } else {
                kq = "Phương trình có một nghiệm: " + "x = " + (float)(-c / b);
            }
        }
        float delta = b*b - 4*a*c;
        float x1;
        float x2;
        // tính nghiệm
        if (delta > 0) {
            x1 = (float) ((-b + Math.sqrt(delta)) / (2*a));
            x2 = (float) ((-b - Math.sqrt(delta)) / (2*a));
            kq ="Phương trình có 2 nghiệm là: " + "x1 = " + x1 + " và x2 = " + x2;
        } else if (delta == 0) {
            x1 = (-b / (2 * a));
            kq = "Phương trình có nghiệm kép: " + "x1 = x2 = " + x1;
        } else {
            kq = "Phương trình vô nghiệm!";
        }

        tvResult.setText(kq);
    }
}