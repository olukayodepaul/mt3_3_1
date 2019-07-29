package com.mobiletraderv.paul.daggertraining.network.mainoutlet;

import com.mobiletraderv.paul.daggertraining.model.Users;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MainOutletApi {

    @POST("/mobiletrader/adhoccust")
    Single<Response<Users>> getAllRepsCustomers(
            @Query("userid") int userid,
            @Query("repid") int repid
    );

}
