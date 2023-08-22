package com.speedautosystems.vmi.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.speedautosystems.vmi.R;
import com.speedautosystems.vmi.fragments.BaseFragment;
import com.speedautosystems.vmi.fragments.HomeFragment;


public class FragmentMainActivity extends AppCompatActivity {


    Handler mHandler;


    BaseFragment currentFragment;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragetment_main);
        context = this;


        mHandler = new Handler(Looper.getMainLooper());


        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.mainContent, new HomeFragment(), "HomeFrgament");
        ft.commit();
    }


    @Override
    public void onBackPressed() {

        int stackCount = getSupportFragmentManager().getBackStackEntryCount();
        if (BaseFragment.currentScreenTypeIndex > -1)
            BaseFragment.currentScreenTypeIndex--;

        if (currentFragment != null) {
            if (!currentFragment.onBackPressed())
                super.onBackPressed();
        } else
            super.onBackPressed();


    }

    public void addFragment(Fragment fragment, String tag, boolean drawerToggle) {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.mainContent, fragment, tag);
        ft.addToBackStack("New_State")
                .commit();
    }

    public void popAllAddedFragment() {
        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportFragmentManager().popBackStackImmediate("New_State", FragmentManager.POP_BACK_STACK_INCLUSIVE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void popFragment() {
        try {
            getSupportFragmentManager().popBackStack();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
