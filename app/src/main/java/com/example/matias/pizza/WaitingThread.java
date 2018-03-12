package com.example.matias.pizza;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Matias on 12/03/2018.
 */

private class WaitingThread extends AsyncTask<String, String, String> {
    private final int wait = (int) (Math.random() * (120000 - 60000 + 1000)) + 60000; //temps compris entre 1 et 2 minutes
    private final int number = 6;
    private int port = 9874;

    Socket socket = new Socket(chadok.info, port);
    PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    //writer.append(CharSequence "" + "");    //envoie du message au serveur
    //reader.readLine();  //lecture des message envoyer dans le socket par le serveur

    @Override
    //avant l’exécution de la tâche
    protected void onPreExecute(){
        affichage.setText("Lancement du thread...");
    }

    @Override
    //code a exécuter par la tâche
    protected Integer doInBackground(Void... voids) {
        for (int count = 0; count < number; count++) {
            Thread.sleep(wait);
            publishProgress(count + 1);

        }
        return number;
    }

    //pendant l'exécution de la tâche
    @Override
    protected void onProgressUpdate(Integer... counts) {
        int time = counts[0] * wait / 1000;
        affichage.setText("Le thread s’execute depuis " + time + " secondes");
    }

    //après l’exécution de la tâche
    @Override
    protected void onPostExecute(Integer res) {
        int time = res * wait / 1000;
        affichage.setText("Le thread a fini ; il s’est execute pendant " + time + " secondes");
    }
}


//socket.close();