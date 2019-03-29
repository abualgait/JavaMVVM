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

package com.abualgait.abual.javamvvm.data.remote;

import com.abualgait.abual.javamvvm.data.model.api.MoviesResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by amitshekhar on 07/07/17.
 */

public interface ApiHelper {
    @GET("5c839bd15fe21458779b6e9f")
    Observable<MoviesResponse> doServerGetMoviesApiCall();


}
