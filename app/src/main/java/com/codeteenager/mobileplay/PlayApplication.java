package com.codeteenager.mobileplay;

import android.app.Application;
import android.content.Context;

import com.codeteenager.mobileplay.di.component.AppComponent;
import com.codeteenager.mobileplay.di.component.DaggerAppComponent;
import com.codeteenager.mobileplay.di.module.AppModule;
import com.codeteenager.mobileplay.di.module.HttpModule;

/**
 * Created by codeteenager on 2017/8/31.
 */

public class PlayApplication extends Application {
    private AppComponent mAppComponent;

    public static Application get(Context context) {
        return (Application) context.getApplicationContext();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).httpModule(new HttpModule()).build();
    }
}
