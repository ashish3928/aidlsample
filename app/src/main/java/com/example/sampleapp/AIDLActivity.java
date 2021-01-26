package com.example.sampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class AIDLActivity extends AppCompatActivity {

    private IDataAidlInterface myService;
    private boolean isConnected = false;
    private TextView textView, textView2;
    private Button sendButton , recieveButton , connectButton , disconnectButton;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            android.util.Log.d("Ashish", "Service Connected");
            myService = IDataAidlInterface.Stub.asInterface(service);
            try {
                myService.sendDataModel(new DataModel());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            myService = null;
            android.util.Log.d("Ashish", "Service Disconnected");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendButton = findViewById(R.id.sendData);
        recieveButton = findViewById(R.id.reciveData);
        connectButton = findViewById(R.id.connect);
        disconnectButton = findViewById(R.id.disconnect);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);


        connectButton.setOnClickListener(view -> {
           if (!isConnected) {
               android.util.Log.d("Ashish", "connecting to service");
               Intent intent = new Intent(this, MyService.class);
               bindService(intent, connection, BIND_AUTO_CREATE);
               isConnected = true;
           }
        });

        disconnectButton.setOnClickListener(view -> {
            if (isConnected) {
                android.util.Log.d("Ashish", "disconnecting to service");
                unbindService(connection);
                isConnected = false;
            }
        });

        sendButton.setOnClickListener(view -> {
            if (myService != null) {
                try {
                    int rand = new Random().nextInt();
                    myService.performOp(rand);
                    textView2.setText("" + rand);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        recieveButton.setOnClickListener(v -> {
            if (myService != null) {
                try {
                    DataModel model = myService.getDataModel();
                    textView.setText("" + model.id);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}