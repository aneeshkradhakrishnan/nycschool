package com.explained.nycschools.vm;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ViewModel;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

public abstract class BaseViewModel<M> extends ViewModel implements LifecycleObserver {

    private CompositeDisposable lifeCycleSubscriptions = new CompositeDisposable();
    protected M manager;

    public void setManager(M vmManager) {
        this.manager = vmManager;
    }

    protected void subscribeOnLifeCycle(Disposable disposable) {
        lifeCycleSubscriptions.add(disposable);
    }

    @Override
    protected void onCleared() {
        lifeCycleSubscriptions.clear();
    }
}
