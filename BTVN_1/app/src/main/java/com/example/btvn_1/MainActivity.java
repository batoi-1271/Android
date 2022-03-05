package com.example.btvn_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     EditText edName,edPhone, edMail, edAdd;
    private RadioButton rMale, rFemale;
    private CheckBox cAndroid, cWeb, cAsp;
    private Button btnRun, btnExit;
    String gender;
    String source;

    private boolean check() {
        String name = edName.getText().toString();
        String phone = edPhone.getText().toString();
        String mail = edMail.getText().toString();
        String address = edAdd.getText().toString();

        String male = rMale.getText().toString();
        String female = rFemale.getText().toString();

        String android = cAndroid.getText().toString();
        String web = cWeb.getText().toString();
        String asp = cAsp.getText().toString();

        if (name.isEmpty()) {
            Toast.makeText(MainActivity.this, "Enter name", Toast.LENGTH_LONG).show();
            return false;
        }
        if (!name.matches("[a-zA-Z]+")) {
            Toast.makeText(MainActivity.this, "Enter valid name", Toast.LENGTH_LONG).show();
            return false;
        }
        if (phone.matches("")) {
            Toast.makeText(MainActivity.this, "Enter phone number", Toast.LENGTH_LONG).show();
            return false;
        }
        if (!(Patterns.PHONE.matcher(phone).matches() && phone.length() != 11)) {
            Toast.makeText(MainActivity.this, "Enter valid phone number", Toast.LENGTH_LONG).show();
            return false;
        }
        if (mail.matches("")) {
            Toast.makeText(MainActivity.this, "Enter mail", Toast.LENGTH_LONG).show();
            return false;
        }
        if ((!Patterns.EMAIL_ADDRESS.matcher(mail).matches())) {
            Toast.makeText(MainActivity.this, "Enter valid mail", Toast.LENGTH_LONG).show();
            return false;
        }

        if (rMale.isChecked() || rFemale.isChecked()) {
            Log.d("QAOD", "Gender is Selected");
            if (rMale.isChecked()) gender = "Male";
            if (rFemale.isChecked()) gender = "Female";
        } else {
            Toast.makeText(getApplicationContext(), "Please select Gender", Toast.LENGTH_SHORT).show();
            Log.d("QAOD", "Gender is Null");
        }

        if (cAndroid.isChecked() || cWeb.isChecked() || cAsp.isChecked()) {
            Log.d("QAOD", "Source is Selected");
            if (cAndroid.isChecked()) source = "Android";
            if (cWeb.isChecked()) source = "Web";
            if (cAsp.isChecked()) source = "Asp";
        } else {
            Toast.makeText(getApplicationContext(), "Please select Source", Toast.LENGTH_SHORT).show();
            Log.d("QAOD", "Source is Null");
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.edName = findViewById(R.id.edtName);
        this.edPhone = findViewById(R.id.edtPhone);
        this.edMail = findViewById(R.id.edtMail);
        this.edAdd = findViewById(R.id.edtAdd);
        this.rMale = findViewById(R.id.rdMale);
        this.rFemale = findViewById(R.id.rdFeM);
        this.cAndroid = findViewById(R.id.cbAndroid);
        this.cWeb = findViewById(R.id.cbWeb);
        this.cAsp = findViewById(R.id.cbAS);

        this.btnRun = findViewById(R.id.btnSub);
        this.btnExit = findViewById(R.id.btnCanel);

        this.btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check()) {
                    // 3,2 Tao Indent
                    Intent it1 = new Intent(MainActivity.this, viewResult.class);
                    // 3,2 Tao Bundel
                    Bundle bl1 = new Bundle();

                    // 3,4 Dua DL vao trong Bundle 1
                    bl1.putString("Name", edName.getText().toString());
                    bl1.putString("Phone", edPhone.getText().toString());
                    bl1.putString("Mail", edMail.getText().toString());
                    bl1.putString("Address", edAdd.getText().toString());

                    bl1.putString("Gender", gender);

                    bl1.putString("Source", source);

                    // 3,5 Dua Bundle vao trong Intent 1
                    it1.putExtras(bl1);
                    startActivity(it1);
                }
            }
        });
    }
}