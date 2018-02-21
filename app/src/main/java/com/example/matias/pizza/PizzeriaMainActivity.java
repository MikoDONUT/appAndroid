package com.example.matias.pizza;

import android.annotation.SuppressLint;
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

    //on crée des click static pour que leur valeurs ne se réinitialise pas au passage ecran vertical/horizontal
    static int click1;
    static int click2;
    static int click3;
    static int click4;
    static int click5;
    static int click6;
    static int click7;
    static int click8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzeria_main);

        //Definition de chaque bouton par rapport à l'ID du layout
        button1 = (Button) findViewById(R.id.button1);
        //Liaison à l'évenement click
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



        if(savedInstanceState != null){

            //Ces  entiers reçoivent les valeurs sauvegarder dans les cle_button
            int valBut1 = savedInstanceState.getInt("cle_But1");
            int valBut2 = savedInstanceState.getInt("cle_But2");
            int valBut3 = savedInstanceState.getInt("cle_But3");
            int valBut4 = savedInstanceState.getInt("cle_But4");
            int valBut5 = savedInstanceState.getInt("cle_But5");
            int valBut6 = savedInstanceState.getInt("cle_But6");
            int valBut7 = savedInstanceState.getInt("cle_But7");
            int valBut8 = savedInstanceState.getInt("cle_But8");

            //Et à partir de ces mêmes entier on modifie le .texte de chaque bouton
            button1.setText("NAPOLITAINE " + ": " +valBut1 );
            button2.setText("ROYALE " + ": " +valBut2 );
            button3.setText("QUATRE FROMAGES " + ": " +valBut3 );
            button4.setText("MONTAGNARDE " + ": " +valBut4 );
            button5.setText("RACLETTE " + ": " +valBut5 );
            button6.setText("HAWAI " + ": " +valBut6 );
            button7.setText("PANNA COTA " + ": " +valBut7);
            button8.setText("TIRAMISU " + ": " +valBut8 );
        }

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                click1++;
                button1.setText("NAPOLITAINE " + ": " +click1 );
                break;
            case R.id.button2:
                click2++;
                button2.setText("ROYALE " + ": " +click2 );
                break;
            case R.id.button3:
                click3++;
                button3.setText("QUATRE FROMAGES " + ": " +click3 );
                break;
            case R.id.button4:
                click4++;
                button4.setText("MONTAGNARDE " + ": " +click4 );
                break;
            case R.id.button5:
                click5++;
                button5.setText("RACLETTE " + ": " +click5 );
                break;
            case R.id.button6:
                click6++;
                button6.setText("HAWAI " + ": " +click6 );
                break;
            case R.id.button7:
                click7++;
                button7.setText("PANNA COTA " + ": " +click7 );
                break;
            case R.id.button8:
                click8++;
                button8.setText("TIRAMISU " + ": " +click8 );
                break;
        }


    }

    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        //A l'aide des clés de chaque bouton qu'on a definit dans le fichier "String"
        //On garde la valeur des clicks de chaque bouton dans les clé_button de chaque bouton
        outState.putInt(getResources().getString(R.string.cle_But1), click1);
        outState.putInt(getResources().getString(R.string.cle_But2), click2);
        outState.putInt(getResources().getString(R.string.cle_But3), click3);
        outState.putInt(getResources().getString(R.string.cle_But4), click4);
        outState.putInt(getResources().getString(R.string.cle_But5), click5);
        outState.putInt(getResources().getString(R.string.cle_But6), click6);
        outState.putInt(getResources().getString(R.string.cle_But7), click7);
        outState.putInt(getResources().getString(R.string.cle_But8), click8);

    }


}
