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
import android.view.SurfaceView;
import android.graphics.Path;

import androidx.annotation.RequiresApi;

import java.lang.Math;

//This class contains the necessary variables and methods for the face
public class Face extends SurfaceView {
    public int skinColor;
    public int eyeColor;
    public int hairColor;
    public int hairStyle;

    Paint skinPaint = new Paint();
    Paint eyePaint = new Paint();
    Paint hairPaint = new Paint();

    final int Marginx = 10;
    final int Marginy = 10;

    //Constructor for Face Object sets values of all instance variables to random values.
    public Face(Context context, AttributeSet attrs){
        super(context, attrs);
        setWillNotDraw(false);

        //Initialize colors to be random
        this.skinColor = randomize(0xFFFFFF)+(0xFF000000);
        this.eyeColor = randomize(0xFFFFFF)+(0xFF000000);
        this.hairColor = randomize(0xFFFFFF)+(0xFF000000);
        this.hairStyle = randomize(2);

        //other variables to initialize mainly for preference.
        skinPaint.setStyle(Paint.Style.FILL);
        eyePaint.setStyle(Paint.Style.FILL);
        hairPaint.setStyle(Paint.Style.FILL);
        setBackgroundColor(Color.BLACK);
    }

    //Don't know what this is but android studio really wanted it
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

    //On draw method is called whenever invalidate is called on an instance of this class
    @Override
    public void onDraw(Canvas c){
        //these colors are set again so that the colors can be changed via user interaction.
        skinPaint.setColor(this.skinColor);
        eyePaint.setColor(this.eyeColor);
        hairPaint.setColor(this.hairColor);

        //Return the width of the view
        int w = getWidth()-Marginx;
        int h = getHeight()-Marginy;

        //Draws the head
        int headW1 = w/8+Marginx;
        int headH1 = h/8-Marginy;
        int headW2 = 7*w/8;
        int headH2 = 7*h/8;

        //draws the face
        c.drawOval(headW1,headH1,headW2,headH2,skinPaint);
        drawEyes(c,w,h);
        drawMouth(c,w,h);
        drawHair(c,w,h,hairStyle);
    }

    //helper method draws both eyes. Takes in the size of canvas as parameters
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void drawEyes(Canvas c, int w, int h){
        //draw first eye
        c.drawOval(w/4,h/3,3*w/8,h/2,eyePaint);
        //draw second eye
        c.drawOval(w-w/4,h/3,w-3*w/8,h/2,eyePaint);
    }

    //helper method draws mouth. Takes canvas size as parameters
    public void drawMouth(Canvas c, int w, int h){
        RectF box = new RectF(w/4,2*h/5,w-w/4,3*w/5);
        c.drawArc(box,0.0f,180.0f,false,eyePaint);
    }

    //helper method to draw the hair. Takes canvas size and hairstyle number as parameters
    public void drawHair(Canvas c, int w, int h, int hairStyle){
        //basic hair style
        if (hairStyle == 0){
            RectF box = new RectF(w/4.9f,h/9,w-w/4.9f,3*h/7);
            c.drawArc(box,180.0f,180.0f,false,hairPaint);
        }
        //hat hairstyle
        else if(hairStyle == 1) {
            RectF box = new RectF(w/4.5f,h/10,w-w/4.5f,3*h/8);
            c.drawArc(box,180.0f,180.0f,false,hairPaint);
            c.drawRect(w/10,h/4-h/20,w-w/10,3*h/10-h/20,hairPaint);
        }
        //triangle horns
        else if(hairStyle == 2) {
            dTriangle(c,w/4,h/5,w/10,0);
            dTriangle(c,w-w/4,h/5,w/10,(float) Math.PI);
        }

    }

    //helper method draws an equilateral triangle with center x,y with radius r and angle offset o
    //This method is too complex for what I'm using it for, but it's fun to write so I did it
    public void dTriangle(Canvas c, float x, float y, float r, float o){
        Path t = new Path();
        //This tells us that the angle difference between each point is 2pi/3
        float s = (float) ((2.0*Math.PI)/3);
        //This loop starts at some angle and then creates a point 2pi/3 radians away from the first until the last point is drawn
        for (int i = 0; i < 4; i++) {
            t.lineTo(x + (float) (r * Math.cos(s*i+o)), y + (float) (r * Math.sin(s*i+o)));
        }
        //This takes the path and draws it
        c.drawPath(t,hairPaint);
    }
    //This method takes in an int called x and returns a random integer from [0,x]
    public static int randomize(int max){
        return (int) (Math.random()*max);
    }
}
