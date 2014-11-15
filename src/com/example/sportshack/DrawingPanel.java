package com.example.sportshack;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.shapes.Shape;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Button;

public class DrawingPanel extends SurfaceView implements SurfaceHolder.Callback {
    
    PanelThread thread;      
    public Paint paint = new Paint();
    
    //Constructors
    public DrawingPanel(Context context) { 
        super(context); 
        this.setBackgroundColor(Color.WHITE);
    }
     
     //Essentially the main method, runs multiple times and is where updating and drawing is done.
     @Override 
     public void onDraw(Canvas canvas) {
        //do drawing stuff here.
         update();
         draw(canvas, paint);             
    }
 
     @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }
     
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        setWillNotDraw(false); //Allows us to use invalidate() to call onDraw()
        thread = new PanelThread(getHolder(), this); //Start the thread that
        thread.setRunning(true);                     //will make calls to onDraw()
        thread.start();
        init();
    }
    
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        try {
            thread.setRunning(false); // Tells thread to stop
            thread.join();            // Removes thread from mem
         } catch (InterruptedException e) {
             
         }
    }
    
    public void init() {
        
    }
    
    public void update() {
        
    }
       
    public void draw(Canvas canvas, Paint paint) {
        int x = 20, y = 25, boxWidth = 50, boxHeight = 75;
        canvas.drawRect(new Rect(x, y, boxWidth, boxHeight), paint);
    }
}
