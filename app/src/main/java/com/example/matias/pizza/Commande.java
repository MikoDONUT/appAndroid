package com.example.matias.pizza;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Matias on 14/03/2018.
 */

public class Commande extends AsyncTask<String, String, Void> {
    private int port = 9874;
    @Override
    //code exécuter par la tâche
    protected Void doInBackground(String... strings) {
        //crétion d'un socket pour lire et écrire des message au serveur
        Socket socket = null;

        try{
            socket = new Socket("chadok.info", port);  //création de socket faisant la connexion client/serveur
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer.println(strings[0]); //envoie du message au serveur avec retour à la ligne
            String retour1 = reader.readLine();  //lecture des message envoyer dans le socket par le serveur
            if (retour1 != null) {      //bien verifier à ce que reader ne soit pas vide
                System.out.println("Message du serveur : " + retour1);
                //onProgressUpdate(retour1);    //lance l'affichage mais redemarre l'application
                publishProgress(retour1); //envoie du premier message pour affichage de celui-ci sur l'écrande commande
            }
            String s= "";
            //readLine a un timeout integré, ce qui fait que s'il ne reçoit
            //aucune ligne de caractère la variable ne contiendra rien, c'est pour ça qu'avec while()
            //on oblige à attendre à ce que "s" contienne le message de retour
            while(s.equals("")){
                s = reader.readLine();
            }
            publishProgress(s); //envoie du second message cette fois-ci
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
        PizzeriaMainActivity.text1.setText(messageRetour[0]); //modification du text de l'écran de commande pour afficher les message
    }


}