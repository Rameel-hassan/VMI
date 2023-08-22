package com.speedautosystems.vmi.viewholders;

import androidx.recyclerview.widget.RecyclerView;

import com.speedautosystems.vmi.databinding.SingleActionBinding;


/**
 * @author Rameel Hassan
 * Created 03/08/2023 at 3:07 pm
 */
public class SingleOptionViewHolder extends RecyclerView.ViewHolder {
    public SingleActionBinding binding;


    public SingleOptionViewHolder(SingleActionBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
