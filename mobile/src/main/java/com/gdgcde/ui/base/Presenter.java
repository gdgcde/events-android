package com.gdgcde.ui.base;

/**
 * @author rorogarcete
 * @version 0.0.1
 * Interface representing a Presenter in a model view presenter (MVP) pattern.
 * Copyright 2017 GDG Ciudad del Este
 */
public interface Presenter<View> {
    void attachView(View t);
    void detachView();
}
