package com.example.lectuers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Depts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depts);
    }

    public void dept1(View view) {
        Intent intent = new Intent(Depts.this,MainActivity.class);
        intent.putExtra("name","الفرقة الاولى");
        startActivity(intent);
    }

    public void dept2(View view) {
        Intent intent = new Intent(Depts.this,MainActivity.class);
        intent.putExtra("name","الفرقة الثانية");
        startActivity(intent);
    }
    public void dept3(View view) {
        Intent intent = new Intent(Depts.this,MainActivity.class);
        intent.putExtra("name","الفرقة الثالثة");
        startActivity(intent);
    }
    public void dept4(View view) {
        Intent intent = new Intent(Depts.this,MainActivity.class);
        intent.putExtra("name","الفرقة الرابعة");
        startActivity(intent);
    }
    public void dept5(View view) {
        Intent intent = new Intent(Depts.this,MainActivity.class);
        intent.putExtra("name","الفرقة الخامسة");
        startActivity(intent);
    }
    public void dept6(View view) {
        Intent intent = new Intent(Depts.this,MainActivity.class);
        intent.putExtra("name","الفرقة السادسة");
        startActivity(intent);
    }
}
