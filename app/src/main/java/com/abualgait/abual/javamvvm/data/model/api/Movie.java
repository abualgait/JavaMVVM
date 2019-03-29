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

package com.abualgait.abual.javamvvm.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by amitshekhar on 08/07/17.
 */

public class Movie {

    @Expose
    @SerializedName("id")
    public int movie_id;

    @Expose
    @SerializedName("name")
    public String movie_title;


    @Expose
    @SerializedName("disc")
    public String movie_disc;


    @Expose
    @SerializedName("image")
    public String movie_image;


    @Expose
    @SerializedName("rate")
    public String movie_rate;



}
