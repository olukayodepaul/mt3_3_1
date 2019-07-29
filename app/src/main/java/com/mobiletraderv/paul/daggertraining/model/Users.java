package com.mobiletraderv.paul.daggertraining.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Users {

    @SerializedName("status")
    @Expose
    public int status;

    @SerializedName("msg")
    @Expose
    public String msg;

    @SerializedName("userid")
    @Expose
    public int userid;

    @SerializedName("replist")
    @Expose
    public List<RepsList> replist;

    @SerializedName("custlist")
    @Expose
    public List<OutletsLists> custlist;

}
