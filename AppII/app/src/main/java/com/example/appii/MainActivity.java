package com.example.appii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edtA, edtB, edtC;
    private Button btnRun, btnExit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtA = findViewById(R.id.edta);
        edtB = findViewById(R.id.edtb);
        edtC = findViewById(R.id.edtc);
        btnRun = findViewById(R.id.btnGiai);
        btnExit = findViewById(R.id.btnThoat);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 3,2 Tao Indent
                Intent it1 = new Intent(MainActivity.this, Ac_Result.class);
                // 3,2 Tao Bundel
                Bundle bl1 = new Bundle();
                // 3,2 Lay Dl tu o editText
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                int c = Integer.parseInt(edtC.getText().toString());
                // 3,4 Dua DL vao trong Bundle 1
                bl1.putInt("So a", a);
                bl1.putInt("So b", b);
                bl1.putInt("So c", c);
                // 3,5 Dua Bundle vao trong Intent 1
                it1.putExtra("Du lieu", bl1);

                startActivity(it1);
            }
        });
    }
}