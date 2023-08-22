package com.speedautosystems.vmi.fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.speedautosystems.vmi.adapters.HomeCardViewAdapter;
import com.speedautosystems.vmi.configuration.HomeCard;
import com.speedautosystems.vmi.configuration.HomeCardButton;
import com.speedautosystems.vmi.configuration.ScreenConfig;
import com.speedautosystems.vmi.databinding.FragmentHomeBinding;
import com.speedautosystems.vmi.seed.SeedData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by Yasir on 4/5/2016.
 */
public class HomeFragment extends BaseFragment {


    FragmentHomeBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Home");


        binding.homeLayout.setWeightSum(SeedData.HOME_CONFIG.getScreenDividedInParts());

        Log.d("HomeFragment", "onViewCreated data : " + new Gson().toJson(SeedData.HOME_CONFIG));

        bindDataToAdapter();

    }

    private void bindDataToAdapter() {

        SeedData.HOME_CONFIG.getHomeCards().sort(Comparator.comparingInt(HomeCard::getOrder));
        SeedData.HOME_CONFIG.getHomeCards().sort(Comparator.comparingInt(HomeCard::getOrder));

        List<HomeCard> homeCards = SeedData.HOME_CONFIG.getHomeCards();
        binding.mainview.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        binding.mainview.setLayoutManager(new LinearLayoutManager(getActivity()));

        binding.mainview.setAdapter(new HomeCardViewAdapter(getActivity(), homeCards, new HomeCardViewAdapter.OnHomeCardButtonClick() {
            @Override
            public void position(HomeCardButton homeCardButton, int position) {

                step = homeCardButton.getStep();

                if (step == null) {
                    Toast.makeText(getContext(), "no step found", Toast.LENGTH_SHORT).show();
                    return;
                }
                screenListToGo = null;
                screenListToGo = homeCardButton.getStep().getScreenList().stream()
                        .map(ScreenConfig::getScreenType)
                        .collect(Collectors.toCollection(ArrayList::new));
                onNextClicked();

            }
        }));

    }

    private boolean validateData() {
        return true;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
