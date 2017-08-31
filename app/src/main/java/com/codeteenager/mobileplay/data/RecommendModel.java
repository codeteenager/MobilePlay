package com.codeteenager.mobileplay.data;

import com.codeteenager.mobileplay.bean.AppInfo;
import com.codeteenager.mobileplay.bean.PageBean;
import com.codeteenager.mobileplay.http.ApiService;
import com.codeteenager.mobileplay.http.HttpManager;

import retrofit2.Callback;

/**
 * Created by wangrui on 2017/8/31.
 */

public class RecommendModel {
    public void getApps(Callback<PageBean<AppInfo>> callback) {
        HttpManager httpManager = new HttpManager();
        ApiService apiService = httpManager.getRetrofit(httpManager.getOkHttpClient()).create(ApiService.class);
        apiService.getApps("{'page':0}").enqueue(callback);
    }
}
