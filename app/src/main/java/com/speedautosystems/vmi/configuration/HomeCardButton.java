package com.speedautosystems.vmi.configuration;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.speedautosystems.vmi.enums.StepType;
import com.speedautosystems.vmi.enums.ViewType;

import java.util.ArrayList;

/**
 * @author Rameel Hassan
 * Created 03/08/2023 at 11:57 am
 */
public class HomeCardButton implements Parcelable {
    public static final Creator<HomeCardButton> CREATOR = new Creator<HomeCardButton>() {
        @Override
        public HomeCardButton createFromParcel(Parcel in) {
            return new HomeCardButton(in);
        }

        @Override
        public HomeCardButton[] newArray(int size) {
            return new HomeCardButton[size];
        }
    };
    int order;     // on screen order
    Step step;
    String name;    // checkin , checkout
    int colorCode;  //
    int icon;       //
    ArrayList<ViewType> visibleViewsTypeList;
    StepType stepType;  //checkin or  checkout

    public HomeCardButton(int order, Step step, String name) {
        this.order = order;
        this.step = step;
        this.name = name;
    }


    //todo remove this is don't need this
    public HomeCardButton(int order, String name) {
        this.order = order;
        this.name = name;
    }

    protected HomeCardButton(Parcel in) {
        order = in.readInt();
        step = in.readParcelable(Step.class.getClassLoader());
        name = in.readString();
        colorCode = in.readInt();
        icon = in.readInt();
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColorCode() {
        return colorCode;
    }

    public void setColorCode(int colorCode) {
        this.colorCode = colorCode;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public Step getStep() {
        return step;
    }

    public void setStep(Step step) {
        this.step = step;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(order);
        parcel.writeParcelable(step, i);
        parcel.writeString(name);
        parcel.writeInt(colorCode);
        parcel.writeInt(icon);
    }
}
