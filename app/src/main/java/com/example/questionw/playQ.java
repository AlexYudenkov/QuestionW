package com.example.questionw;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

public class playQ extends AppCompatActivity implements View.OnClickListener {
    String StringQ;
    TextView Question;
    Button button1;
    Button button2;
    Button button3;
    final String FILENAME = "questiontext.txt";
    final String LOG_TAG = "my_logs";
    int i = 1;
    String [] newq;
    int ra;//правильный ответ
    int score = 0;

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

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                check(1);
                break;
            case R.id.button2:
                check(2);
                break;
            case R.id.button3:
                check(3);
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
    public void fread(int o, String fname) throws IOException {BufferedReader reader = null;

            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(fname), "UTF-8"));
                String mLine = "";
                for (int i = 0;i<o;i++){
                mLine = reader.readLine();
                }
                Log.d(LOG_TAG,mLine);
                StringQ = mLine;

                }
    //количество строк в файле
    public int linescounter(String fName) throws IOException {BufferedReader reader = null;

            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(fName), "UTF-8"));

            // do reading, usually loop until end of file reading
            String mLine = "";
            //process line
            int i = 0;
            while ((mLine = reader.readLine()) != null) {
                i++;
            }
            Log.e(LOG_TAG,"Столько сосчитали строк");
            return i;

    }

    public void questions() throws IOException {
          if(i<=linescounter(FILENAME)){//задаем вопросы,пока они не кончились
          nextQuestion(i);
          i++;} else {
              //показать экран результатов
          }
    }

    private void nextQuestion(int a) throws IOException {
        fread(a,FILENAME);//прочитали строку из файла
        newq = StringQ.split(" ");
        Question.setText(newq[0]);//установили вопрос
        int t = random();
         switch (t){
             case 1://первая кнопка правильная
                 button1.setText(newq[1]);
                 button2.setText(newq[2]);
                 button3.setText(newq[3]);
                 ra = 1;
                 break;
             case 2://вторая кнопка правильная
                 button1.setText(newq[3]);
                 button2.setText(newq[1]);
                 button3.setText(newq[2]);
                 ra = 2;
                 break;
             case 3://третья кнопка правильная
                 button1.setText(newq[2]);
                 button2.setText(newq[3]);
                 button3.setText(newq[1]);
                 ra = 3;
                 break;
         }
    }
    public int random (){//рандомное число от 1 до 3
        Random Rand = new Random();
        int b = Rand.nextInt(3);
        return b;
    }
    public void check(int n){
        try {
            questions();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (ra==n){
            Toast.makeText(getApplicationContext(),"Good",Toast.LENGTH_SHORT).show();
            score = score + 10;
        } else {
            Toast.makeText(getApplicationContext(),"Baddd",Toast.LENGTH_SHORT).show();
        }
    }
}
