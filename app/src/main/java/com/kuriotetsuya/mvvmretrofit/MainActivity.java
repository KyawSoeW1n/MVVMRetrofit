package com.kuriotetsuya.mvvmretrofit;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    MainViewModel mainViewModel;
    RecyclerAdapter recyclerAdapter;
    RecyclerView rc;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerAdapter = new RecyclerAdapter();
        rc = findViewById(R.id.rc);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rc.setLayoutManager(layoutManager);
        rc.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rc.setAdapter(recyclerAdapter);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getPosts();
        mainViewModel.posts.observe(this, new Observer<List<PostResponse>>() {
            @Override
            public void onChanged(@Nullable List<PostResponse> postResponses) {
                if (postResponses == null) {
                    Log.i("NULL", "NULL");
                } else if (postResponses != null) {
                    recyclerAdapter.setData(postResponses);
                }
            }
        });


    }
}
