package com.kuriotetsuya.mvvmretrofit.network;

import com.kuriotetsuya.mvvmretrofit.response.PostResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("/posts")
    Call<List<PostResponse>> getPosts();
}
