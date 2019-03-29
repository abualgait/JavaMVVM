/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.abualgait.abual.javamvvm.ui.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.abualgait.abual.javamvvm.data.DataManager;
import com.abualgait.abual.javamvvm.data.model.api.Movie;
import com.abualgait.abual.javamvvm.ui.base.BaseViewModel;
import com.abualgait.abual.javamvvm.utils.rx.SchedulerProvider;

import java.util.List;



/**
 * Created by amitshekhar on 07/07/17.
 */

public class MainViewModel extends BaseViewModel<MainNavigator> {


    private final MutableLiveData<List<Movie>> movies;
    private final List<Movie> moviesDataList = new ObservableArrayList<>();
    public MainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        movies = new MutableLiveData<>();

    }
    public List<Movie> getMovieDataList() {
        return moviesDataList;
    }
    public void setMoviesList(List<Movie> questionCardDatas) {
        moviesDataList.clear();
        moviesDataList.addAll(questionCardDatas);
        getNavigator().showMovies();
    }
    public LiveData<List<Movie>> getMovies() {
        return movies;
    }

    public void loadMovies() {
        getCompositeDisposable().add(getDataManager()
                .doServerGetMoviesApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(questionList -> {
                    if (questionList != null) {
                        movies.setValue(questionList.getList());

                    }
                }, throwable -> {

                }));
    }


}
