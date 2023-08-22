package com.speedautosystems.vmi.configuration;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;

/**
 * @author Rameel Hassan
 * Created 03/08/2023 at 11:54 am
 */
public class HomeConfig implements Parcelable {
    public static final Creator<HomeConfig> CREATOR = new Creator<HomeConfig>() {
        @Override
        public HomeConfig createFromParcel(Parcel in) {
            return new HomeConfig(in);
        }

        @Override
        public HomeConfig[] newArray(int size) {
            return new HomeConfig[size];
        }
    };
    int screenDividedInParts;
    ArrayList<HomeCard> homeCards;

    protected HomeConfig(Parcel in) {
        screenDividedInParts = in.readInt();
        homeCards = in.createTypedArrayList(HomeCard.CREATOR);
    }

    public HomeConfig(int screenDividedInParts, ArrayList<HomeCard> homeCards) {
        this.screenDividedInParts = screenDividedInParts;
        this.homeCards = homeCards;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(screenDividedInParts);
        parcel.writeTypedList(homeCards);
    }

    public int getScreenDividedInParts() {
        return screenDividedInParts;
    }

    public void setScreenDividedInParts(int screenDividedInParts) {
        this.screenDividedInParts = screenDividedInParts;
    }

    public ArrayList<HomeCard> getHomeCards() {
        return homeCards;
    }

    public void setHomeCards(ArrayList<HomeCard> homeCards) {
        this.homeCards = homeCards;
    }
}
