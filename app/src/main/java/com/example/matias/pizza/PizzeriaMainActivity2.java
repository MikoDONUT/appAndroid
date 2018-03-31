package com.example.matias.pizza;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PizzeriaMainActivity2 extends AppCompatActivity implements View.OnClickListener{

    private Button butValider;
    private EditText editText1;
    private TextView text3;
    private static int valTable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzeria_main2);
        //Définition de l'interface de départ
        butValider = (Button) findViewById(R.id.butValider);
        editText1 = (EditText) findViewById(R.id.editText1);
        text3 = (TextView) findViewById(R.id.text3);
        butValider.setOnClickListener(this);
    }

    public void onClick(View v){
        //Si le nombre entrer est incorrect il n'y a pas accés à l'écran de commande, et un text rouge d'erreur s'affiche
        if(v.getId() == R.id.butValider){
            if(Integer.parseInt(editText1.getText().toString()) < 0 || Integer.parseInt(editText1.getText().toString()) > 99 ){
                text3.setTextColor(Color.parseColor("#DF0D0D"));
            }
            else {
                valTable = Integer.parseInt(editText1.getText().toString());
                Intent intent = new Intent(this, PizzeriaMainActivity.class);
                intent.putExtra(getResources().getString(R.string.cle_ValTable), valTable);
                startActivity(intent);
            }
        }

    }

    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        //A l'aide des clés du bouton valider, qu'on a definit dans le fichier "String"
        //On garde la valeur de valTable enter dans le edittext dans les clé_button de chaque bouton
        outState.putInt(getResources().getString(R.string.cle_ValTable), valTable);

    }
}
