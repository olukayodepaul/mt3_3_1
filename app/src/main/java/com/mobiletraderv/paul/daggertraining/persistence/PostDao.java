package com.mobiletraderv.paul.daggertraining.persistence;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.mobiletraderv.paul.daggertraining.model.persistUsers;

import java.util.List;

@Dao
public interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long addSalesRep(persistUsers employees);

    @Query("SELECT * FROM persistUsers")
    LiveData<List<persistUsers>> repList();

    @Query("Delete from persistUsers")
    void deleteFrompersistUsers();

}
