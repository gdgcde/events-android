package com.gdgcde.di.components;

import com.gdgcde.JoinEventApplication;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author rorogarcete
 * @version 0.0.1
 * Copyright 2017 GDG Ciudad del Este
 */
@Singleton
@Component(
        modules = {
            JoinEventApplication.class,
        })
public interface ApplicationComponent {
    void inject(JoinEventApplication telebingoApplication);
}
