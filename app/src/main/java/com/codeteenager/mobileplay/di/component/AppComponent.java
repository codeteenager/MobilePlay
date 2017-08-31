package com.codeteenager.mobileplay.di.component;

import com.codeteenager.mobileplay.data.http.ApiService;
import com.codeteenager.mobileplay.di.module.AppModule;
import com.codeteenager.mobileplay.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by codeteenager on 2017/8/31.
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {
    public ApiService getApiService();
}
