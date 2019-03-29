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

package com.abualgait.abual.javamvvm.di.module;

import android.app.Application;
import android.content.Context;

import com.abualgait.abual.javamvvm.data.AppDataManager;
import com.abualgait.abual.javamvvm.data.DataManager;
import com.abualgait.abual.javamvvm.data.remote.ApiHeader;
import com.abualgait.abual.javamvvm.data.remote.ApiHelper;
import com.abualgait.abual.javamvvm.data.remote.AppApiHelper;
import com.abualgait.abual.javamvvm.di.ApiInfo;
import com.abualgait.abual.javamvvm.utils.AppConstants;
import com.abualgait.abual.javamvvm.utils.rx.AppSchedulerProvider;
import com.abualgait.abual.javamvvm.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by amitshekhar on 07/07/17.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }


    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return AppConstants.BASE_URL;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey) {
        return new ApiHeader.ProtectedApiHeader(apiKey);
    }
}
