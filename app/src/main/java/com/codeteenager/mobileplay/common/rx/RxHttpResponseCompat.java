package com.codeteenager.mobileplay.common.rx;


import com.codeteenager.mobileplay.bean.BaseBean;
import com.codeteenager.mobileplay.common.exception.ApiException;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by wangrui on 2017/9/1.
 */

public class RxHttpResponseCompat {
    public static <T> Observable.Transformer<BaseBean<T>, T> compatResult() {
        return new Observable.Transformer<BaseBean<T>, T>() {
            @Override
            public Observable<T> call(Observable<BaseBean<T>> baseBeanObservable) {
                return baseBeanObservable.flatMap(new Func1<BaseBean<T>, Observable<T>>() {
                    @Override
                    public Observable<T> call(final BaseBean<T> tBaseBean) {
                        if (tBaseBean.success()) {
                            Observable.create(new Observable.OnSubscribe<T>() {

                                @Override
                                public void call(Subscriber<? super T> subscriber) {
                                    try {
                                        subscriber.onNext(tBaseBean.getData());
                                        subscriber.onCompleted();
                                    } catch (Exception e) {
                                        subscriber.onError(e);
                                    }

                                }
                            });
                        } else {
                            Observable.error(new ApiException(tBaseBean.getStatus(), tBaseBean.getMessage()));
                        }
                        return null;
                    }
                });
            }
        };
    }
}
