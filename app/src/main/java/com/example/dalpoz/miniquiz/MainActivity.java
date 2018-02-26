package com.example.dalpoz.miniquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button indietro,avanti;
    ImageButton vero,falso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        indietro=findViewById(R.id.button_Indietro);
        avanti=findViewById(R.id.button_Avanti);
        vero=findViewById(R.id.imageButton_Vero);
        falso=findViewById(R.id.imageButton_Falso);

    }
}
