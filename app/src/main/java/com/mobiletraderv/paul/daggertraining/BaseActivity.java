package com.mobiletraderv.paul.daggertraining;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;


import androidx.constraintlayout.widget.ConstraintLayout;

import dagger.android.support.DaggerAppCompatActivity;

public class BaseActivity extends DaggerAppCompatActivity {
    private static final String TAG = "DaggerExample";

    public ProgressBar mProgressBar;

    @Override
    public void setContentView(int layoutResID) {

        ConstraintLayout constraintLayout = (ConstraintLayout) getLayoutInflater().inflate(R.layout.actitvity_base, null);
        FrameLayout frameLayout = constraintLayout.findViewById(R.id.activity_contents);
        mProgressBar = constraintLayout.findViewById(R.id.base_progress_bar);
        getLayoutInflater().inflate(layoutResID, frameLayout, true);
        super.setContentView(constraintLayout);
    }

    public void showProgressBar(boolean visible) {
        mProgressBar.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
    }

   // Competition

}
