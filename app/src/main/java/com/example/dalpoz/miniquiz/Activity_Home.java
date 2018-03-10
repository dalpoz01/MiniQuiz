package com.example.dalpoz.miniquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button Inizia=findViewById(R.id.button_Inizia);
        Inizia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Activity_Home.this, Activity_domande.class);
                myIntent.putExtra("key", 1); //Optional parameters
                Activity_Home.this.startActivity(myIntent);
            }
        });
    }
}
