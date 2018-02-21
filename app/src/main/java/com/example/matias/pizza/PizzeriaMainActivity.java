package com.example.matias.pizza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PizzeriaMainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;

    private int click1=0;
    private int click2=0;
    private int click3=0;
    private int click4=0;
    private int click5=0;
    private int click6=0;
    private int click7=0;
    private int click8=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzeria_main);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(this);

        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(this);


        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(this);

        button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1;
                click1++;
                button1.setText("NAPOLITAINE " + ": " +click1 );
                break;

            case R.id.button2;
                click2++;
                button2.setText("ROYALE " + ": " +click2 );
                break;

            case R.id.button3;
                click3++;
                button3.setText("QUATRE FROMAGES " + ": " +click3 );
                break;

            case R.id.button4;
                click4++;
                button4.setText("MONTAGNARDE " + ": " +click4 );
                break;

            case R.id.button5;
                click5++;
                button5.setText("RACLETTE " + ": " +click5 );
                break;

            case R.id.button6;
                click6++;
                button6.setText("HAWAI " + ": " +click6 );
                break;

            case R.id.button7;
                click7++;
                button7.setText("PANNA COTA " + ": " +click7 );
                break;

            case R.id.button8;
                click8++;
                button8.setText("TIRAMISU " + ": " +click8 );
                break;

        }
    }
}
