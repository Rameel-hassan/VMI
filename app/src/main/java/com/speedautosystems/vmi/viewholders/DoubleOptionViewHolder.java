package com.speedautosystems.vmi.viewholders;

import androidx.recyclerview.widget.RecyclerView;

import com.speedautosystems.vmi.databinding.DoubleActionBinding;


/**
 * @author Rameel Hassan
 * Created 03/08/2023 at 3:07 pm
 */
public class DoubleOptionViewHolder extends RecyclerView.ViewHolder {
    public DoubleActionBinding binding;

    public DoubleOptionViewHolder(DoubleActionBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
