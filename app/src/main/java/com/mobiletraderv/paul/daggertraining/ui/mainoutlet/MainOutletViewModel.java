package com.mobiletraderv.paul.daggertraining.ui.mainoutlet;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.mobiletraderv.paul.daggertraining.model.OutletsLists;
import com.mobiletraderv.paul.daggertraining.model.Users;
import com.mobiletraderv.paul.daggertraining.network.mainoutlet.MainOutletApi;
import com.mobiletraderv.paul.daggertraining.repositories.Repository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class MainOutletViewModel extends ViewModel {

    private MainOutletApi mainOutletApi;

    CompositeDisposable disposable = new CompositeDisposable();

    public MediatorLiveData<List<OutletsLists>> ouletliest = new MediatorLiveData<>();

    public MediatorLiveData<List<OutletsLists>> observeresponse(){
        return ouletliest;
    }

    @Inject
    public MainOutletViewModel(MainOutletApi mainOutletApi, Repository repository) {
        this.mainOutletApi = mainOutletApi;
    }

    public void observersCustomers(int userid, int repid){

        mainOutletApi.getAllRepsCustomers(userid,repid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Response<Users>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onSuccess(Response<Users> response) {
                        ouletliest.postValue(response.body().custlist);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

    }



}
