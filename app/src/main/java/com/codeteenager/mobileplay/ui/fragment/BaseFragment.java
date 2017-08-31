package com.codeteenager.mobileplay.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codeteenager.mobileplay.PlayApplication;
import com.codeteenager.mobileplay.di.component.AppComponent;
import com.codeteenager.mobileplay.presenter.BasePresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by codeteenager on 2017/9/1.
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment {
    private Unbinder mUnbinder;
    private PlayApplication mPlayApplication;
    private View mRootView;
    @Inject
    T mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(setLayout(), container, false);
        mUnbinder = ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.mPlayApplication = (PlayApplication) getActivity().getApplication();
        setUpActivityComponent(mPlayApplication.getAppComponent());
        init();
    }

    //设置布局文件id
    public abstract int setLayout();

    //初始化
    public abstract void init();

    public abstract void setUpActivityComponent(AppComponent appComponent);

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder != Unbinder.EMPTY) {
            mUnbinder.unbind();
        }
    }
}
