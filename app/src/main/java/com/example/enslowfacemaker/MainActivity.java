//@Ryan Enslow

package com.example.enslowfacemaker;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import static com.example.enslowfacemaker.Face.randomize;


//This is where the main method will be run from. It is empty for now until I work on Part B
public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener, SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener {

    private Face faceView;
    private int rSlide = 0;
    private int gSlide = 0;
    private int bSlide = 0;
    private RadioButton hairSelect;
    private RadioButton skinSelect;
    private RadioButton eyesSelect;
    private SeekBar redBar;
    private SeekBar greenBar;
    private SeekBar blueBar;

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
        populateSpinner();

        Button rFace = findViewById(R.id.randFace);
        rFace.setOnClickListener(this);

        RadioGroup groupSelect = findViewById(R.id.radioGroup);
        groupSelect.setOnCheckedChangeListener(this);

        this.hairSelect = findViewById(R.id.radioHair);
        this.hairSelect.setOnClickListener(this);

        this.eyesSelect = findViewById(R.id.radioEyes);
        this.eyesSelect.setOnClickListener(this);

        this.skinSelect = findViewById(R.id.radioSkin);
        this.skinSelect.setOnClickListener(this);

        this.redBar = findViewById(R.id.redBar);
        this.redBar.setOnSeekBarChangeListener(this);

        this.greenBar = findViewById(R.id.greenBar);
        this.greenBar.setOnSeekBarChangeListener(this);

        this.blueBar = findViewById(R.id.blueBar);
        this.blueBar.setOnSeekBarChangeListener(this);
    }

    //This is the helper method that will populate the Spinner
    public void populateSpinner() {
        /**
        External Citation:
        Problem: Didn't know how to make a spinner work
        This block of code finds the spinner and then populates it with items in an array located in the resource folder. I learned how to do this from the Android Studio Documentation for spinners
        https://developer.android.com/guide/topics/ui/controls/spinner#java
         */
        Spinner hairSpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> a = ArrayAdapter.createFromResource(this, R.array.hair_array, android.R.layout.simple_spinner_item);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hairSpinner.setAdapter(a);
        hairSpinner.setOnItemSelectedListener(this);
    }

    //listener to check if new hair has been selected
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        faceView.hairStyle = i;
        faceView.invalidate();
    }

    //This method doesn't do anything, but I'm too scared to delete it
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        faceView.hairStyle = 0;
        faceView.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    //This line helps me sleep at night but it's basically useless
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        faceView.invalidate();
    }


    //This method is called whenever a seekbar is moved.
    //This controls updating the color of the drawings on screen
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        //Determines which bar is moved and sets a value to the progress corresponding to the bar.
        //Then it updates the color
        if (seekBar.getId()==R.id.redBar){ rSlide = i; }
        else if (seekBar.getId()==R.id.greenBar){ gSlide = i; }
        else{ bSlide = i; }

        int c = Color.rgb(rSlide,gSlide,bSlide);
        if (this.hairSelect.isChecked()){ faceView.hairColor = c; }
        else if (this.eyesSelect.isChecked()){ faceView.eyeColor = c; }
        else if (this.skinSelect.isChecked()){ faceView.skinColor = c; }
        faceView.invalidate();
    }

    //This onClick method controls the radioButtons and the Random Button
    @Override
    public void onClick(View view) {
        int r;
        int g;
        int b;
        //Controls random button
        if (view.getId() == R.id.randFace) {
            faceView.skinColor = randomize(0xFFFFFF) + (0xFF000000);
            faceView.eyeColor = randomize(0xFFFFFF) + (0xFF000000);
            faceView.hairColor = randomize(0xFFFFFF) + (0xFF000000);
            faceView.hairStyle = randomize(3);
            RadioGroup n = findViewById(R.id.radioGroup);
            n.clearCheck();
        }

        //Controls all three seekbars
        //Set seekbar back to values it had
        //I really felt like I was able to shorten this code down, but it made things worse so I reverted it back im sorry
        else if (view.getId() == R.id.radioHair){
            r = Color.red(faceView.hairColor);
            g = Color.green(faceView.hairColor);
            b = Color.blue(faceView.hairColor);
            this.redBar.setProgress(r);
            this.greenBar.setProgress(g);
            this.blueBar.setProgress(b);
        }
        else if (view.getId() == R.id.radioEyes){
            r = Color.red(faceView.eyeColor);
            g = Color.green(faceView.eyeColor);
            b = Color.blue(faceView.eyeColor);
            this.redBar.setProgress(r);
            this.greenBar.setProgress(g);
            this.blueBar.setProgress(b);
        }
        else if (view.getId() == R.id.radioSkin){
            r = Color.red(faceView.skinColor);
            g = Color.green(faceView.skinColor);
            b = Color.blue(faceView.skinColor);
            this.redBar.setProgress(r);
            this.greenBar.setProgress(g);
            this.blueBar.setProgress(b);
        }
        faceView.invalidate();
    }
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
    }

}