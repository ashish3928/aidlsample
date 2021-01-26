// IDataAidlInterface.aidl
package com.example.sampleapp;

parcelable DataModel;
// Declare any non-default types here with import statements

interface IDataAidlInterface {

    void sendDataModel(in DataModel data);

    DataModel getDataModel();

    int performOp(int operation);
}