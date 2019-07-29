package com.mobiletraderv.paul.daggertraining.ui.quest;


import android.util.Log;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;
import com.mobiletraderv.paul.daggertraining.model.Users;
import com.mobiletraderv.paul.daggertraining.network.quest.QuestApi;
import javax.inject.Inject;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class QuestViewModel extends ViewModel {

    private static final String TAG = "QuestViewModel";

    private QuestApi questApi;

    public MediatorLiveData<String> reponse = new MediatorLiveData<>();

    @Inject
    public QuestViewModel(QuestApi questApi) {
        this.questApi = questApi;
    }

    public MediatorLiveData<String> observeresponse(){
        return reponse;
    }

    public void observersCustomers(int outletid,int repid,int userid,String q1, String q2, String q3, String q4, String q5,
                                   String q6, String q7, String q8,
                                   String q9, String q9a, String q10, String q10a,
                                   String q11, String q11a   ){
        questApi.getUser(outletid,repid,userid,q1,q2,q3,q4,q5,q6,q7,q8,
                q9,q9a,q10,q10a,q11,q11a)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Response<Users>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(Response<Users> response) {

                        Users data = response.body();
                        if(data != null && response.isSuccessful() && response.body() != null && response.code() == 200 && data.status==200){
                            reponse.postValue("200");
                        }else{
                            reponse.postValue("400");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }


}
