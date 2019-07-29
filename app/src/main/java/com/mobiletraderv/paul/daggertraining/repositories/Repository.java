package com.mobiletraderv.paul.daggertraining.repositories;

import androidx.lifecycle.LiveData;

import com.mobiletraderv.paul.daggertraining.model.persistUsers;
import com.mobiletraderv.paul.daggertraining.persistence.PostDao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Repository {

    private static final String TAG = "Repository";

    private final PostDao postDao;

    @Inject
    public Repository(PostDao postDao) {
        this.postDao = postDao;
    }

    public Long addRepList(persistUsers employees) {
        return this.postDao.addSalesRep(employees);
    }

    public LiveData<List<persistUsers>> repList() {
        return this.postDao.repList();
    }

    public void deleteFrompersistUsers() {
        this.postDao.deleteFrompersistUsers();
    }
}
