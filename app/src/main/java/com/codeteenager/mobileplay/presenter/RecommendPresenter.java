package com.codeteenager.mobileplay.presenter;

import com.codeteenager.mobileplay.bean.AppInfo;
import com.codeteenager.mobileplay.bean.PageBean;
import com.codeteenager.mobileplay.data.RecommendModel;
import com.codeteenager.mobileplay.presenter.contract.RecommendContract;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by wangrui on 2017/8/31.
 */

public class RecommendPresenter extends BasePresenter<RecommendModel, RecommendContract.View> {

    @Inject
    public RecommendPresenter(RecommendModel model, RecommendContract.View view) {
        super(model, view);
    }

    public void requestDatas() {
        mView.showLoadding();
        mModel.getApps(new Callback<PageBean<AppInfo>>() {
            @Override
            public void onResponse(Call<PageBean<AppInfo>> call, Response<PageBean<AppInfo>> response) {
                if (response != null) {
                    mView.showResult(response.body().getDatas());
                } else {
                    mView.showNoData();
                }
                mView.hideLoadding();
            }

            @Override
            public void onFailure(Call<PageBean<AppInfo>> call, Throwable t) {
                mView.hideLoadding();
                mView.showError(t.getMessage());
            }
        });
    }
}
