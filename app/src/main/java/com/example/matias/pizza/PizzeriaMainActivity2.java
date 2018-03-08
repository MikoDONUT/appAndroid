package com.example.matias.pizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PizzeriaMainActivity2 extends AppCompatActivity implements View.OnClickListener{

    private Button butValider;
    private EditText editText1;

    private static int valTable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzeria_main2);

        butValider = (Button) findViewById(R.id.butValider);
        editText1 = (EditText) findViewById(R.id.editText1);


        butValider.setOnClickListener(this);

    }

    public void onClick(View v){
        if(v.getId() == R.id.butValider){

            valTable = Integer.parseInt(editText1.getText().toString());
            Intent intent = new Intent(this, PizzeriaMainActivity.class);
            intent.putExtra(getResources().getString(R.string.cle_ValTable), valTable);
            startActivity(intent);
        }

    }

    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        //A l'aide des clés du bouton valider, qu'on a definit dans le fichier "String"
        //On garde la valeur de valTable enter dans le edittext dans les clé_button de chaque bouton
        outState.putInt(getResources().getString(R.string.cle_ValTable), valTable);

    }
}
