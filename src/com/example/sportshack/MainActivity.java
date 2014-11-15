package com.example.sportshack;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
    
    DrawingPanel dp;
    LinearLayout ll;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);            
        super.onCreate(savedInstanceState);
        
        //opens drawingPanel, where simulation runs
        ll = new LinearLayout(this);
        dp = new DrawingPanel(this);
        ll.addView(dp);
        setContentView(ll);
    }
}