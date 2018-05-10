package com.example.ruslankushaliev.nestedadapter.ui.template.delegateadapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.extensions.LayoutContainer


abstract class BaseDelegateAdapter<T> : DelegateAdapter {

    protected open val isRecyclable = true

    abstract val itemLayoutId: Int

    abstract fun BaseViewHolder<T>.onBind(model: T)

    @Suppress("UNCHECKED_CAST")
    final override fun onCreateViewHolder(viewGroup: ViewGroup): RecyclerView.ViewHolder =
            BaseViewHolder<T>(viewGroup.inflate(this.itemLayoutId)) { onBind(it) }

    @Suppress("UNCHECKED_CAST")
    final override fun onBindViewHolder(baseViewHolder: RecyclerView.ViewHolder, item: Any) =
            (baseViewHolder as BaseViewHolder<T>).bind(item as T)

    class BaseViewHolder<T>(
            override val containerView: View,
            private val onItemInflated: BaseViewHolder<T>.(T) -> Unit
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(model: T) = onItemInflated(model)
    }

    private fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View =
            LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}
