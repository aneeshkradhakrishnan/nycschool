package com.explained.nycschools.vm;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.DividerItemDecoration;

import com.explained.nycschools.manager.MainVmManager;
import com.explained.nycschools.models.SchoolInfo;
import com.explained.nycschools.views.adapters.SchoolListAdapter;

import java.util.List;


public class MainViewModel extends BaseViewModel<MainVmManager> {

    private static final String TAG = MainViewModel.class.getSimpleName();
    private DividerItemDecoration itemDivider;
    private SchoolListAdapter adapter;
    private SchoolItemClickListener clickListener;

    public void setSchoolItemClickListener(SchoolItemClickListener listener) {
        this.clickListener = listener;
    }

    public void setItemDivider(DividerItemDecoration dividerItemDecoration) {
        this.itemDivider = dividerItemDecoration;
    }

    public DividerItemDecoration getItemDivider() {
        return this.itemDivider;
    }

    public SchoolListAdapter getAdapter() {
        return this.adapter;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        this.adapter = manager.getSchoolListAdapter();
        subscribeOnLifeCycle(manager.getSchoolInfoList()
                .subscribe(this::setSchoolInfo, this::handleException));
    }

    private void setSchoolInfo(List<SchoolInfo> list) {
        adapter.setData(list);
        adapter.setMainViewModel(this);
    }

    private void handleException(Throwable t) {
    }

    public void itemClicked(SchoolInfo schoolInfo) {
        clickListener.onClick(schoolInfo);
    }

    @FunctionalInterface
    public interface SchoolItemClickListener {
        void onClick(SchoolInfo schoolInfo);
    }
}
