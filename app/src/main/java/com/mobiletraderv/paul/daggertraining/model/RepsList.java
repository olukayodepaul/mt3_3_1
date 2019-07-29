package com.mobiletraderv.paul.daggertraining.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RepsList {

    @SerializedName("id")
    @Expose
    public int id;

    @SerializedName("edcode")
    @Expose
    public String edcode;

    @SerializedName("fullname")
    @Expose
    public String fullname;

}
