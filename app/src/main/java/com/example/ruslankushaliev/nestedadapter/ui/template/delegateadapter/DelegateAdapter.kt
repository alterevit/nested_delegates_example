package com.example.ruslankushaliev.nestedadapter.ui.template.delegateadapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

interface DelegateAdapter {

    fun onCreateViewHolder(viewGroup: ViewGroup): RecyclerView.ViewHolder
    fun onBindViewHolder(baseViewHolder: RecyclerView.ViewHolder, item: Any)

    fun isForItem(item: Any) : Boolean

}