package com.speedautosystems.vmi.enums;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

/**
 * Created by Rameel on 10/05/2021.
 */
public enum StepType implements Parcelable {

    FIRST(0),
    SECOND(1);
    public static final Creator<StepType> CREATOR = new Creator<StepType>() {
        @Override
        public StepType createFromParcel(Parcel in) {
            return StepType.values()[in.readInt()];
        }

        @Override
        public StepType[] newArray(int size) {
            return new StepType[size];
        }
    };
    private final int id;


    StepType(int id) {
        this.id = id;
    }

    public int getValue() {
        return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
    }
}
