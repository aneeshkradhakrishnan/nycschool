package com.explained.nycschools.manager;

import com.explained.nycschools.models.SchoolInfo;
import com.explained.nycschools.rx.RxHelper;
import com.explained.nycschools.services.SchoolService;
import com.explained.nycschools.views.adapters.SchoolListAdapter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class MainVmManager {

    private SchoolService schoolService;
    private SchoolListAdapter schoolListAdapter;
    private RxHelper rxHelper;

    @Inject
    public MainVmManager(SchoolService schoolService,
                         SchoolListAdapter schoolListAdapter,
                         RxHelper rxHelper) {
        this.schoolService = schoolService;
        this.schoolListAdapter = schoolListAdapter;
        this.rxHelper = rxHelper;
    }

    public SchoolListAdapter getSchoolListAdapter() {
        return this.schoolListAdapter;
    }

    public Single<List<SchoolInfo>> getSchoolInfoList() {
        return schoolService.getList().compose(rxHelper.singleTransformer());
    }
}
