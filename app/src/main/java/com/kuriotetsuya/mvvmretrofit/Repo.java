package com.kuriotetsuya.mvvmretrofit;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

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
    private APIService apiService;
    OkHttpClient client;
    HttpLoggingInterceptor interceptor;
    List<PostResponse> responseList;
    LiveData<List<PostResponse>> responseLiveData;

    public Repo() {
        interceptor = new HttpLoggingInterceptor();
        client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(APIService.class);
    }

    public List<PostResponse> getPosts() {
        apiService.getPosts().enqueue(new Callback<List<PostResponse>>() {
            @Override
            public void onResponse(Call<List<PostResponse>> call, Response<List<PostResponse>> response) {
                responseList = response.body();
                Log.i("RESPOSE SIZE", "" + responseList.size());
            }

            @Override
            public void onFailure(Call<List<PostResponse>> call, Throwable t) {
            }
        });
        return responseList;
    }


}
