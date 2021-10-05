package com.explained.nycschools;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;

import com.explained.nycschools.databinding.ActivityMainBinding;
import com.explained.nycschools.manager.MainVmManager;
import com.explained.nycschools.models.SchoolInfo;
import com.explained.nycschools.views.SchoolDetailsActivity;
import com.explained.nycschools.vm.MainViewModel;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<MainViewModel, MainVmManager> {

    @Inject
    MainVmManager manager;

    @Override
    protected Class<MainViewModel> getViewModelClass() {
        return MainViewModel.class;
    }

    @Override
    protected MainVmManager getManager() {
        return manager;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setVm(viewModel);
        viewModel.setItemDivider(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        viewModel.setSchoolItemClickListener(this::startSchoolDetailsActivity);
    }

    private void startSchoolDetailsActivity(SchoolInfo schoolInfo) {
        Intent intent = new Intent(this, SchoolDetailsActivity.class);
        intent.putExtra(SchoolDetailsActivity.SCHOOL_INFO, schoolInfo);
        startActivity(intent);
    }
}