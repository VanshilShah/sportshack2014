package com.example.sportshack;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class FriendsActivity extends Activity {

 LinearLayout ll;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ll = new LinearLayout(this);
        ll.addView(new FriendsPanel(this));
        setContentView(ll);
    }
}
