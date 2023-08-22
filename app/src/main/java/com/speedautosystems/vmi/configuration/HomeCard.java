package com.speedautosystems.vmi.configuration;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;

/**
 * @author Rameel Hassan
 * Created 03/08/2023 at 11:56 am
 */
public class HomeCard implements Parcelable {

    public static final Creator<HomeCard> CREATOR = new Creator<HomeCard>() {
        @Override
        public HomeCard createFromParcel(Parcel in) {
            return new HomeCard(in);
        }

        @Override
        public HomeCard[] newArray(int size) {
            return new HomeCard[size];
        }
    };
    int order;
    int movementType;
    int totalStep;   //one,two
    String name;    // checkin , checkout
    int colorCode;  //
    int icon;       //
    ArrayList<HomeCardButton> options;

    public HomeCard(int order, int movementType, int totalStep, String name, HomeCardButton firstOption, HomeCardButton secOption) {
        this.order = order;
        this.movementType = movementType;
        this.totalStep = totalStep;
        this.name = name;
        this.options = options;
        this.options = new ArrayList<>();
        this.options.add(firstOption);
        this.options.add(secOption);
    }


    public HomeCard(int order, int movementType, int totalStep, String name, HomeCardButton firstOption) {
        this.order = order;
        this.movementType = movementType;
        this.totalStep = totalStep;
        this.name = name;
        this.options = options;
        this.options = new ArrayList<>();
        this.options.add(firstOption);
    }

    protected HomeCard(Parcel in) {
        order = in.readInt();
        movementType = in.readInt();
        totalStep = in.readInt();
        name = in.readString();
        colorCode = in.readInt();
        icon = in.readInt();
        options = in.createTypedArrayList(HomeCardButton.CREATOR);
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getTotalStep() {
        return totalStep;
    }

    public void setTotalStep(int totalStep) {
        this.totalStep = totalStep;
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

    public ArrayList<HomeCardButton> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<HomeCardButton> options) {
        this.options = options;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(order);
        parcel.writeInt(movementType);
        parcel.writeInt(totalStep);
        parcel.writeString(name);
        parcel.writeInt(colorCode);
        parcel.writeInt(icon);
        parcel.writeTypedList(options);
    }
}
