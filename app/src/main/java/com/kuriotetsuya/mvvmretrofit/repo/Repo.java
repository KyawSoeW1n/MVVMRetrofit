package com.kuriotetsuya.mvvmretrofit.repo;

import com.kuriotetsuya.mvvmretrofit.presentation.MainViewModel;
import com.kuriotetsuya.mvvmretrofit.response.PostResponse;
import com.kuriotetsuya.mvvmretrofit.network.APIService;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repo {
    private Retrofit retrofit;
    MainViewModel mainViewModel;
    private APIService apiService;
    OkHttpClient client;
    HttpLoggingInterceptor interceptor;
    List<PostResponse> responseList;

    public Repo(MainViewModel mainViewModel) {
        this.mainViewModel=mainViewModel;
        interceptor = new HttpLoggingInterceptor();
        client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(APIService.class);


    }

    public void getPosts() {
        apiService.getPosts().enqueue(new Callback<List<PostResponse>>() {
            @Override
            public void onResponse(Call<List<PostResponse>> call, Response<List<PostResponse>> response) {
                responseList = response.body();
                mainViewModel.posts.postValue(responseList);
            }

            @Override
            public void onFailure(Call<List<PostResponse>> call, Throwable t) {
            }
        });
    }
}
