//@Ryan Enslow

package com.example.enslowfacemaker;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;


//This is where the main method will be run from. It is empty for now until I work on Part B
public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener, SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener {

    private Face faceView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //required lines of code
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        faceView = findViewById(R.id.face);
        //See helper method description
        initializeListeners();


    }

    //Helper method to initialize all fo the listeners in the View
    public void initializeListeners(){
        //populateSpinner();

        Button rFace = findViewById(R.id.randFace);
        rFace.setOnClickListener(this);

        RadioGroup groupSelect = findViewById(R.id.radioGroup);
        groupSelect.setOnCheckedChangeListener(this);

        RadioButton hairSelect = findViewById(R.id.radioHair);
        hairSelect.setOnClickListener(this);

        RadioButton eyesSelect = findViewById(R.id.radioEyes);
        eyesSelect.setOnClickListener(this);

        RadioButton skinSelect = findViewById(R.id.radioSkin);
        skinSelect.setOnClickListener(this);

        SeekBar redBar = findViewById(R.id.redBar);
        redBar.setOnSeekBarChangeListener(this);

        SeekBar greenBar = findViewById(R.id.greenBar);
        greenBar.setOnSeekBarChangeListener(this);
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

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onClick(View view) {
        Log.d("onClick", "onClick: yoooo");
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

    }
}