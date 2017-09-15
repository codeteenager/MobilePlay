package com.codeteenager.mobileplay.presenter;

import com.codeteenager.mobileplay.bean.AppInfo;
import com.codeteenager.mobileplay.bean.PageBean;
import com.codeteenager.mobileplay.common.rx.RxHttpResponseCompat;
import com.codeteenager.mobileplay.data.RecommendModel;
import com.codeteenager.mobileplay.presenter.contract.RecommendContract;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by wangrui on 2017/8/31.
 */

public class RecommendPresenter extends BasePresenter<RecommendModel, RecommendContract.View> {

    @Inject
    public RecommendPresenter(RecommendModel model, RecommendContract.View view) {
        super(model, view);
    }

    public void requestDatas() {
        mModel.getApps()
                .compose(RxHttpResponseCompat.<PageBean<AppInfo>>compatResult())
                .subscribe(new Subscriber<PageBean<AppInfo>>() {
                    @Override
                    public void onStart() {
                        super.onStart();
                        mView.showLoadding();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideLoadding();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.hideLoadding();
                    }

                    @Override
                    public void onNext(PageBean<AppInfo> response) {
                        if (response != null) {
                            mView.showResult(response.getDatas());
                        } else {
                            mView.showNoData();
                        }
                    }
                });

    }
}
