package com.explained.nycschools.views.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.explained.nycschools.databinding.ViewSchoolRowBinding;
import com.explained.nycschools.models.SchoolInfo;
import com.explained.nycschools.vm.MainViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class SchoolListAdapter extends RecyclerView.Adapter<SchoolItemViewHolder> {

    private MainViewModel viewModel;

    @Inject
    public SchoolListAdapter() {
    }

    private List<SchoolInfo> data = new ArrayList();

    @NonNull
    @NotNull
    @Override
    public SchoolItemViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new SchoolItemViewHolder(ViewSchoolRowBinding.inflate(inflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SchoolItemViewHolder holder, int position) {
        holder.bind(data.get(position), viewModel);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setMainViewModel(MainViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void setData(List<SchoolInfo> list) {
        if(null == list || list.isEmpty()){
            return;
        }
        data.clear();
        data.addAll(list);
        notifyDataSetChanged();
    }
}
