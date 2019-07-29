package com.mobiletraderv.paul.daggertraining.network.quest;

import com.mobiletraderv.paul.daggertraining.model.Users;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface QuestApi {
    @POST("/mobiletrader/adhocreport")
    Single<Response<Users>> getUser(
            @Query("outletid") int outletid,
            @Query("repid") int repid,
            @Query("userid") int userid,
            @Query("q1") String q1,
            @Query("q2") String q2,
            @Query("q3") String q3,
            @Query("q4") String q4,
            @Query("q5") String q5,
            @Query("q6") String q6,
            @Query("q7") String q7,
            @Query("q8") String q8,
            @Query("q9") String q9,
            @Query("q9a") String q9a,
            @Query("q10") String q10,
            @Query("q10a") String q10a,
            @Query("q11") String q11,
            @Query("q11a") String q11a
    );
}
