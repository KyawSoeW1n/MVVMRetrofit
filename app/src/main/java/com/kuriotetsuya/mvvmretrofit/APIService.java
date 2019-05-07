package com.kuriotetsuya.mvvmretrofit;

import android.arch.lifecycle.LiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("/posts")
    Call<List<PostResponse>> getPosts();
}
