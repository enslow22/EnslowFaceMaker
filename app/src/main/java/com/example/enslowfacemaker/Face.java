//@Ryan Enslow
//


package com.example.enslowfacemaker;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;

import java.lang.Math;

//This class contains the necessary variables and methods for the face
public class Face extends SurfaceView {
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle;

    //Constructor for Face Object sets values of all instance variables to random values.
    public Face(Context context, AttributeSet attrs){
        super(context, attrs);
        setWillNotDraw(false);
        this.skinColor = randomize(255.0);
        this.eyeColor = randomize(255.0);
        this.hairColor = randomize(255.0);
        this.hairStyle = randomize(3.0);
    }

    @Override
    public void onDraw(Canvas c){

    }

    //This method takes in a double called x and returns a random integer from [0,x]
    public int randomize(double max){
        return (int) (Math.random()*(max));
    }
}
