package com.kuriotetsuya.mvvmretrofit.presentation;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.kuriotetsuya.mvvmretrofit.response.PostResponse;
import com.kuriotetsuya.mvvmretrofit.repo.Repo;

import java.util.List;


public class MainViewModel extends ViewModel {
    Repo repo;
    public MutableLiveData<List<PostResponse>> posts = new MutableLiveData<>();

    public MainViewModel() {
        repo = new Repo(this);
        repo.getPosts();
    }


}
