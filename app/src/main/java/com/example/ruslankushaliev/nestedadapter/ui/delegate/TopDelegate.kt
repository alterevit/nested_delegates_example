package com.example.ruslankushaliev.nestedadapter.ui.delegate

import android.support.v7.widget.LinearLayoutManager
import com.example.ruslankushaliev.nestedadapter.R
import com.example.ruslankushaliev.nestedadapter.ui.entity.Top
import com.example.ruslankushaliev.nestedadapter.ui.template.delegateadapter.BaseDelegateAdapter
import com.example.ruslankushaliev.nestedadapter.ui.template.delegateadapter.RibbonAdapter
import kotlinx.android.synthetic.main.delegate_top.*

class TopDelegate(private val delegateListener : (String) -> Unit) : BaseDelegateAdapter<Top>() {

    override val itemLayoutId: Int get() = R.layout.delegate_top

    override fun isForItem(item: Any): Boolean = item is Top

    override fun BaseViewHolder<Top>.onBind(model: Top) {
        tvTittle.text = model.tittle
        rvNestedDelegates.layoutManager = LinearLayoutManager(itemView.context).apply {
            orientation = LinearLayoutManager.HORIZONTAL
        }
        rvNestedDelegates.adapter = RibbonAdapter(NestedDelegate(delegateListener)).apply {
            refresh(model.delegates)
        }
    }
}