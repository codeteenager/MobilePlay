package com.codeteenager.mobileplay.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;

import com.codeteenager.mobileplay.PlayApplication;
import com.codeteenager.mobileplay.di.component.AppComponent;
import com.codeteenager.mobileplay.presenter.BasePresenter;
import com.mikepenz.iconics.context.IconicsLayoutInflater;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by codeteenager on 2017/9/1.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    private Unbinder unbinder;
    private PlayApplication mPlayApplication;
    @Inject
    T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        LayoutInflaterCompat.setFactory(getLayoutInflater(), new IconicsLayoutInflater(getDelegate()));
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        unbinder = ButterKnife.bind(this);
        this.mPlayApplication = (PlayApplication) getApplication();
        setUpActivityComponent(mPlayApplication.getAppComponent());
        init();
    }

    //设置布局文件id
    public abstract int setLayout();

    //初始化
    public abstract void init();

    public abstract void setUpActivityComponent(AppComponent appComponent);

    protected void startActivity(Class c) {
        this.startActivity(new Intent(this, c));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != Unbinder.EMPTY) {
            unbinder.unbind();
        }
    }
}
