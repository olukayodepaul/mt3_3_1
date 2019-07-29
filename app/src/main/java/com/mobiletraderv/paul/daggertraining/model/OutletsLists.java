package com.mobiletraderv.paul.daggertraining.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OutletsLists {

    @SerializedName("outletid")
    @Expose
    public int outletid;

    @SerializedName("urno")
    @Expose
    public String urno;

    @SerializedName("outletn")
    @Expose
    public String outletn;

    @SerializedName("outletadd")
    @Expose
    public String outletadd;

    @SerializedName("contn")
    @Expose
    public String contn;

    @SerializedName("contp")
    @Expose
    public String contp;

    @SerializedName("userid")
    @Expose
    public int userid;

    @SerializedName("repid")
    @Expose
    public int repid;

}
