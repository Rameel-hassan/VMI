package com.speedautosystems.vmi.partialviews;

import android.os.Parcelable;

import androidx.recyclerview.widget.RecyclerView;

import com.speedautosystems.vmi.databinding.PartialFuelFirstBinding;


/**
 * @author Rameel Hassan
 * Created 03/08/2023 at 3:07 pm
 */
public class FuelFirstView extends RecyclerView.ViewHolder implements PartialViewInterface {
    public PartialFuelFirstBinding binding;


    public FuelFirstView(PartialFuelFirstBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    @Override
    public void createView() {

    }

    @Override
    public void fillData(Parcelable obj) {

    }

    @Override
    public boolean isValidated() {
        return false;
    }

    @Override
    public Parcelable getParceableObject() {
        return null;
    }
}
