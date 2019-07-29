package com.mobiletraderv.paul.daggertraining.ui.mainoutlet;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.mobiletraderv.paul.daggertraining.BaseActivity;
import com.mobiletraderv.paul.daggertraining.R;
import com.mobiletraderv.paul.daggertraining.model.OutletsLists;
import com.mobiletraderv.paul.daggertraining.viewmodels.ViewModelProviderFactory;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainOutletActivity extends BaseActivity {

    private static final String TAG = "MainOutletActivity";

    @Inject
    ViewModelProviderFactory providerFactory;

    private MainOutletViewModel viewModel;

    MainOutletAdapter mainAdapter;

    @BindView(R.id.reps_list)
    RecyclerView recyclerView;

    Bundle bundle;

    int repid;

    int userid;

    @BindView(R.id.back_page)
    ImageView back_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_outlet);
        ButterKnife.bind(this);
        bundle = getIntent().getExtras();
        viewModel = ViewModelProviders.of(this, providerFactory).get(MainOutletViewModel.class);

        if (bundle != null) {
            repid = bundle.getInt("REPID");
            userid = bundle.getInt("USERID");
        }

        back_page.setOnClickListener(view -> {
            onBackPressed();
        });

        viewModel.observersCustomers(userid, repid);
        initRecyclerView();
        subscribeObervers();
    }

    public void subscribeObervers() {
        viewModel.observeresponse().observe(this, new Observer<List<OutletsLists>>() {
            @Override
            public void onChanged(List<OutletsLists> outletsLists) {
                showProgressBar(false);
                mainAdapter.setCustList(outletsLists);
            }
        });
    }



    public void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        mainAdapter = new MainOutletAdapter(this);
        recyclerView.setAdapter(mainAdapter);
    }

}
