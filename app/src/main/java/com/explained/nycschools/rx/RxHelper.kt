package com.explained.nycschools.rx

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleTransformer
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class RxHelper @Inject constructor() {

    fun <T> singleTransformer(): SingleTransformer<T, T> {
        return SingleTransformer { single -> single.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()) }
    }
}