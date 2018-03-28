package com.example.matias.pizza;


import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment implements View.OnClickListener{

    private Button butMozzarella;
    private Button butGorgonzola;
    private Button butAnchois;
    private Button butCapres;
    private Button butOlives;
    private Button butArtichauts;
    private Button butJambonCru;
    private Button butJambonCuit;
    private Button butValider2;
    private String ingredientChoisis = "";
    private String numtab2 = "";
    public  static  int clickValid2 = 0;
    private int clickMoza = 0;
    private int clickGorgon = 0;
    private int clickAnch = 0;
    private int clickCap = 0;
    private int clickOliv = 0;
    private int clickArti = 0;
    private int clickJambCru = 0;
    private int clickJambCuit = 0;

    public BlankFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v2 = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);

        butMozzarella = (Button) v2.findViewById(R.id.butMozzarella);
        butMozzarella.setOnClickListener(this);

        butGorgonzola= (Button) v2.findViewById(R.id.butGorgonzola);
        butGorgonzola.setOnClickListener(this);

        butAnchois = (Button) v2.findViewById(R.id.butAnchois);
        butAnchois.setOnClickListener(this);

        butCapres = (Button) v2.findViewById(R.id.butCapres);
        butCapres.setOnClickListener(this);

        butOlives = (Button) v2.findViewById(R.id.butOlives);
        butOlives.setOnClickListener(this);

        butArtichauts = (Button) v2.findViewById(R.id.butArtichauts);
        butArtichauts.setOnClickListener(this);

        butJambonCru = (Button) v2.findViewById(R.id.butJambonCru);
        butJambonCru.setOnClickListener(this);

        butJambonCuit = (Button) v2.findViewById(R.id.butJambonCuit);
        butJambonCuit.setOnClickListener(this);

        butValider2 = (Button) v2.findViewById(R.id.butValider2);
        butValider2.setOnClickListener(this);


        return v2;
    }


    public void onClick(View v) {
        if(BlankFragment.numtab <10){
            numtab2 = "0" + BlankFragment.numtab;
        }
        else {
            numtab2 = String.valueOf(BlankFragment.numtab);
        }

        switch (v.getId()) {
            case R.id.butMozzarella:
                if(clickMoza == 0) {
                    ingredientChoisis += "mozzarella + ";
                    butMozzarella.setBackgroundColor(Color.YELLOW);

                    clickMoza++;
                    break;
                }
                else
                    break;
            case R.id.butGorgonzola:
                if(clickGorgon == 0) {
                    ingredientChoisis += "gorgonzola + ";
                    butGorgonzola.setBackgroundColor(Color.YELLOW);
                    clickGorgon++;
                    break;
                }
                else
                    break;
            case R.id.butAnchois:
                if(clickAnch == 0) {
                    ingredientChoisis += "anchois + ";
                    butAnchois.setBackgroundColor(Color.YELLOW);
                    clickAnch++;
                    break;
                }
                else
                    break;
            case R.id.butCapres:
                if(clickCap == 0) {
                    ingredientChoisis += "capres + ";
                    butCapres.setBackgroundColor(Color.YELLOW);
                    clickCap++;
                    break;
                }
                else
                    break;
            case R.id.butOlives:
                if(clickOliv == 0) {
                    ingredientChoisis += "olives + ";
                    butOlives.setBackgroundColor(Color.YELLOW);
                    clickOliv ++;
                    break;
                }
                else
                    break;
            case R.id.butArtichauts:
                if(clickArti == 0) {
                    ingredientChoisis += "artichauts + ";
                    butArtichauts.setBackgroundColor(Color.YELLOW);
                    clickArti ++;
                    break;
                }
                else
                    break;
            case R.id.butJambonCru:
                if(clickJambCru == 0) {
                    ingredientChoisis += "jambon cru + ";
                    butJambonCru.setBackgroundColor(Color.YELLOW);
                    clickJambCru ++;
                    break;
                }
                else
                    break;
            case R.id.butJambonCuit:
                if(clickJambCuit== 0) {
                    butJambonCuit.setBackgroundColor(Color.YELLOW);
                    ingredientChoisis += "jambon cuit + ";
                    clickJambCuit ++;
                    break;
                }
                else
                    break;

            case R.id.butValider2:

                ingredientChoisis = ingredientChoisis.substring(0, ingredientChoisis.length() -2);
                Commande2 commandeIngredient = new Commande2();
                commandeIngredient.execute(numtab2 + ingredientChoisis);

                FragmentTransaction transaction = getFragmentManager().beginTransaction(); //création de la transaction
                transaction.replace(R.id.fragment_container, PizzeriaMainActivity.fragment1);
                transaction.addToBackStack(null);
                transaction.commit();       //contenue du fragment apparait
                PizzeriaMainActivity.fragment1.buttonPers.setText("Pizza personnalisé : " + clickValid2++);
                break;
        }


    }
}
