package com.example.questionw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button play;
    Button settings;
    Button records;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        records = findViewById(R.id.records);
        settings = findViewById(R.id.set);
        play = findViewById(R.id.play);
        play.setOnClickListener(this);
        records.setOnClickListener(this);
        settings.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.records:
                /*Intent r;
                r = new Intent(this, record.class);
                startActivity(r);*/
                //показать активити рекордов
                break;
            case R.id.play:
                //основная активность
                Intent i;
                i = new Intent(this, playQ.class);
                startActivity(i);
                break;
            case R.id.set:
                /*Intent s;
                s = new Intent(this, set.class);
                startActivity(s);*/
                //настройки
                break;
        }

    }
}
