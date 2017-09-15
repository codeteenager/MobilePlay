package com.codeteenager.mobileplay.di.module;

import android.app.ProgressDialog;

import com.codeteenager.mobileplay.data.RecommendModel;
import com.codeteenager.mobileplay.data.http.ApiService;
import com.codeteenager.mobileplay.presenter.contract.RecommendContract;
import com.codeteenager.mobileplay.ui.fragment.RecommendFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by codeteenager on 2017/8/31.
 */
@Module
public class RecommendModule {
    private RecommendContract.View mView;

    public RecommendModule(RecommendContract.View view) {
        this.mView = view;
    }

    @Provides
    public RecommendContract.View provideView() {
        return mView;
    }

    @Provides
    RecommendModel provideModel(ApiService apiService) {
        return new RecommendModel(apiService);
    }

    @Provides
    public ProgressDialog provideProgressDialog(RecommendContract.View view) {
        return new ProgressDialog(((RecommendFragment) view).getActivity());
    }

}
