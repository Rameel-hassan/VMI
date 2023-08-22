package com.speedautosystems.vmi.configuration;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.speedautosystems.vmi.enums.ScreenType;
import com.speedautosystems.vmi.enums.ViewType;

import java.util.ArrayList;

/**
 * @author Rameel Hassan
 * Created 03/08/2023 at 11:54 am
 */
public class ScreenConfig implements Parcelable {
    public static final Creator<ScreenConfig> CREATOR = new Creator<ScreenConfig>() {
        @Override
        public ScreenConfig createFromParcel(Parcel in) {
            return new ScreenConfig(in);
        }

        @Override
        public ScreenConfig[] newArray(int size) {
            return new ScreenConfig[size];
        }
    };
    int order;
    ScreenType screenType;
    ArrayList<ViewType> visibleViewsTypeList;

    public ScreenConfig(int order, ScreenType screenType) {
        this.order = order;
        this.screenType = screenType;
    }

    public ScreenConfig(int order, ScreenType screenType, ArrayList<ViewType> viewTypeArrayList) {
        this.order = order;
        this.screenType = screenType;
        this.visibleViewsTypeList = viewTypeArrayList;
    }

    protected ScreenConfig(Parcel in) {
        order = in.readInt();
        screenType = in.readParcelable(ScreenType.class.getClassLoader());
        visibleViewsTypeList = in.createTypedArrayList(ViewType.CREATOR);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(order);
        parcel.writeParcelable(screenType, i);
        parcel.writeTypedList(visibleViewsTypeList);
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public ScreenType getScreenType() {
        return screenType;
    }

    public void setScreenType(ScreenType screenType) {
        this.screenType = screenType;
    }

    public ArrayList<ViewType> getVisibleViewsTypeList() {
        return visibleViewsTypeList;
    }

    public void setVisibleViewsTypeList(ArrayList<ViewType> visibleViewsTypeList) {
        this.visibleViewsTypeList = visibleViewsTypeList;
    }
}
