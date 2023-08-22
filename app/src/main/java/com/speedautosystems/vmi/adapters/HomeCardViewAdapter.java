package com.speedautosystems.vmi.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.speedautosystems.vmi.configuration.HomeCard;
import com.speedautosystems.vmi.configuration.HomeCardButton;
import com.speedautosystems.vmi.databinding.DoubleActionBinding;
import com.speedautosystems.vmi.databinding.SingleActionBinding;
import com.speedautosystems.vmi.viewholders.DoubleOptionViewHolder;
import com.speedautosystems.vmi.viewholders.SingleOptionViewHolder;

import java.util.Comparator;
import java.util.List;

/**
 * @author Rameel Hassan
 * Created 03/08/2023 at 2:25 pm
 */
public class HomeCardViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private final Context mContext;
    List<HomeCard> homeCardsList;

    OnHomeCardButtonClick homeCardButtonClickListener;

    public HomeCardViewAdapter(Context Context, List<HomeCard> homeCardsList, OnHomeCardButtonClick cardButtonClickListener) {
        this.homeCardsList = homeCardsList;
        this.mContext = Context;
        this.homeCardButtonClickListener = cardButtonClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        return homeCardsList.get(position).getTotalStep();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        RecyclerView.ViewHolder viewHolder;


        switch (viewType) {
            case 1:
                SingleActionBinding singleItem = SingleActionBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                viewHolder = new SingleOptionViewHolder(singleItem);
                break;
            case 2:
                DoubleActionBinding doubleBinding = DoubleActionBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                viewHolder = new DoubleOptionViewHolder(doubleBinding);
                break;
            default:
                SingleActionBinding item = SingleActionBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                viewHolder = new SingleOptionViewHolder(item);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case 1:
                SingleOptionViewHolder vh1 = (SingleOptionViewHolder) holder;
                configureViewHolder1(vh1, position);
                break;
            case 2:
                DoubleOptionViewHolder vh2 = (DoubleOptionViewHolder) holder;
                configureViewHolder2(vh2, position);
                break;
            default:
                SingleOptionViewHolder vh3 = (SingleOptionViewHolder) holder;
                configureViewHolder1(vh3, position);
                break;

        }
    }

    private void configureViewHolder2(DoubleOptionViewHolder vh2, int position) {
        final HomeCard card = homeCardsList.get(position);
        vh2.binding.cardName.setText(card.getName());

        card.getOptions().sort(Comparator.comparingInt(HomeCardButton::getOrder));

        vh2.binding.firstStep.setText(card.getOptions().get(0).getName());
        vh2.binding.firstStep.setOnClickListener(view -> homeCardButtonClickListener.position(card.getOptions().get(0), position));

        vh2.binding.secStep.setText(card.getOptions().get(1).getName());
        vh2.binding.secStep.setOnClickListener(view -> homeCardButtonClickListener.position(card.getOptions().get(1), position));

    }

    private void configureViewHolder1(SingleOptionViewHolder vh1, int position) {
        final HomeCard card = homeCardsList.get(position);
        vh1.binding.cardName.setText(card.getName());

        vh1.binding.firstStep.setText(card.getOptions().get(0).getName());
        vh1.binding.firstStep.setOnClickListener(view -> homeCardButtonClickListener.position(card.getOptions().get(0), position));
    }

    @Override
    public int getItemCount() {
        if (homeCardsList == null)
            return 0;
        return homeCardsList.size();
    }

    public interface OnHomeCardButtonClick {
        void position(HomeCardButton homeCardButton, int position);
    }
}
