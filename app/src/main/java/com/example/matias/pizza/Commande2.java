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

public class Commande2 extends AsyncTask<String, String, Void> {
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



}