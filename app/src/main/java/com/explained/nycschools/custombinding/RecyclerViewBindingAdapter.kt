package com.explained.nycschools.custombinding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewBindingAdapter {
    companion object {

        @JvmStatic
        @BindingAdapter("itemDivider")
        fun setItemDecorator(recyclerView: RecyclerView, decoration: DividerItemDecoration) {
            recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
            recyclerView.addItemDecoration(decoration)
        }
    }
}