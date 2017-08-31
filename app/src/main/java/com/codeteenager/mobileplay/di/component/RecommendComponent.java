package com.codeteenager.mobileplay.di.component;

import com.codeteenager.mobileplay.di.module.RecommendModule;
import com.codeteenager.mobileplay.di.scope.FragmentScope;
import com.codeteenager.mobileplay.ui.fragment.RecommendFragment;

import dagger.Component;

/**
 * Created by codeteenager on 2017/8/31.
 */
@FragmentScope
@Component(modules = RecommendModule.class, dependencies = AppComponent.class)
public interface RecommendComponent {
    void inject(RecommendFragment fragment);
}
