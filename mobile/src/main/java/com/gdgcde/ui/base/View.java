package com.gdgcde.ui.base;

/**
 * @author rorogarcete
 * @version 0.0.1
 * Interface base for view of the pattern MVP
 * Copyright 2017 GDG Ciudad del Este
 */
public interface View {
    void showProgress();
    void hideProgress();
    void onEntityError(String error);
}
