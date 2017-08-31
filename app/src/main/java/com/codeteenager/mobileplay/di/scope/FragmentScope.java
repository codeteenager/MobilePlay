package com.codeteenager.mobileplay.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by codeteenager on 2017/8/31.
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface FragmentScope {
}
