package com.codeteenager.mobileplay.presenter;

import com.codeteenager.mobileplay.ui.BaseView;

/**
 * Created by wangrui on 2017/8/31.
 */

public class BasePresenter<M, V extends BaseView> {
    protected M mModel;
    protected V mView;

    public BasePresenter(M m, V v) {
        this.mModel = m;
        this.mView = v;
    }
}
