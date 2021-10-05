package com.explained.nycschools.views.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.explained.nycschools.databinding.ViewSchoolRowBinding;
import com.explained.nycschools.models.SchoolInfo;
import com.explained.nycschools.vm.MainViewModel;

import org.jetbrains.annotations.NotNull;

public class SchoolItemViewHolder extends RecyclerView.ViewHolder {

    private ViewSchoolRowBinding view;

    public SchoolItemViewHolder(@NonNull @NotNull ViewSchoolRowBinding view) {
        super(view.getRoot());
        this.view = view;
    }

    public void bind(SchoolInfo schoolInfo, MainViewModel viewModel) {
        view.setSchool(schoolInfo);
        view.setMainVm(viewModel);
    }
}
