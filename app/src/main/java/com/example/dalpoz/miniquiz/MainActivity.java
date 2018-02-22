package com.example.dalpoz.miniquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button indietro=findViewById(R.id.button_Indietro);
        Button avanti=findViewById(R.id.button_Avanti);
        ScrollView sc=findViewById(R.id.scrollView2);
        TextView tw=new TextView(null);
        tw.setText("ciao");
        sc.addView(tw);
    }
}
