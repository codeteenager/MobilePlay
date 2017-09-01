package com.codeteenager.mobileplay.data;

import com.codeteenager.mobileplay.bean.AppInfo;
import com.codeteenager.mobileplay.bean.PageBean;
import com.codeteenager.mobileplay.data.http.ApiService;

import rx.Observable;


/**
 * Created by wangrui on 2017/8/31.
 */

public class RecommendModel {
    private ApiService mApiService;

    public RecommendModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    public Observable<PageBean<AppInfo>> getApps() {
        return mApiService.getApps("{'page':0}");
    }
}
