package com.example.sampleapp;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

public class MyService extends Service {

    private DataModel dataModel;

    public MyService() {
    }

    private Binder mBinder = new IDataAidlInterface.Stub() {

        @Override
        public void sendDataModel(DataModel data) throws RemoteException {
            dataModel = data;
        }

        @Override
        public DataModel getDataModel() throws RemoteException {
            return dataModel;
        }

        @Override
        public int performOp(int operation) {
            if (dataModel != null) {
                dataModel.id = operation;
                return 1;
            }
            return -1;
        }
    };

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        android.util.Log.d("Ashish", "Started");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        android.util.Log.d("Ashish","Destroyed");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        android.util.Log.d("Ashish", "onBind");
        return mBinder;
    }
}