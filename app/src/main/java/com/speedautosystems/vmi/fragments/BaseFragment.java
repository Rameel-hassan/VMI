package com.speedautosystems.vmi.fragments;

/**
 * @author Rameel Hassan
 * Created 03/08/2023 at 10:26 am
 */

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.speedautosystems.vmi.R;
import com.speedautosystems.vmi.activity.FragmentMainActivity;
import com.speedautosystems.vmi.configuration.Step;
import com.speedautosystems.vmi.enums.ScreenType;

import java.util.ArrayList;


public class BaseFragment extends Fragment {
    public static int currentScreenTypeIndex = -1;
    static ArrayList<ScreenType> screenListToGo;
    static Step step;
    protected long mLastClickTime = 0;
    Handler mHandler;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mHandler = new Handler(Looper.getMainLooper());
    }

    protected ActionBar getActionBar() {
        return ((AppCompatActivity) getActivity()).getSupportActionBar();
    }

    protected void replaceFragment(Fragment fragment, String tag) {
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.mainContent, fragment, tag);
        ft.commit();
    }

    protected void addFragment(Fragment fragment, String tag) {
        ((FragmentMainActivity) getActivity()).addFragment(fragment, tag, false);

    }

    protected void popFragment() {
        ((FragmentMainActivity) getActivity()).popFragment();
    }

    protected void popAllFragment() {
        ((FragmentMainActivity) getActivity()).popAllAddedFragment();
    }


    public void onNextClicked() {
        if (currentScreenTypeIndex >= screenListToGo.size() - 1) {
            Toast.makeText(getActivity(), "last fragment", Toast.LENGTH_SHORT).show();
            return;
        }
        currentScreenTypeIndex++;

        ScreenType screen = screenListToGo.get(currentScreenTypeIndex);
        switch (screen) {
            case MOVEMENT:
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        BaseFragment fragment = new MovementFragment();
                        addFragment(fragment, "" + fragment.getClass().getName());
                    }
                }, 350);
                break;

            case CHECKLIST:
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        BaseFragment fragment = new CheckListFragment();
                        addFragment(fragment, "" + fragment.getClass().getName());
                    }
                }, 350);
                break;
            case MARK_EXTERIOR:
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        BaseFragment fragment = new MarkExteriorFragment();
                        addFragment(fragment, "" + fragment.getClass().getName());
                    }
                }, 350);
                break;
            case MARK_INTERIOR:
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        BaseFragment fragment = new MarkInteriorFragment();
                        addFragment(fragment, "" + fragment.getClass().getName());
                    }
                }, 350);
                break;
            case SIGNTAURE:
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        BaseFragment fragment = new SignatureFragment();
                        addFragment(fragment, "" + fragment.getClass().getName());
                    }
                }, 350);
                break;
            case REPORTS:
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        BaseFragment fragment = new ReportsFragment();
                        addFragment(fragment, "" + fragment.getClass().getName());
                    }
                }, 350);
                break;
            default:
                Toast.makeText(getActivity(), "invalid option", Toast.LENGTH_SHORT).show();

        }
    }

    public boolean onBackPressed() {
        return false;
    }

}
