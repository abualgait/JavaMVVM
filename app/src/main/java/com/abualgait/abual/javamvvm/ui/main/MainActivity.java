package com.abualgait.abual.javamvvm.ui.main;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.abualgait.abual.javamvvm.R;
import com.abualgait.abual.javamvvm.ViewModelProviderFactory;
import com.abualgait.abual.javamvvm.adapters.MovieAdapter;
import com.abualgait.abual.javamvvm.ui.base.BaseActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<MainViewModel> implements MainNavigator {

    private MainViewModel mMainViewModel;
    @Inject
    ViewModelProviderFactory factory;

    RecyclerView recyclerView;
    MovieAdapter adapter;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        mMainViewModel.setNavigator(this);
        mMainViewModel.loadMovies();
        subscribeToLiveData();
    }

    private void subscribeToLiveData() {
        mMainViewModel.getMovies().observe(this, questionCardDatas -> mMainViewModel.setMoviesList(questionCardDatas));

    }

    private void initViews() {
        recyclerView = findViewById(R.id.main_recycler);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel getViewModel() {
        mMainViewModel = ViewModelProviders.of(this, factory).get(MainViewModel.class);
        return mMainViewModel;
    }

    @Override
    public void handleError(Throwable throwable) {

    }

    @Override
    public void showMovies() {
        Toast.makeText(this, mMainViewModel.getMovieDataList().get(0).movie_title, Toast.LENGTH_SHORT).show();
        //set recycler view
        adapter = new MovieAdapter(this, mMainViewModel.getMovieDataList());
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        // adapter.notifyDataSetChanged();
        adapter.addtomovies(mMainViewModel.getMovieDataList());
    }
}
