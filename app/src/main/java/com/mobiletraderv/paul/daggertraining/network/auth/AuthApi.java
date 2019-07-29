package com.mobiletraderv.paul.daggertraining.network.auth;

import com.mobiletraderv.paul.daggertraining.model.Users;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AuthApi {
    @POST("/mobiletrader/adhoclogin")
    Single<Response<Users>> getUser(
            @Query("username") String username,
            @Query("password") String password
    );
}
