package com.gdgcde.di.modules;

import android.content.Context;

import com.gdgcde.JoinEventApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import timber.log.Timber;

/**
 * @author rorogarcete
 * @version 0.0.1
 * Copyright 2017 Linco Inc. All rights reserved
 */
@Module
public class ApplicationModule {

    private JoinEventApplication application;

    public ApplicationModule(JoinEventApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return application.getBaseContext();
    }

    @Provides
    public Timber.DebugTree provideDebugTree() {
        return new Timber.DebugTree();
    }

    @Provides
    @Singleton
    public Realm provideRealm(Context context) {
        Realm.init(context);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("gdgcde.realm")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                //.initialData(new RealmInitialData())
                //.migration()
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);
        return Realm.getDefaultInstance();
    }

}