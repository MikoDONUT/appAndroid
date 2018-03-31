package com.example.matias.pizza;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.AsyncTask;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.app.Fragment;
import android.preference.PreferenceFragment;

public class PizzeriaMainActivity extends AppCompatActivity /*implements View.OnClickListener*/{

    public static BlankFragment fragment1 = new BlankFragment();
    private final String TAG = getClass().getName();

    public static TextView text1;

    public static int numtab;   //en static pour qu'il soit disponible aussi sur BlankFragment


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzeria_main);

        text1 = (TextView) findViewById(R.id.text1);

        //on reçoit le numéro de table rentrer dans l'écrand de départ
        Intent i = getIntent();
        numtab = i.getIntExtra(getResources().getString(R.string.cle_ValTable), -1000);

        if (numtab == -1000) {
            Log.e(TAG, "error");
            finish();
            System.exit(-1);
        }
        text1.setText("Commande de la table n° " + numtab); //et on affiche ce numéro de table sur l'écran de commande

        //Le reste de cette interface étant contenue dans le fragment on en instancie un ici
        FragmentTransaction transaction = getFragmentManager().beginTransaction(); //création de la transaction
        transaction.add(R.id.fragment_container, fragment1);
        transaction.commit();       //contenue du fragment apparait
    }

    //création du menu visible dans la partie supérieur de l'écran de l'application
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.settings2:
            {
                Intent intent = new Intent();
                intent.setClassName(this, "com.example.matias.pizza.MyPreferenceActivity");
                startActivity(intent);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }


}
