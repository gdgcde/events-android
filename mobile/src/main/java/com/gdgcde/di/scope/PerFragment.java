package com.gdgcde.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author rorogarcete
 * @version 0.0.1
 * Copyright 2017 GDG Ciudad del Este
 */
@Scope @Retention(RetentionPolicy.RUNTIME)
public @interface PerFragment { }
