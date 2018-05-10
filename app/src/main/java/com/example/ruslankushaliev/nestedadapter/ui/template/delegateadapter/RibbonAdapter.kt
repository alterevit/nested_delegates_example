package com.example.ruslankushaliev.nestedadapter.ui.template.delegateadapter

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup


class RibbonAdapter constructor(): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var adapters = SparseArrayCompat<DelegateAdapter>()
    private var elements: ArrayList<Any> = ArrayList()


    constructor(vararg delegates: DelegateAdapter) : this() {
        delegates.forEachIndexed { i, delegate ->
            adapters.put(i, delegate)
        }
    }

    override fun getItemCount() = elements.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            adapters[viewType].onCreateViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
            adapters[getItemViewType(position)].onBindViewHolder(holder, elements[position])

    override fun getItemViewType(position: Int): Int {
        (0 until elements.size).forEach { i ->
            val adapter = adapters[i]
            if (adapter.isForItem(elements[position])) return adapters.keyAt(i)
        }
        throw NullPointerException("Can`t get viewType for position $position")
    }

    fun add(vararg objects: Any) {
        elements.addAll(objects)
        notifyItemRangeChanged(objects.size, elements.size)
    }

    fun refresh(vararg objects: Any) {
        elements.clear()
        notifyDataSetChanged()
        elements.addAll(objects)
        notifyItemRangeInserted(0, objects.size)
    }

    fun refresh(objects: List<Any>) {
        elements.clear()
        notifyDataSetChanged()
        elements.addAll(objects)
        notifyItemRangeInserted(0, objects.size)
    }

}
