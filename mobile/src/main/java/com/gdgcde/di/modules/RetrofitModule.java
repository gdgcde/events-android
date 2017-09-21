package com.gdgcde.di.modules;

import com.gdgcde.BuildConfig;
import com.gdgcde.JoinEventApplication;
import com.gdgcde.data.remote.JoinEventService;
import com.gdgcde.di.scope.ApiUrl;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author rorogarcete
 * @version 0.0.1
 * Copyright 2017 GDG Ciudad del Este
 */
@Module
public class RetrofitModule {

    @ApiUrl
    @Provides
    @Singleton
    String provideApiUrl() {
        return JoinEventApplication.API_URL;
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        if (BuildConfig.DEBUG) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }

        return interceptor;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor) {
        return new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build();
    }

    @Provides
    @Singleton
    Converter.Factory provideConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(@ApiUrl String url, OkHttpClient okHttpClient, Converter.Factory converterFactory) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    JoinEventService provideApiClient(Retrofit retrofit) {
        return retrofit.create(JoinEventService.class);
    }

}
