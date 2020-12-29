package com.example.lectuers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
public static List<Pdf_Model>list;
TextView layout_name ,text_null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rec);
        layout_name=(TextView)findViewById(R.id.layout_name);
        text_null =(TextView)findViewById(R.id.text_null) ;
        String names = getIntent().getStringExtra("name");
        list = new ArrayList<>();
        if(names.equals("الفرقة الاولى")) {
            layout_name.setText("محاضرات - الفرقة الاولى");
            list.add(new Pdf_Model("اساليب برمجة", "https://www.pdf995.com/samples/pdf.pdf", "تحميل"));
            list.add(new Pdf_Model("الحسبان", " https://www.pdf995.com/samples/pdf.pdf", "تحميل"));
            list.add(new Pdf_Model("مهارات حاسوب", "https://www.pdf995.com/samples/pdf.pdf", "تحميل"));

        }
        else if(names.equals("الفرقة الثانية")) {
            layout_name.setText("محاضرات - الفرقة الثانية");
            list.add(new Pdf_Model("اللغة الانجليزية", "https://www.pdf995.com/samples/pdf.pdf", "تحميل"));
            list.add(new Pdf_Model("مبادئ الادارة", "https://www.pdf995.com/samples/pdf.pdf", "تحميل"));

        }
        else if(names.equals("الفرقة الثالثة")){
            layout_name.setText("محاضرات - الفرقة الثالثة");
            list.add(new Pdf_Model("ادارة الاعمال", "https://www.pdf995.com/samples/pdf.pdf", "تحميل"));
            list.add(new Pdf_Model("علوم الشبكات", "https://www.pdf995.com/samples/pdf.pdf", "تحميل"));
        }

        else {
            layout_name.setText("المحاضرات ");
            text_null.setVisibility(View.VISIBLE);
             text_null.setText("لا توجد محاضرات");
        }
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        ItemClickListener itemClickListener = new ItemClickListener() {
            @Override
            public void onclick(View view, int position, boolean isLongClick) {

                Intent intent = new Intent(MainActivity.this,Pdf_Viewer.class);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        };
        Pdf_Adapter adapter = new Pdf_Adapter(list,this,itemClickListener);
        recyclerView.setAdapter(adapter);
    }
}
