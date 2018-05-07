package com.example.ruslankushaliev.nestedadapter.ui.entity

import com.example.ruslankushaliev.nestedadapter.NESTED_LEVEL
import com.example.ruslankushaliev.nestedadapter.TOP_LEVEL
import com.example.ruslankushaliev.nestedadapter.ui.template.delegateadapter.DelegateViewType

data class Top(
        val tittle: String,
        val delegates: List<DelegateViewType>
) : DelegateViewType {
    override val viewType: Int get() = TOP_LEVEL
}

data class Nested(
        val tittle: String
) : DelegateViewType {
    override val viewType: Int get() = NESTED_LEVEL
}