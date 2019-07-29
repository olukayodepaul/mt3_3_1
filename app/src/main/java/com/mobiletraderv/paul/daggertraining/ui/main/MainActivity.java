package com.mobiletraderv.paul.daggertraining.ui.main;


import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.mobiletraderv.paul.daggertraining.BaseActivity;
import com.mobiletraderv.paul.daggertraining.R;
import com.mobiletraderv.paul.daggertraining.model.persistUsers;
import com.mobiletraderv.paul.daggertraining.viewmodels.ViewModelProviderFactory;


import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    private MainViewModel viewModel;

    @Inject
    ViewModelProviderFactory providerFactory;

    MainAdapter mainAdapter;

    @BindView(R.id.reps_list)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        viewModel = ViewModelProviders.of(this, providerFactory).get(MainViewModel.class);
        initRecyclerView();
        subscribeObervers();

    }

    public void subscribeObervers() {
        viewModel.observeresponse().observe(this, new Observer<List<persistUsers>>() {
            @Override
            public void onChanged(List<persistUsers> persistUsers) {
                showProgressBar(false);
                mainAdapter.setRepList(persistUsers);
                Log.d(TAG, "onBindViewHolder: this is inding");
            }
        });
    }

    public void initRecyclerView()
    {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        mainAdapter = new MainAdapter(this);
        recyclerView.setAdapter(mainAdapter);
    }

}
