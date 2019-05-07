package com.kuriotetsuya.mvvmretrofit;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.List;

public class MainViewModel extends ViewModel {
    Repo repo;
    public MutableLiveData<List<PostResponse>> posts = new MutableLiveData<>();

    public MainViewModel() {
        repo = new Repo();
    }

    public void getPosts() {
        posts.postValue(repo.getPosts());
    }
}
