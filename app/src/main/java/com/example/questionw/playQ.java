package com.example.questionw;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class playQ extends AppCompatActivity implements View.OnClickListener {
    String StringQ;
    TextView Question;
    Button button1;
    Button button2;
    Button button3;
    final String FILENAME = "questionFile";
    final String LOG_TAG = "my_logs";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);
        Question = findViewById(R.id.mainQuestion);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        //fwrite();
        Question.setText(StringQ);
         }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                break;
            case R.id.button2:
                break;
            case R.id.button3:
                break;
        }
    }

    public void fwrite() {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    openFileOutput(FILENAME, MODE_PRIVATE)));
            bw.write("Aaaaa");
            // закрываем поток
            bw.close();
            Log.d(LOG_TAG, "Файл записан");
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    //читает файл построчно
    public void fread() throws IOException {BufferedReader reader = null;

            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("questiontext.txt"), "UTF-8"));
            // do reading, usually loop until end of file reading
                String mLine = "";
                //process line
                mLine = reader.readLine();
                Log.d(LOG_TAG,mLine);
                StringQ = mLine;

                }
    public void questions(){
        
    }
}