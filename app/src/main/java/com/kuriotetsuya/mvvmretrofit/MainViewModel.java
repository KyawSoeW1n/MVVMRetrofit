package com.kuriotetsuya.mvvmretrofit;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.util.Log;

import java.util.List;


public class MainViewModel extends ViewModel {
    Repo repo;
    MutableLiveData<List<PostResponse>> posts = new MutableLiveData<>();

    public MainViewModel() {
        repo = new Repo(this);
        repo.getPosts();
    }


}
