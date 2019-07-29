package com.mobiletraderv.paul.daggertraining.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class persistUsers {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public int user_id;
    public int rep_id;
    public String edcode;
    public String fullname;

    public persistUsers(int user_id, int rep_id, String edcode, String fullname) {
        this.user_id = user_id;
        this.rep_id = rep_id;
        this.edcode = edcode;
        this.fullname = fullname;
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getEdcode() {
        return edcode;
    }

    public String getFullname() {
        return fullname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRep_id() {
        return rep_id;
    }
}
