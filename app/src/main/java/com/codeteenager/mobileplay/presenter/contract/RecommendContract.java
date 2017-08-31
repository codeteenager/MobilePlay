package com.codeteenager.mobileplay.presenter.contract;

import com.codeteenager.mobileplay.bean.AppInfo;
import com.codeteenager.mobileplay.presenter.BasePresenter;
import com.codeteenager.mobileplay.ui.BaseView;

import java.util.List;

/**
 * Created by wangrui on 2017/8/31.
 */

public interface RecommendContract {
    interface View extends BaseView {

        void showNoData();

        void showError(String msg);

        void showResult(List<AppInfo> datas);
    }
}
