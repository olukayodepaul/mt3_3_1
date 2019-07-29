package com.mobiletraderv.paul.daggertraining.ui.auth;


import android.os.AsyncTask;
import android.util.Log;

import javax.inject.Inject;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;
import com.mobiletraderv.paul.daggertraining.model.Users;
import com.mobiletraderv.paul.daggertraining.model.persistUsers;
import com.mobiletraderv.paul.daggertraining.network.auth.AuthApi;
import com.mobiletraderv.paul.daggertraining.repositories.Repository;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;


public class AuthViewModel extends ViewModel {

    private static final String TAG = "AuthViewModel";

    private AuthApi authApi;

    private  Repository repository;

    private MediatorLiveData<String> mediatorResponse = new MediatorLiveData<>();

    CompositeDisposable disposable = new CompositeDisposable();

    @Inject
    public AuthViewModel(AuthApi authApi, Repository repository) {
        this.authApi = authApi;
        this.repository = repository;
    }

    public MediatorLiveData<String> getMediatorResponse() {
        return mediatorResponse;
    }


    public void authenticateWithUserCredential(String usernames, String password) {

        authApi.getUser(usernames,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Response<Users>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onSuccess(Response<Users> response) {
                        Users data = response.body();
                        if(data != null && response.isSuccessful() && response.body() != null && response.code() == 200 && data.status==200){
                            deleteFrompersistUsers();
                            for(int i = 0 ; i < data.replist.size(); i++){

                                persistUsers modulesdata = new persistUsers(
                                        data.userid,
                                        data.replist.get(i).id,
                                        data.replist.get(i).edcode,
                                        data.replist.get(i).fullname
                                );

                                new AddReps().execute(modulesdata);

                                if(i==data.replist.size()-1){
                                    Log.d(TAG, "onerrors: check");
                                    mediatorResponse.postValue("200~");
                                }
                            }
                        }else{
                            mediatorResponse.postValue("400~"+data.msg);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mediatorResponse.postValue("400~network error");
                    }
                });
    }

   private class AddReps extends AsyncTask<persistUsers, Void, Void> {
        @Override
        protected Void doInBackground(persistUsers... item) {
            repository.addRepList(item[0]);
            return null;
        }
    }

    private void deleteFrompersistUsers() {
        Completable.fromAction(() -> repository.deleteFrompersistUsers())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }
                });
    }


}
