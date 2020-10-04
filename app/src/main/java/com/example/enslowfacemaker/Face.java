//@Ryan Enslow
//


package com.example.enslowfacemaker;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;

import androidx.annotation.RequiresApi;

import java.lang.Math;

//This class contains the necessary variables and methods for the face
public class Face extends SurfaceView {
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle;

    Paint skinPaint = new Paint();
    Paint eyePaint = new Paint();
    Paint hairPaint = new Paint();

    final int Marginx = 10;
    final int Marginy = 10;



    //Constructor for Face Object sets values of all instance variables to random values.
    public Face(Context context, AttributeSet attrs){
        super(context, attrs);
        setWillNotDraw(false);

        //any constants will go here


        this.skinColor = randomize(0xFFFFFF)+(0xFF000000);
        this.eyeColor = randomize(0xFFFFFF)+(0xFF000000);
        this.hairColor = randomize(0xFFFFFF)+(0xFF000000);
        this.hairStyle = randomize(3);

        skinPaint.setColor(this.skinColor);
        eyePaint.setColor(this.eyeColor);
        hairPaint.setColor(this.hairColor);
        skinPaint.setStyle(Paint.Style.FILL);
        eyePaint.setStyle(Paint.Style.FILL);
        hairPaint.setStyle(Paint.Style.FILL);

        setBackgroundColor(Color.BLACK);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onDraw(Canvas c){
        int w = getWidth()-Marginx;
        int h = getHeight()-Marginy;
        int headW1 = w/8+Marginx;
        int headH1 = h/8-Marginy;
        int headW2 = 7*w/8;
        int headH2 = 7*h/8;

        //draws the head
        c.drawOval(headW1,headH1,headW2,headH2,skinPaint);
        drawEyes(c,w,h);
        drawMouth(c,w,h);


    }

    //not sure what this means entirely, but android studio really wanted it in there
    //helper method draws both eyes. Takes in the size of canvas as parameters
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void drawEyes(Canvas c, int w, int h){
        //draw first eye
        c.drawOval(w/4,h/4,3*w/8,h/2,eyePaint);
        c.drawOval(w-w/4,h/4,w-3*w/8,h/2,eyePaint);

    }

    //helper method draws mouth. Takes canvas size as parameters
    public void drawMouth(Canvas c, int w, int h){
        RectF box = new RectF(w/4,2*h/5,w-w/4,3*w/5);
        c.drawArc(box,0.0f,180.0f,false,eyePaint);
    }

    //helper method to draw the hair. Takes canvas size and hairstyle as parameters
    public void drawHair(Canvas c, int w, int h, int hairStyle){
        if (hairStyle == 1){

        }
        else if(hairStyle == 2){

        }
        else{

        }

    }

    //This method takes in an int called x and returns a random integer from [0,x]
    public int randomize(int max){
        return (int) (Math.random()*max);
    }
}
