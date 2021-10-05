package com.explained.nycschools.vm;

import androidx.databinding.ObservableField;

import com.explained.nycschools.manager.SchoolDetailsVmManager;
import com.explained.nycschools.models.SatResult;

public class SchoolDetailsViewModel extends BaseViewModel<SchoolDetailsVmManager> {

    public final ObservableField<SatResult> result = new ObservableField<>();

    public void getSatResults(String dbn) {
        subscribeOnLifeCycle(manager.getSatResult(dbn)
                .subscribe(this::setSatResult, this::handleException));
    }

    private void setSatResult(SatResult result) {
        this.result.set(result);
    }

    private void handleException(Throwable t) {
    }
}
