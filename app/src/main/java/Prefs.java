import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.example.matias.pizza.PizzeriaMainActivity;
import com.example.matias.pizza.R;

/**
 * Created by Matias on 30/03/2018.
 */

public class Prefs extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Affichage à partir du fichier XML
        addPreferencesFromResource(R.xml.prefs);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        //((PizzeriaMainActivity)getActivity()).applyPref();
    }

    // Lancement de l’écouteur
    @Override
    public void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    // Arrêt de l’écouteur
    @Override
    public void onPause() {
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
    }

}
