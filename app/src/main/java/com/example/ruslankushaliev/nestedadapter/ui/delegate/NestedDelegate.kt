package com.example.ruslankushaliev.nestedadapter.ui.delegate

import com.example.ruslankushaliev.nestedadapter.R
import com.example.ruslankushaliev.nestedadapter.ui.entity.Nested
import com.example.ruslankushaliev.nestedadapter.ui.template.delegateadapter.BaseDelegateAdapter
import kotlinx.android.synthetic.main.delegate_nested.*

class NestedDelegate : BaseDelegateAdapter<Nested>() {

    override val itemLayoutId: Int get() = R.layout.delegate_nested

    override fun BaseViewHolder.onBind(model: Nested) {
        button.text = model.tittle
    }
}