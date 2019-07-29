package com.mobiletraderv.paul.daggertraining.ui.main;



import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.mobiletraderv.paul.daggertraining.model.persistUsers;
import com.mobiletraderv.paul.daggertraining.repositories.Repository;

import java.util.List;

import javax.inject.Inject;


public class MainViewModel extends ViewModel {

    private static final String TAG = "PostsViewModel";

    private Repository repository;

    @Inject
    public MainViewModel(Repository repository) {
        this.repository = repository;
    }

    public LiveData<List<persistUsers>> observeresponse(){
        return repository.repList();
    }

}
