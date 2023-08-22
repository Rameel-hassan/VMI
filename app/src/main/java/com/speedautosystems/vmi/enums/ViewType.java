package com.speedautosystems.vmi.enums;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

/**
 * Created by Rameel on 10/05/2021.
 */
public enum ViewType implements Parcelable {
    SIMPLE(0),

    VEHICLE(1),
    VEHICLE_MAKE_MODEL(2),
    VEHICLE_MAKE_MODEL_SEARCHABLE(3),

    KM_FIRST(4),
    KM_SECOND(5),

    FUEL_FIRST(6),
    FUEL_SECOND(7),
    CHARGING_FIRST(8),
    CHARGING_SECOND(9),


    CUSTOMER(10),
    DRIVER(11),
    WORKSHOP(12),
    BRANCH(13);

    public static final Creator<ViewType> CREATOR = new Creator<ViewType>() {
        @Override
        public ViewType createFromParcel(Parcel in) {
            return ViewType.values()[in.readInt()];

        }

        @Override
        public ViewType[] newArray(int size) {
            return new ViewType[size];
        }
    };
    private final int id;

    ViewType(int id) {
        this.id = id;
    }

    public static ViewType GetValue(int _id) {
        ViewType[] As = ViewType.values();
        for (int i = 0 ; i < As.length ; i++) {
            if (As[i].Compare(_id))
                return As[i];
        }
        return ViewType.SIMPLE;
    }

    public boolean Compare(int i) {
        return id == i;
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
