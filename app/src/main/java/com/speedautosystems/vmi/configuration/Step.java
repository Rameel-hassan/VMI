package com.speedautosystems.vmi.configuration;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.speedautosystems.vmi.enums.StepType;

import java.util.ArrayList;

/**
 * @author Rameel Hassan
 * Created 03/08/2023 at 11:56 am
 */
public class Step implements Parcelable {

    public static final Creator<Step> CREATOR = new Creator<Step>() {
        @Override
        public Step createFromParcel(Parcel in) {
            return new Step(in);
        }

        @Override
        public Step[] newArray(int size) {
            return new Step[size];
        }
    };
    String name;
    StepType stepType;  //checkin or  checkout
    ArrayList<ScreenConfig> screenList;

    public Step(String name, StepType stepType, ArrayList<ScreenConfig> screenList) {
        this.name = name;
        this.stepType = stepType;
        this.screenList = screenList;
    }

    protected Step(Parcel in) {
        name = in.readString();
        stepType = in.readParcelable(StepType.class.getClassLoader());
        screenList = in.createTypedArrayList(ScreenConfig.CREATOR);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeParcelable(stepType, i);
        parcel.writeTypedList(screenList);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StepType getStepType() {
        return stepType;
    }

    public void setStepType(StepType stepType) {
        this.stepType = stepType;
    }

    public ArrayList<ScreenConfig> getScreenList() {
        return screenList;
    }

    public void setScreenList(ArrayList<ScreenConfig> screenList) {
        this.screenList = screenList;
    }
}
