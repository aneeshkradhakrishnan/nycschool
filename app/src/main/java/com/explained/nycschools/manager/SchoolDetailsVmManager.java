package com.explained.nycschools.manager;

import com.explained.nycschools.models.SatResult;
import com.explained.nycschools.rx.RxHelper;
import com.explained.nycschools.services.SchoolService;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class SchoolDetailsVmManager {
    private SchoolService schoolService;
    private RxHelper rxHelper;

    @Inject
    public SchoolDetailsVmManager(SchoolService schoolService,
                                  RxHelper rxHelper) {
        this.schoolService = schoolService;
        this.rxHelper = rxHelper;
    }

    public Single<SatResult> getSatResult(String dbn) {
        return schoolService.getSatResult(dbn)
                .compose(rxHelper.singleTransformer()).map( list -> list.get(0));
    }

}
