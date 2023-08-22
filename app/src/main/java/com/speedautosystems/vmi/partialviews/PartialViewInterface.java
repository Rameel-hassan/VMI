package com.speedautosystems.vmi.partialviews;

import android.os.Parcelable;

/**
 * @author Rameel Hassan
 * Created 03/08/2023 at 10:08 am
 */
public interface PartialViewInterface {
    void createView();

    void fillData(Parcelable obj);

    boolean isValidated();

    Parcelable getParceableObject();
}
