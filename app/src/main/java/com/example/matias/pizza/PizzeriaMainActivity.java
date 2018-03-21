package com.example.matias.pizza;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.app.Fragment;


public class PizzeriaMainActivity extends AppCompatActivity  {

    private FrameLayout fragment1;

    private final String TAG = getClass().getName();


    public static TextView text1;



    public static int numtab;   //en static pour qu'il soit disponible aussi sur BlankFragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzeria_main);

        text1 = (TextView) findViewById(R.id.text1);


        Intent i = getIntent();
        numtab = i.getIntExtra(getResources().getString(R.string.cle_ValTable), -1000);

        if (numtab == -1000) {
            Log.e(TAG, "error");
            finish();
            System.exit(-1);
        }
        text1.setText("Commande de la table n° " + numtab); //modification du texte

        BlankFragment frag = new BlankFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.frag1, frag); //null à la place de frag si on veut que ca disparaisse
        transaction.commit();       //contenue du fragment apparait

    }
}
