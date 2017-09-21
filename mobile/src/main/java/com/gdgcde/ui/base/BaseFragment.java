package com.gdgcde.ui.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.WindowManager;

import com.gdgcde.R;

import java.lang.reflect.Method;

/**
 * @author rorogarcete
 * @version 0.0.1
 * Class Base to Fragment
 * Copyright 2017 GDG Ciudad del Este
 */
public class BaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void startActivity(Intent intent, final BaseActivity.ActivityAnimation animation) {
        startActivity(intent);
        putAnimation(getActivity(), animation);
    }

    public void startActivityForResult(Intent intent, int requestCode, final BaseActivity.ActivityAnimation animation) {
        startActivityForResult(intent, requestCode);
        putAnimation(getActivity(), animation);
    }

    private static void putAnimation(final Activity source, final BaseActivity.ActivityAnimation animation) {
        try {
            Method method = Activity.class.getMethod("overridePendingTransition", int.class, int.class);

            int[] animations = getAnimation(animation);
            method.invoke(source, animations[0], animations[1]);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private static int[] getAnimation(final BaseActivity.ActivityAnimation animation) {

        int exitAnim;
        int enterAnim;

        switch (animation) {
            case SLIDE_RIGHT:
                enterAnim = R.anim.slide_right_enter;
                exitAnim = R.anim.slide_right_exit;
                break;

            case SLIDE_LEFT:
            default:
                enterAnim = R.anim.slide_left_enter;
                exitAnim = R.anim.slide_left_exit;
                break;
        }

        return new int[]{enterAnim, exitAnim};
    }
}