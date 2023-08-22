package com.speedautosystems.vmi.adapters;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.speedautosystems.vmi.configuration.ScreenConfig;
import com.speedautosystems.vmi.databinding.PartialBranchBinding;
import com.speedautosystems.vmi.databinding.PartialChargingFirstBinding;
import com.speedautosystems.vmi.databinding.PartialChargingSecondBinding;
import com.speedautosystems.vmi.databinding.PartialCustomerBinding;
import com.speedautosystems.vmi.databinding.PartialDriverBinding;
import com.speedautosystems.vmi.databinding.PartialFuelFirstBinding;
import com.speedautosystems.vmi.databinding.PartialFuelSecondBinding;
import com.speedautosystems.vmi.databinding.PartialKmFirstBinding;
import com.speedautosystems.vmi.databinding.PartialKmSecondBinding;
import com.speedautosystems.vmi.databinding.PartialSimpleBinding;
import com.speedautosystems.vmi.databinding.PartialVehicleBinding;
import com.speedautosystems.vmi.databinding.PartialVehicleMakeModelBinding;
import com.speedautosystems.vmi.databinding.PartialVehicleMakeModelSearchableBinding;
import com.speedautosystems.vmi.databinding.PartialWorkshopBinding;
import com.speedautosystems.vmi.enums.ViewType;
import com.speedautosystems.vmi.partialviews.BranchView;
import com.speedautosystems.vmi.partialviews.ChargingFirstView;
import com.speedautosystems.vmi.partialviews.ChargingSecondView;
import com.speedautosystems.vmi.partialviews.CustomerView;
import com.speedautosystems.vmi.partialviews.DriverView;
import com.speedautosystems.vmi.partialviews.FuelFirstView;
import com.speedautosystems.vmi.partialviews.FuelSecondView;
import com.speedautosystems.vmi.partialviews.KmFirstView;
import com.speedautosystems.vmi.partialviews.KmSecondView;
import com.speedautosystems.vmi.partialviews.SimpleView;
import com.speedautosystems.vmi.partialviews.VehicleMakeModelSearchableView;
import com.speedautosystems.vmi.partialviews.VehicleMakeModelView;
import com.speedautosystems.vmi.partialviews.VehicleView;
import com.speedautosystems.vmi.partialviews.WorkshopView;

import java.util.List;

/**
 * @author Rameel Hassan
 * Created 03/08/2023 at 2:25 pm
 */
public class VehicleSelectViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private final Context mContext;
    List<ViewType> viewTypeList;

    ScreenConfig screenConfig;
    Parcelable parcelable;


    public VehicleSelectViewAdapter(Context Context, ScreenConfig screenConfig) {
        this.screenConfig = screenConfig;
        this.viewTypeList = screenConfig.getVisibleViewsTypeList();
        this.mContext = Context;

    }

    @Override
    public int getItemViewType(int position) {
        return viewTypeList.get(position).getValue();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        RecyclerView.ViewHolder viewHolder;

        ViewType type = ViewType.GetValue(viewType);      //convert value into enum

        switch (type) {
            case SIMPLE:
                viewHolder = new SimpleView(PartialSimpleBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
                break;
            case VEHICLE:
                viewHolder = new VehicleView(PartialVehicleBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
                break;
            case VEHICLE_MAKE_MODEL:
                viewHolder = new VehicleMakeModelView(PartialVehicleMakeModelBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
                break;
            case VEHICLE_MAKE_MODEL_SEARCHABLE:
                viewHolder = new VehicleMakeModelSearchableView(PartialVehicleMakeModelSearchableBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
                break;
            case KM_FIRST:
                viewHolder = new KmFirstView(PartialKmFirstBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
                break;
            case KM_SECOND:
                viewHolder = new KmSecondView(PartialKmSecondBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
                break;
            case FUEL_FIRST:
                viewHolder = new FuelFirstView(PartialFuelFirstBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
                break;
            case FUEL_SECOND:
                viewHolder = new FuelSecondView(PartialFuelSecondBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
                break;
            case CHARGING_FIRST:
                viewHolder = new ChargingFirstView(PartialChargingFirstBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
                break;
            case CHARGING_SECOND:
                viewHolder = new ChargingSecondView(PartialChargingSecondBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
                break;
            case CUSTOMER:
                viewHolder = new CustomerView(PartialCustomerBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
                break;
            case DRIVER:
                viewHolder = new DriverView(PartialDriverBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
                break;
            case WORKSHOP:
                viewHolder = new WorkshopView(PartialWorkshopBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
                break;
            case BRANCH:
                viewHolder = new BranchView(PartialBranchBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
                break;
            default:
                viewHolder = new SimpleView(PartialSimpleBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewType type = ViewType.GetValue(holder.getItemViewType());

        switch (type) {
            case SIMPLE:
                ((SimpleView) holder).fillData(parcelable);
                break;
            case VEHICLE:
                ((VehicleView) holder).fillData(parcelable);
                break;
            case VEHICLE_MAKE_MODEL:
                ((VehicleMakeModelView) holder).fillData(parcelable);
                break;
            case VEHICLE_MAKE_MODEL_SEARCHABLE:
                ((VehicleMakeModelSearchableView) holder).fillData(parcelable);
                break;
            case KM_FIRST:
                ((KmFirstView) holder).fillData(parcelable);
                break;
            case KM_SECOND:
                ((KmSecondView) holder).fillData(parcelable);
                break;
            case FUEL_FIRST:
                ((FuelFirstView) holder).fillData(parcelable);
                break;
            case FUEL_SECOND:
                ((FuelSecondView) holder).fillData(parcelable);
                break;
            case CHARGING_FIRST:
                ((ChargingFirstView) holder).fillData(parcelable);
                break;
            case CHARGING_SECOND:
                ((ChargingSecondView) holder).fillData(parcelable);
                break;
            case CUSTOMER:
                ((CustomerView) holder).fillData(parcelable);
                break;
            case DRIVER:
                ((DriverView) holder).fillData(parcelable);
                break;
            case WORKSHOP:
                ((WorkshopView) holder).fillData(parcelable);
                break;
            case BRANCH:
                ((BranchView) holder).fillData(parcelable);
                break;
            default:
                ((SimpleView) holder).fillData(parcelable);
        }
    }

    @Override
    public int getItemCount() {
        if (viewTypeList == null)
            return 0;
        return viewTypeList.size();
    }
}
