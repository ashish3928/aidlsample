package com.example.sampleapp;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public class DataModel implements Parcelable {

    String name;

    int id;

    String department;

    ArrayList<String> interests;

    ArrayList<SubModel> moreData;

    public DataModel() {

    }

    protected DataModel(Parcel in) {
        name = in.readString();
        id = in.readInt();
        department = in.readString();
        interests = in.createStringArrayList();
        moreData = in.createTypedArrayList(SubModel.CREATOR);
    }

    public static final Creator<DataModel> CREATOR = new Creator<DataModel>() {
        @Override
        public DataModel createFromParcel(Parcel in) {
            return new DataModel(in);
        }

        @Override
        public DataModel[] newArray(int size) {
            return new DataModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(id);
        dest.writeString(department);
        dest.writeStringList(interests);
        dest.writeTypedList(moreData);
    }

    public static class SubModel implements Parcelable {

        int id;

        String data;

        public SubModel() {

        }

        protected SubModel(Parcel in) {
            id = in.readInt();
            data = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
            dest.writeString(data);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<SubModel> CREATOR = new Creator<SubModel>() {
            @Override
            public SubModel createFromParcel(Parcel in) {
                return new SubModel(in);
            }

            @Override
            public SubModel[] newArray(int size) {
                return new SubModel[size];
            }
        };
    }
}
