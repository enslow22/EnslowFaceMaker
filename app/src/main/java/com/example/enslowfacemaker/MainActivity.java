//@Ryan Enslow

package com.example.enslowfacemaker;


import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import androidx.appcompat.app.AppCompatActivity;


//This is where the main method will be run from. It is empty for now until I work on Part B
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

    }


    //This is the helper method that will populate the Spinner
    public void populateSpinner() {
        //This block of code finds the spinner and then populates it with items in an array located in the resource folder. I learned how to do this from the Android Studio Documentation for spinners
        //https://developer.android.com/guide/topics/ui/controls/spinner#java
        Spinner hairSpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> a = ArrayAdapter.createFromResource(this, R.array.hair_array, android.R.layout.simple_spinner_item);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hairSpinner.setAdapter(a);
        hairSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}