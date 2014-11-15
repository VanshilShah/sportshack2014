package com.example.sportshack;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import bolts.Continuation;
import bolts.Task;

import com.ibm.mobile.services.cloudcode.IBMCloudCode;
import com.ibm.mobile.services.core.IBMBluemix;
import com.ibm.mobile.services.data.IBMData;
import com.ibm.mobile.services.data.IBMDataObject;
import com.ibm.mobile.services.data.file.IBMFileSync;
import com.thalmic.myo.DeviceListener;
import com.thalmic.myo.Hub;
import com.thalmic.myo.scanner.ScanActivity;

public class Myo_Handler {
    /*public void onCreate(){
    
        setContentView(R.layout.activity_main);

        status = (TextView) findViewById(R.id.status);
        status.setBackgroundColor(Color.DKGRAY);

        initHub();
        initBluemix();

    }
    private void initHub(){
        Hub hub = Hub.getInstance();
        if (!hub.init(this)) {
            Log.e("Error", "Could not initialize the Hub.");
            status.setText("Could not initialize the Hub.");
            finish();
            return;
        } else {
            status.setTextColor(Color.CYAN);
            //status.setText("Hub Initialized");
        }
        Hub.getInstance().addListener(mListener);
    }
    private void initBluemix(){
        IBMBluemix.initialize(this, APPLICATION_ID,
                APPLICATION_SECRET, APPLICATION_ROUTE);
        IBMCloudCode cloudCodeService = IBMCloudCode.initializeService();
        IBMData.initializeService();

        IBMData dataService = IBMData.initializeService();  //Initializing object storage capability
    
        IBMFileSync fileSync = IBMFileSync.initializeService();  //Initializing file storage capability

        Player.registerSpecialization(Player.class);  //Registering a specialization
        //IBMPush.initializeService();
        createAndSavePlayer("11", "Vanshil");
    }
    private void createAndSavePlayer(String number, String name){
        Player player = new Player(number, name);
        player.save().continueWith(new Continuation<IBMDataObject, Void>() {

            @Override
            public Void then(Task<IBMDataObject> task) throws Exception {
                if (task.isFaulted()) {
                    // Handle errors
                    status.setText("no work");
                } else {
                    Player myPlayer = (Player) task.getResult();
                    status.setText("player created!");
                    // Do more work
                }
                return null;
            }
        });
    }
    @Override*/
/*    private DeviceListener mListener = new AbstractDeviceListener() {
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
    
    *
    *
    public void findMyo(View view){
        Intent intent = new Intent(this, ScanActivity.class);
        this.startActivity(intent);
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
    */
}
