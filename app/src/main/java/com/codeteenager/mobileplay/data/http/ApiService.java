package com.codeteenager.mobileplay.data.http;

import com.codeteenager.mobileplay.bean.AppInfo;
import com.codeteenager.mobileplay.bean.PageBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wangrui on 2017/8/31.
 */

public interface ApiService {
    public static final String BASE_URL = "http://112.124.22.238:8081/course_api/cniaoplay/";

    @GET("featured")
    public Call<PageBean<AppInfo>> getApps(@Query("p") String jsonParam);
}
