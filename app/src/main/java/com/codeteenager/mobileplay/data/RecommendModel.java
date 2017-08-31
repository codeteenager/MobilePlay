package com.codeteenager.mobileplay.data;

import com.codeteenager.mobileplay.bean.AppInfo;
import com.codeteenager.mobileplay.bean.PageBean;
import com.codeteenager.mobileplay.data.http.ApiService;

import retrofit2.Callback;

/**
 * Created by wangrui on 2017/8/31.
 */

public class RecommendModel {
    private ApiService mApiService;

    public RecommendModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    public void getApps(Callback<PageBean<AppInfo>> callback) {
        mApiService.getApps("{'page':0}").enqueue(callback);
    }
}
