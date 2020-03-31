package com.employmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private RadioButton Q1, Q2, Q3, E1, E2;
    private CheckBox check1, check2, check3, check4, check5;
    private LinearLayout yearLay;
    private Button okButton;
    private TextView salaryText;
    private boolean isExpert = false, isEnglish = false;
    private int count = 0;
    private int baseAmt = 0;
    private EditText getyear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        SetUp();
    }

    private void initView() {
        Q1 = findViewById(R.id.Q1);
        Q2 = findViewById(R.id.Q2);
        Q3 = findViewById(R.id.Q3);
        E1 = findViewById(R.id.E1);
        E2 = findViewById(R.id.E2);
        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.check3);
        check4 = findViewById(R.id.check4);
        check5 = findViewById(R.id.check5);
        yearLay = findViewById(R.id.yearLay);
        okButton = findViewById(R.id.okButton);
        salaryText = findViewById(R.id.salaryText);
        getyear = findViewById(R.id.getyear);
    }

    private void SetUp() {
        Q1.setOnCheckedChangeListener(this);
        Q2.setOnCheckedChangeListener(this);
        Q3.setOnCheckedChangeListener(this);
        E1.setOnCheckedChangeListener(this);
        E2.setOnCheckedChangeListener(this);
        check1.setOnCheckedChangeListener(this);
        check2.setOnCheckedChangeListener(this);
        check3.setOnCheckedChangeListener(this);
        check4.setOnCheckedChangeListener(this);
        check5.setOnCheckedChangeListener(this);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total;
                if (isExpert) {
                    if (getyear.getText().toString().isEmpty()) {
                        Toast.makeText(MainActivity.this, "enter year", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (isEnglish) {
                        total = (count * 100) + (Integer.parseInt(getyear.getText().toString()) * 100) + baseAmt;
                        salaryText.setText("" + total);
                    } else {
                        total = (Integer.parseInt(getyear.getText().toString()) * 100) + baseAmt;
                        salaryText.setText("" + total);
                    }

                } else {
                    if (isEnglish) {
                        total = (count * 100) + baseAmt;
                        salaryText.setText("" + total);
                    } else {
                        total = baseAmt;
                        salaryText.setText("" + total);
                    }
                }
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.Q1:
                if (isChecked) {
                    baseAmt = 5000;
                } else {

                }
                break;
            case R.id.Q2:
                if (isChecked) {
                    baseAmt = 5800;
                } else {

                }
                break;
            case R.id.Q3:
                if (isChecked) {
                    baseAmt = 6500;
                } else {

                }
                break;


            case R.id.E1:
                if (isChecked) {
                    isExpert = true;
                    yearLay.setVisibility(View.VISIBLE);
                } else {

                }
                break;

            case R.id.E2:
                if (isChecked) {
                    isExpert = false;
                    yearLay.setVisibility(View.GONE);
                } else {

                }
                break;
            case R.id.check1:
                if (isChecked) {
                    isEnglish = true;
                } else {
                    isEnglish = false;
                }
                break;
            case R.id.check2:
            case R.id.check3:

            case R.id.check4:

            case R.id.check5:
                if (isChecked) {
                    count++;
                } else {
                    count--;
                }
                break;
        }
    }
}
