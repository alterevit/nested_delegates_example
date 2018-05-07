package com.example.ruslankushaliev.nestedadapter.ui.template.delegateadapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

interface IDelegateAdapter {

    fun onCreateViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder
    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: DelegateViewType)
}

interface DelegateViewType {
    val viewType: Int
}

typealias Delegate = Pair<IDelegateAdapter, Int>