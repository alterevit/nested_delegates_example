package com.example.ruslankushaliev.nestedadapter.ui.template.delegateadapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.extensions.LayoutContainer


abstract class BaseDelegateAdapter<in T : DelegateViewType> : DelegateAdapter {

    protected open val isRecyclable = true

    abstract val itemLayoutId: Int

    abstract fun BaseViewHolder.onBind(model: T)

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
            BaseViewHolder(parent.inflate(itemLayoutId),
                    { model -> this.onBind(model as T) })

    override fun onBindViewHolder(
            holder: BaseViewHolder,
            item: DelegateViewType) {
        holder.bind(item)
    }

    class BaseViewHolder(override val containerView: View,
                         private val onItemInflated: BaseViewHolder.(DelegateViewType) -> Unit) :
            RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(model: DelegateViewType) = onItemInflated(model)
    }

    private fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false, initView: (View.() -> Unit)? = null): View =
            LayoutInflater.from(context).inflate(layoutId, this, attachToRoot).apply {
                if (initView != null) this.initView()
            }
}
