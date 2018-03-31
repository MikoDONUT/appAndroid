package com.example.matias.pizza;

import android.preference.PreferenceActivity;

import com.example.matias.pizza.R;

import java.util.List;

/**
 * Created by Matias on 31/03/2018.
 */

//DEfintion du Preference Setting
public class MyPreferenceActivity extends PreferenceActivity {
    @Override
    public void onBuildHeaders(List<Header> target)
    {
        loadHeadersFromResource(R.xml.prefs, target);
    }

    @Override
    protected boolean isValidFragment(String fragmentName)
    {
        return MyPreferenceActivity.class.getName().equals(fragmentName);
    }
}