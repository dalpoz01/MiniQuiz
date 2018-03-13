package com.example.dalpoz.miniquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class Activity_classifica extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classifica);
        ScrollView sv=findViewById(R.id.scrollView2);
        LinearLayout ly=findViewById(R.id.linear);
       for(int i=0;i<40;i++){
           TextView p=new TextView(this);
           p.setText("ciao"+i);
           ly.addView(p);
       }

    }
}
