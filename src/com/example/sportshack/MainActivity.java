package com.example.sportshack;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.thalmic.myo.AbstractDeviceListener;
import com.thalmic.myo.DeviceListener;
import com.thalmic.myo.Hub;
import com.thalmic.myo.Myo;
import com.thalmic.myo.Pose;
import com.thalmic.myo.scanner.ScanActivity;

public class MainActivity extends Activity {

    private static final String TAG = "Error";
    public static TextView status;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        
        status = (TextView) findViewById(R.id.status);
        status.setBackgroundColor(Color.DKGRAY);
        
        Hub hub = Hub.getInstance();
        if (!hub.init(this)) {
            Log.e(TAG, "Could not initialize the Hub.");
            status.setText("Could not initialize the Hub.");
            finish();
            return;
        }else{
        	status.setTextColor(Color.CYAN);
            status.setText("Hub Initialized");
        }
        Hub.getInstance().addListener(mListener);
        
    }
	
	 @Override
    protected void onResume() {
        super.onResume();
        // If Bluetooth is not enabled, request to turn it on.
        if (!BluetoothAdapter.getDefaultAdapter().isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivity(enableBtIntent);
        }
    }
	 
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // We don't want any callbacks when the Activity is gone, so unregister the listener.
        Hub.getInstance().removeListener(mListener);
        if (isFinishing()) {
            // The Activity is finishing, so shutdown the Hub. This will disconnect from the Myo.
            Hub.getInstance().shutdown();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void findMyo(View view){
    	Intent intent = new Intent(this, ScanActivity.class);
    	this.startActivity(intent);
    }
    
    private DeviceListener mListener = new AbstractDeviceListener() {
        @Override
        public void onConnect(Myo myo, long timestamp) {
            Toast.makeText(MainActivity.this, "Myo Connected!", Toast.LENGTH_SHORT).show();
            status.setTextColor(Color.GREEN);
            status.setText("Myo Connected");
        }

        @Override
        public void onDisconnect(Myo myo, long timestamp) {
            Toast.makeText(MainActivity.this, "Myo Disconnected!", Toast.LENGTH_SHORT).show();
            status.setTextColor(Color.RED);
            status.setText("Myo Connected");
        }

        @Override
        public void onPose(Myo myo, long timestamp, Pose pose) {
            Toast.makeText(MainActivity.this, "Pose: " + pose, Toast.LENGTH_SHORT).show();
            status.setTextColor(Color.GREEN);
            status.setText(pose.toString());
            //TODO: Do something awesome.
        }
    };

}
