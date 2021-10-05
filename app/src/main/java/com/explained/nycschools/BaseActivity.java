package com.explained.nycschools;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.explained.nycschools.vm.BaseViewModel;

import dagger.android.AndroidInjection;

abstract public class BaseActivity<T extends BaseViewModel, M> extends AppCompatActivity {

    protected T viewModel;
    protected abstract Class<T> getViewModelClass();
    protected abstract M getManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(getViewModelClass());
        getLifecycle().addObserver(viewModel);
        viewModel.setManager(getManager());
    }
}
