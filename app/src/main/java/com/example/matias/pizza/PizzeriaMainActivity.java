package com.example.matias.pizza;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class PizzeriaMainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = getClass().getName();

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    public static TextView text1;


    //on crée des click static pour que leur valeurs ne se réinitialise pas au passage ecran vertical/horizontal
    static int click1;
    static int click2;
    static int click3;
    static int click4;
    static int click5;
    static int click6;
    static int click7;
    static int click8;
    private int numtab;
    private String numtab2; //valeur prenant un 0 devant si 10> numtab > 0 pour ainsi envoyer sous le bon format le numtab au serveur


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


        if (savedInstanceState != null) {

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
            button1.setText("NAPOLITAINE " + ": " + valBut1);
            button2.setText("ROYALE " + ": " + valBut2);
            button3.setText("QUATRE FROMAGES " + ": " + valBut3);
            button4.setText("MONTAGNARDE " + ": " + valBut4);
            button5.setText("RACLETTE " + ": " + valBut5);
            button6.setText("HAWAI " + ": " + valBut6);
            button7.setText("PANNA COTA " + ": " + valBut7);
            button8.setText("TIRAMISU " + ": " + valBut8);
        }



    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        if(numtab>0 && numtab <10){
            numtab2 = "0" + numtab;
        }
        else {
            numtab2 = String.valueOf(numtab);
        }
        switch (v.getId()) {
            case R.id.button1:
                click1++;
                button1.setText("NAPOLITAINE " + ": " + click1);
                Commande c1 = new Commande();
                c1.execute(numtab2 + "Napolitaine");
                break;
            case R.id.button2:
                click2++;
                button2.setText("ROYALE " + ": " + click2);
                Commande c2 = new Commande();
                c2.execute(numtab2 + "Royale");
                break;
            case R.id.button3:
                click3++;
                button3.setText("QUATRE FROMAGES " + ": " + click3);
                Commande c3 = new Commande();
                c3.execute(numtab2 + "QuatreFromage");
                break;
            case R.id.button4:
                click4++;
                button4.setText("MONTAGNARDE " + ": " + click4);
                Commande c4 = new Commande();
                c4.execute(numtab + "Montagnarde");
                break;
            case R.id.button5:
                click5++;
                button5.setText("RACLETTE " + ": " + click5);
                Commande c5 = new Commande();
                c5.execute(numtab2 + "Raclette");
                break;
            case R.id.button6:
                click6++;
                button6.setText("HAWAI " + ": " + click6);
                Commande c6 = new Commande();
                c6.execute(numtab2 + "Hawai");
                break;
            case R.id.button7:
                click7++;
                button7.setText("PANNA COTA " + ": " + click7);
                Commande c7 = new Commande();
                c7.execute(numtab2 + "PannaCota");
                break;
            case R.id.button8:
                click8++;
                button8.setText("TIRAMISU " + ": " + click8);
                Commande c8 = new Commande();
                c8.execute(numtab2 + "Tiramisu");
                break;
        }


    }

    protected void onSaveInstanceState(Bundle outState) {
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
/*
    private class Commande extends AsyncTask<String, String, Void> {
        private final int wait = (int) (Math.random() * (120000 - 60000 + 1000)) + 60000; //temps compris entre 1 et 2 minutes
        private int port = 9874;


        @Override
        //code exécuter par la tâche
        protected Void doInBackground(String... strings) {
            Socket socket = null;

            try{
                socket = new Socket("chadok.info", port);  //création de socket faisant la connexion client/serveur
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer.println(strings[0]);
                //writer.append(strings[0]);    //envoie du message au serveur mais sans retour à la ligne
                String retour1 = reader.readLine();  //lecture des message envoyer dans le socket par le serveur
                if (retour1 != null) {      //bien verifier à ce que reader ne soit pas vide
                    System.out.println("Message du serveur : " + retour1);
                    //onProgressUpdate(retour1);    //lance l'affichage mais redemarre l'application
                    publishProgress(retour1);
                }

                String s= "";
                //readLine a un timeout integré, ce qui fait que s'il ne reçoit
                // aucune ligne de caractère la variable ne contiendra rien, c'est pour ça qu'avec while()
                //on oblige à attendre à ce que "s" ait un contenue
                while(s.equals("")){
                    s = reader.readLine();
                }
                publishProgress(s);

            }
            catch(IOException e){
                e.printStackTrace();
            }
            finally{
                if(socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... messageRetour) {
            PizzeriaMainActivity.text1.setText(messageRetour[0]);
        }


    }

*/
}
