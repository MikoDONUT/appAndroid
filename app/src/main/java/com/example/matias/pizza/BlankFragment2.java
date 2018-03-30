package com.example.matias.pizza;


import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.PorterDuff;
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

    ViewGroup.LayoutParams buttonparam;

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
                clickMoza++;
                if(clickMoza%2 == 1) {
                    //On change la couleur si l'ingrédient est sélectionner sinon il reste blanc
                    butMozzarella.getBackground().setColorFilter(Color.parseColor("#8ECBC3"), PorterDuff.Mode.MULTIPLY);
                    break;
                }
                else
                    butMozzarella.getBackground().setColorFilter(Color.parseColor("#FEFEFE"), PorterDuff.Mode.MULTIPLY);
                break;
            case R.id.butGorgonzola:
                clickGorgon++;
                if(clickGorgon%2 == 1) {
                    butGorgonzola.getBackground().setColorFilter(Color.parseColor("#28A292"), PorterDuff.Mode.MULTIPLY);
                    break;
                }
                else
                    butGorgonzola.getBackground().setColorFilter(Color.parseColor("#FEFEFE"), PorterDuff.Mode.MULTIPLY);
                    break;
            case R.id.butAnchois:
                clickAnch++;
                if(clickAnch%2 == 1) {
                    butAnchois.getBackground().setColorFilter(Color.parseColor("#582900"), PorterDuff.Mode.MULTIPLY);
                    break;
                }
                else
                    butAnchois.getBackground().setColorFilter(Color.parseColor("#FEFEFE"), PorterDuff.Mode.MULTIPLY);;
                    break;
            case R.id.butCapres:
                clickCap++;
                if(clickCap%2 == 1) {
                    butCapres.getBackground().setColorFilter(Color.parseColor("#798933"), PorterDuff.Mode.MULTIPLY);
                    break;
                }
                else
                    butCapres.getBackground().setColorFilter(Color.parseColor("#FEFEFE"), PorterDuff.Mode.MULTIPLY);
                    break;
            case R.id.butOlives:
                clickOliv ++;
                if(clickOliv%2 == 1) {
                    butOlives.getBackground().setColorFilter(Color.parseColor("#708D23"), PorterDuff.Mode.MULTIPLY);
                    break;
                }
                else
                    butOlives.getBackground().setColorFilter(Color.parseColor("#FEFEFE"), PorterDuff.Mode.MULTIPLY);
                    break;
            case R.id.butArtichauts:
                clickArti ++;
                if(clickArti%2 == 1) {
                    butArtichauts.getBackground().setColorFilter(Color.parseColor("#57D53B"), PorterDuff.Mode.MULTIPLY);
                    break;
                }
                else
                    butArtichauts.getBackground().setColorFilter(Color.parseColor("#FEFEFE"), PorterDuff.Mode.MULTIPLY);
                    break;
            case R.id.butJambonCru:
                clickJambCru ++;
                if(clickJambCru%2 == 1) {
                    butJambonCru.getBackground().setColorFilter(Color.parseColor("#9B0A00"), PorterDuff.Mode.MULTIPLY);
                    break;
                }
                else
                    butJambonCru.getBackground().setColorFilter(Color.parseColor("#FEFEFE"), PorterDuff.Mode.MULTIPLY);
                    break;
            case R.id.butJambonCuit:
                clickJambCuit ++;
                if(clickJambCuit%2 == 1) {
                    butJambonCuit.getBackground().setColorFilter(Color.parseColor("#FF866A"), PorterDuff.Mode.MULTIPLY);
                    break;
                }
                else
                    butJambonCuit.getBackground().setColorFilter(Color.parseColor("#FEFEFE"), PorterDuff.Mode.MULTIPLY);
                    break;

            case R.id.butValider2:
                Commande commandeIngredient = new Commande();
                commandeIngredient.execute(numtab2 + createListeIngredient());

                FragmentTransaction transaction = getFragmentManager().beginTransaction(); //création de la transaction
                transaction.replace(R.id.fragment_container, PizzeriaMainActivity.fragment1);
                transaction.addToBackStack(null);
                transaction.commit();       //contenue du fragment apparait
                PizzeriaMainActivity.fragment1.buttonPers.setText("Pizza personnalisé : " + clickValid2++);
                break;
        }


    }

    public String createListeIngredient(){
        String ingredientChoisis="";
        if(clickMoza%2==1) ingredientChoisis += "mozzarella + ";
        if(clickGorgon%2==1) ingredientChoisis += "gorgonzola + ";
        if(clickAnch%2==1) ingredientChoisis += "anchois + ";
        if(clickCap%2==1) ingredientChoisis += "capres + ";
        if(clickOliv%2==1) ingredientChoisis += "olives + ";
        if(clickArti%2==1) ingredientChoisis += "artichauts + ";
        if(clickJambCru%2==1) ingredientChoisis += "jambon cru + ";
        if(clickJambCuit%2==1) ingredientChoisis += "jambon cuit + ";
        return ingredientChoisis.substring(0, ingredientChoisis.length() -2);
    }
}