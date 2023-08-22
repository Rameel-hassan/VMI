package com.speedautosystems.vmi.enums;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

/**
 * Created by Rameel on 10/05/2021.
 * these include all screen which are after home screen
 */

public enum ScreenType implements Parcelable {

    SIMPLE_SCREEN(0),      // normal
    MOVEMENT(1),         // after checkcard this screen open
    CHECKLIST(2),      // after movement screen
    MARK_EXTERIOR(3),           // after checklist
    MARK_INTERIOR(4),           // after checklist

    SIGNTAURE(5),      // after marks

    VEHICLE_IMAGES(11), // Optional after MOVEMENT
    QUESTIONER(12),       // Optional after MOVEMENT for inspection

    ADD_VEHICLE(10),      // normal

    REPORTS(6),          // extra
    SETTINGS(7),         // extra

    REPAIR_MARKS(8);     // extra


    public static final Creator<ScreenType> CREATOR = new Creator<ScreenType>() {
        @Override
        public ScreenType createFromParcel(Parcel in) {
            return ScreenType.values()[in.readInt()];
        }

        @Override
        public ScreenType[] newArray(int size) {
            return new ScreenType[size];
        }
    };
    private final int id;


    ScreenType(int id) {
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
