package com.gdgcde.di.scope;

/**
 * @author rorogarcete
 * @version 0.0.1
 * Copyright 2017 GDG Ciudad del Este
 */
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiUrl { }
