package com.explained.nycschools.views;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.explained.nycschools.BaseActivity;
import com.explained.nycschools.R;
import com.explained.nycschools.databinding.ActivitySchoolDetailsBinding;
import com.explained.nycschools.manager.SchoolDetailsVmManager;
import com.explained.nycschools.models.SchoolInfo;
import com.explained.nycschools.vm.SchoolDetailsViewModel;

import javax.inject.Inject;

public class SchoolDetailsActivity extends BaseActivity<SchoolDetailsViewModel, SchoolDetailsVmManager> {

    public static final String SCHOOL_INFO = "schoolInfo";

    @Inject
    SchoolDetailsVmManager manager;

    @Override
    protected Class<SchoolDetailsViewModel> getViewModelClass() {
        return SchoolDetailsViewModel.class;
    }

    @Override
    protected SchoolDetailsVmManager getManager() {
        return manager;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySchoolDetailsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_school_details);
        SchoolInfo schoolInfo = (SchoolInfo) getIntent().getSerializableExtra(SCHOOL_INFO);
        binding.setSchool(schoolInfo);
        binding.setDetailsVm(viewModel);
        viewModel.getSatResults(schoolInfo.getDbn());
    }
}