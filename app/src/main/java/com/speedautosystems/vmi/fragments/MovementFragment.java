package com.speedautosystems.vmi.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.speedautosystems.vmi.adapters.VehicleSelectViewAdapter;
import com.speedautosystems.vmi.databinding.FragmentMovementBinding;


/**
 * Created by Yasir on 4/5/2016.
 */
public class MovementFragment extends BaseFragment {


    FragmentMovementBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMovementBinding.inflate(inflater, container, false);
        getActivity().setTitle(step.getName());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNextClicked();
            }
        });
        bindDataToAdapter();
    }

    private void bindDataToAdapter() {

        binding.mainview.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        binding.mainview.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.mainview.setAdapter(new VehicleSelectViewAdapter(getActivity(), step.getScreenList().get(currentScreenTypeIndex)));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
