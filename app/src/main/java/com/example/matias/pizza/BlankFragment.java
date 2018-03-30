package com.example.matias.pizza;


import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements View.OnClickListener {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    public static Button buttonPers;
    private Button reinit;


    //on crée des click static pour que leur valeurs ne se réinitialise pas au passage ecran vertical/horizontal
    static int click1;
    static int click2;
    static int click3;
    static int click4;
    static int click5;
    static int click6;
    static int click7;
    static int click8;
    BlankFragment2 fragment2 = new BlankFragment2();    //fragment apparaissant lors du click sur Pizza Personnalisé
    public static int numtab;   //le numero de la table du client


    private String numtab2; //valeur prenant un 0 devant si 10> numtab > 0 pour ainsi envoyer sous le bon format le numtab au serveur


    public BlankFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_blank, container, false);

        // Code à compléter ; par exemple : button = (Button) v.findViewById(R;id.button);

        numtab = PizzeriaMainActivity.numtab;




        //Definition de chaque bouton par rapport à l'ID du layout

        reinit = (Button) v.findViewById(R.id.reinit);
        reinit.setOnClickListener(this);

        buttonPers = (Button) v.findViewById(R.id.buttonPers);
        buttonPers.setOnClickListener(this);


        button1 = (Button) v.findViewById(R.id.button1);
        //Liaison à l'évenement click
        button1.setOnClickListener(this);

        button2 = (Button) v.findViewById(R.id.button2);
        button2.setOnClickListener(this);

        button3 = (Button) v.findViewById(R.id.button3);
        button3.setOnClickListener(this);

        button4 = (Button) v.findViewById(R.id.button4);
        button4.setOnClickListener(this);

        button5 = (Button) v.findViewById(R.id.button5);
        button5.setOnClickListener(this);

        button6 = (Button) v.findViewById(R.id.button6);
        button6.setOnClickListener(this);

        button7 = (Button) v.findViewById(R.id.button7);
        button7.setOnClickListener(this);

        button8 = (Button) v.findViewById(R.id.button8);
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



        return v;
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

            case R.id.buttonPers:
                FragmentTransaction transaction = getFragmentManager().beginTransaction(); //création de la transaction
                transaction.replace(R.id.fragment_container, fragment2);
                transaction.addToBackStack(null);
                transaction.commit();       //contenue du fragment apparait
                break;

            case R.id.button1:
                click1++;
                button1.setText("NAPOLITAINE " + ": " + click1);
                Commande c1 = new Commande();
                c1.execute(numtab2 + "Napolitaine");
                break;
            case R.id.button2:
                click2++;
                button2.setText("ROYALE : " + click2);
                Commande c2 = new Commande();
                c2.execute(numtab2 + "Royale");
                break;
            case R.id.button3:
                click3++;
                button3.setText("QUATRE FROMAGES : " + click3);
                Commande c3 = new Commande();
                c3.execute(numtab2 + "QuatreFromage");
                break;
            case R.id.button4:
                click4++;
                button4.setText("MONTAGNARDE : " + click4);
                Commande c4 = new Commande();
                c4.execute(numtab2 + "Montagnarde");
                break;
            case R.id.button5:
                click5++;
                button5.setText("RACLETTE : " + click5);
                Commande c5 = new Commande();
                c5.execute(numtab2 + "Raclette");
                break;
            case R.id.button6:
                click6++;
                button6.setText("HAWAI : " + click6);
                Commande c6 = new Commande();
                c6.execute(numtab2 + "Hawai");
                break;
            case R.id.button7:
                click7++;
                button7.setText("PANNA COTA : " + click7);
                Commande c7 = new Commande();
                c7.execute(numtab2 + "PannaCota");
                break;
            case R.id.button8:
                click8++;
                button8.setText("TIRAMISU : " + click8);
                Commande c8 = new Commande();
                c8.execute(numtab2 + "Tiramisu");
                break;
            case R.id.reinit:
                reinitialisation();

                break;
        }


    }

    public void onSaveInstanceState(Bundle outState) {
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

    public void reinitialisation(){
        click1 = 0;
        click2 = 0;
        click3 = 0;
        click4 = 0;
        click5 = 0;
        click6 = 0;
        click7 = 0;
        click8 = 0;
        button1.setText("NAPOLITAINE");
        button2.setText("ROYALE");
        button3.setText("QUATRE FROMAGES");
        button4.setText("MONTAGNARDE");
        button5.setText("RACLETTE");
        button6.setText("HAWAI");
        button7.setText("PANNA COTA");
        button8.setText("TIRAMISU");
    }

}